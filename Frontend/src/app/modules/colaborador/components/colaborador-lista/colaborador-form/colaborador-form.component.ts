import { TurmaColaboradorCompetenciaModel } from './../../../../turma-colaborador-competencia/models/TurmaColaboradorCompetenciaModel';
import { CalendarModule } from 'primeng/calendar';
import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { cpf } from 'cpf-cnpj-validator';
import { FileUpload } from 'primeng';
import { MessageService, SelectItem, ConfirmationService } from 'primeng/api';
import { CadastrarCompetenciaModel } from 'src/app/modules/competencia/models/cadastro-competencia.model';
import { CompetenciaService } from 'src/app/modules/competencia/service/competencia.service';
import { SenioridadeModel } from 'src/app/shared/model/senioridade.model';
import { CadastrarColaboradorModel } from '../../../models/cadastro-colaborador.model';
import { ColaboradorService } from '../../../service/colaborador.service';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.scss']
})
export class ColaboradorFormComponent implements OnInit {
  @Output() atualizaListaColaborador: EventEmitter<boolean> = new EventEmitter();

  @ViewChild('upload') uploadImg: FileUpload;

  @ViewChild('dataNascimento') dataNascimentoCalendar: CalendarModule;

  file: FileReader = new FileReader();

  colaborador: CadastrarColaboradorModel;

  formBuilder: FormBuilder = new FormBuilder();

  formColaborador: FormGroup;

  formCompetencias: FormGroup;

  image;

  listaCompetencia: Array<CadastrarCompetenciaModel> = new Array();

  listaCompetenciaSelecionado: Array<CadastrarCompetenciaModel> = new Array();

  listaSenioridade: Array<SenioridadeModel> = new Array();

  competenciaOp: SelectItem[];

  nivelOp: SelectItem[] = [
    { value: 1, label: "1" },
    { value: 2, label: "2" },
    { value: 3, label: "3" }
  ];

  dropdownSenioridade: SelectItem[];

  dataMax: Date;

  rangeAno: String;

  rangeAnoAdm: String;

  br: any;


  constructor(private _colaboradorService: ColaboradorService,
    private _competenciaService: CompetenciaService,
    private _messageService: MessageService,
    private sanitizer: DomSanitizer,
    private confirmationService: ConfirmationService,
    private messageService: MessageService) { }

  ngOnInit(): void {
    this.buscarCompetencia();
    this.criarFormulario();
    this.criaDropdownSenioridade();
    this.calculaDataMin();

    this.br = {
      firstDayOfWeek: 0,
      dayNames: ["Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"],
      dayNamesShort: ["D", "S", "T", "Q", "Q", "S", "S"],
      dayNamesMin: ["D", "S", "T", "Q", "Q", "S", "S"],
      monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
      monthNamesShort: ["Jan", "fev", "Mar", "abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"],
      today: 'hoje',
      clear: 'limpar',
      dateFormat: 'dd/mm/yy',
      weekHeader: 'Sem'
    }


  }

  showError(mensagem: string) {
    this.messageService.add({severity:'error', summary: 'Erro', detail:mensagem});
}

  salvarColaborador(): void {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja salvar esse colaborador?',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      accept: () => this.callSalvarColaborador()
    });


  }

  callSalvarColaborador(){
    if (!this.colaborador) {
      this.inserirColaborador();
      return
    };
    this.atualizarColaborador();
  }

  buscarColaboradorPorId(id: number): void {
    this._colaboradorService.buscarColaboradorPorId(id).subscribe(
      res => {
        this.colaborador = res;
        this.criarFormulario();
        this.formColaborador.patchValue(res);
        this.formColaborador.get('dataNascimento').setValue(this.convertStringDate(res.dataNascimento.toString()));
        this.formColaborador.get('dataAdmissao').setValue(this.convertStringDate(res.dataAdmissao.toString()));
        this.listaCompetenciaSelecionado = res.competencia;
        this.image = this.sanitizer.bypassSecurityTrustUrl('data:image/ext;base64,' + res.foto);
      },
      err => console.error(err)
    )
  }

  limparFormulario(): void {
    
    this.colaborador = new CadastrarColaboradorModel(null, null, null, null, null, null, null, null, null, null);
    this.criarFormulario();
    this.listaCompetenciaSelecionado = [];
    this.image = null;
    this.file = new FileReader();
    this.uploadImg.clear();
  }

  adicionarListaCompetencia(): void {
    let competenciaId: number = this.formCompetencias.get('competenciaDropDown').value;
    let nivelId: number = this.formCompetencias.get('nivelDropDown').value;

    const itemCompetencia = this.competenciaOp.find(item => item.value == competenciaId);
    const nomeCompetencia = !!itemCompetencia ? itemCompetencia.label : "";
    let competenciaSel: CadastrarCompetenciaModel = new CadastrarCompetenciaModel(competenciaId, nomeCompetencia, nivelId);

    if(nivelId == null || competenciaId == null){
      return
    }

    if (this.listaCompetenciaSelecionado.findIndex(competencia => (competencia.id == competenciaSel.id)) == -1) {
      this.listaCompetenciaSelecionado.push(new CadastrarCompetenciaModel(competenciaId, nomeCompetencia, nivelId));
    }
  }

  public uploadImagem(event): void {
    this.image = event.currentFiles[0].objectURL;
    this.file.readAsBinaryString(event.currentFiles[0]);
    this.file.onload = () => this.converterArquivo()
  }

  public converterArquivo(): void {
    this.formColaborador.get('foto').setValue(btoa(this.file.result.toString()));
  }


  public criaDropdownSenioridade(): void {
    this.listaSenioridade = JSON.parse(localStorage.getItem('senioridade'));

    this.dropdownSenioridade = this.listaSenioridade.map(
      item => ({
        label: item.descricao,
        value: item.id,
        items: []
      })
    )

  }

  convertStringDate(strDate: string): Date {
    if (!strDate) { return null; }
    const splittedDate = strDate.split('-').map(e => +e);
    return new Date(splittedDate[0], splittedDate[1] - 1, splittedDate[2]);
  }

  public inserirColaborador(): void {
    this.formColaborador.get('competencia').setValue(this.listaCompetenciaSelecionado);

    this.colaborador = this.formColaborador.getRawValue();

    if (this.testaCPF(this.colaborador.cpf)) {
      this._colaboradorService.inserir(this.colaborador).subscribe(
        res => {
          this._messageService.add({
            severity: 'success', summary: 'Sucesso ao Inserir',
            detail: 'O Colaborador e suas Competências foram inseridos com sucesso!'
          });
          this.atualizaListaColaborador.emit(true);
          this.limparFormulario();

        },
        err => {
          this._messageService.add({
            severity: 'error', summary: 'Ocorreu um error na Inclusão',
            detail: err.error.ERRORS
          })
          this.colaborador = null;
        },

      )
    } else {
      this._messageService.add({
        severity: 'error', summary: 'cpf inválido',
        detail: 'digite um cpf valido'
      })
      this.colaborador = null;
    }



  }

  public atualizarColaborador(): void {
    this.formColaborador.get('competencia').setValue(this.listaCompetenciaSelecionado);

    this.colaborador = this.formColaborador.getRawValue();

    if (this.testaCPF(this.colaborador.cpf)) {
      this._colaboradorService.atualizar(this.colaborador).subscribe(
        res => {
          this._messageService.add({
            severity: 'success', summary: 'Sucesso ao Alterar',
            detail: 'O Colaborador e suas Competências foram alterados com sucesso!'
          });
          this.atualizaListaColaborador.emit(true);
        },
        err => {
          this._messageService.add({
            severity: 'error', summary: 'Ocorreu um error na Alteração',
            detail: err.error.ERRORS
          })
        },
      )
    } else {
      this._messageService.add({
        severity: 'error', summary: 'cpf inválido',
        detail: 'digite um cpf valido'
      })
    }



  }

  public buscarCompetencia(): void {
    this._competenciaService.obterCompetenciasDropdown('competencia').subscribe(
      res => {
        this.listaCompetencia = res
        this.competenciaOp = res.map(
          item => ({
            label: item.nome,
            value: item.id
          })
        )
        
      },
      err => {
        this._messageService.add({
          severity: 'error', summary: 'Ocorreu um error na busca',
          detail: 'Error ao buscar!'
        })
      }
    )
  }

  excluirCompetencia(competenciaId): void {
    let lista: TurmaColaboradorCompetenciaModel[] = [];
    if(this.colaborador == undefined || this.colaborador.id == null){
      this.listaCompetenciaSelecionado = this.listaCompetenciaSelecionado.filter(item => item.id != competenciaId);
      return
    }
    this._colaboradorService.buscarColaboradorEnsinou(this.colaborador.id).subscribe(turma => {
      lista = turma;
      if (lista.findIndex(lista => lista.competenciaId == competenciaId) == -1) {
        this.listaCompetenciaSelecionado = this.listaCompetenciaSelecionado.filter(item => item.id != competenciaId);
        return
      }
this.showError("Esse colaborador esta sendo instrutor dessa materia")

    }, error=> {
    });



  }

  obterDescricaoNivel(nivel) {
    const itemNivel = this.nivelOp.find(item => item.value == nivel);
    return !!itemNivel ? itemNivel.label : "";
  }




  public criarFormulario(): void {
    let formCompetencias = this.formBuilder.group({

      competenciaDropDown: [null],


      nivelDropDown: [null],

    })

    this.formColaborador = this.formBuilder.group({
      id: [0],

      nome: ['', [Validators.required]],

      sobrenome: ['', [Validators.required]],

      cpf: ['', [Validators.required, Validators.maxLength(11), Validators.minLength(11),]],

      email: ['', [Validators.required, Validators.email]],

      dataNascimento: ['', [Validators.required]],

      dataAdmissao: ['', [Validators.required]],

      idSenioridade: [null, [Validators.required]],

      competencia: [[]],

      foto: [null],

      formCompetencias

    })
    this.formCompetencias = formCompetencias;
  }

  testaCPF(cpf): boolean {
    var Soma = 0;
    if (cpf === undefined) {
      return false;
    }
    var strCPF = cpf.replace('.', '').replace('.', '').replace('-', '');
    if (strCPF === '00000000000' || strCPF === '11111111111' || strCPF === '22222222222' || strCPF === '33333333333' ||
      strCPF === '44444444444' || strCPF === '55555555555' || strCPF === '66666666666' || strCPF === '77777777777' || strCPF === '88888888888' ||
      strCPF === '99999999999' || strCPF.length !== 11) {
      return false;
    }

    //Multiplica cada digito por numeros de 1 a 9, soma-os e multiplica-os por 10. Depois, divide o resultado encontrado por 11 para encontrar o resto
    for (let i = 1; i <= 9; i++) {
      Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    }

    var Resto = (Soma * 10) % 11;
    if ((Resto === 10) || (Resto === 11)) {
      Resto = 0;
    }

    if (Resto !== parseInt(strCPF.substring(9, 10))) {
      return false;
    }

    Soma = 0;
    for (let k = 1; k <= 10; k++) {
      Soma = Soma + parseInt(strCPF.substring(k - 1, k)) * (12 - k)
    }

    Resto = (Soma * 10) % 11;
    if ((Resto === 10) || (Resto === 11)) {
      Resto = 0;
    }

    if (Resto !== parseInt(strCPF.substring(10, 11))) {
      return false;
    }

    return true;
  }

  calculaDataMin(): void {
    let atual = new Date();
    let anoFim = atual.getFullYear() - 18;
    let anoInicio = atual.getFullYear() - 85;
    this.rangeAno = anoInicio.toString() + ':' + anoFim.toString();
    this.dataMax = new Date();
    this.dataMax.setFullYear(this.dataMax.getFullYear() - 18);
    this.rangeAnoAdm = anoInicio.toString() + ':' + new Date().getFullYear().toString();

  }

}
