import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MessageService, SelectItem } from 'primeng/api';
import { CadastrarCompetenciaModel } from 'src/app/modules/competencia/models/cadastro-competencia.model';
import { CompetenciaService } from 'src/app/modules/competencia/service/competencia.service';
import { SenioridadeModel } from 'src/app/shared/model/senioridade.model';
import { CadastrarColaboradorModel } from '../../../models/cadastro-colaborador.model';
import { ColaboradorService } from '../../../service/colaborador.service';

@Component({
  selector: 'app-colaborador-form',
  templateUrl: './colaborador-form.component.html',
  styleUrls: ['./colaborador-form.component.css']
})
export class ColaboradorFormComponent implements OnInit {

  file : FileReader = new FileReader(); 

  colaborador : CadastrarColaboradorModel;

  formBuilder : FormBuilder = new FormBuilder();

  formGroup : FormGroup;

  image;


  listaCompetencia : Array<CadastrarCompetenciaModel> = new Array(); 

  listaCompetenciaSelecionado : Array<CadastrarCompetenciaModel> = new Array();

  listaSenioridade : Array<SenioridadeModel> = new Array();

  dropdownCompetencia : SelectItem[];

  dropdownNivel : SelectItem[] = [
    {value :1,label :  "Júnior"},
    {value :2, label : "Pleno"},
    {value :3, label : "Sênior"}
  ];

  competenciaId : number;
  nivelId : number;

  dropdownSenioridade : SelectItem[];

  constructor(private _colaborador : ColaboradorService,
              private _competencia : CompetenciaService,
              private _messageService: MessageService) { }

  ngOnInit(): void {
    this.buscarCompetencia();
    this.criarFormulario();

    this.criaDropdownSenioridade();

  }

  adicionarListaCompetencia() : void {
    this.listaCompetenciaSelecionado.push(new CadastrarCompetenciaModel(this.competenciaId, '', this.nivelId))
    console.log(this.competenciaId);
  }

  public uploadImagem(event) : void{
    this.image = event.currentFiles[0].objectURL;
    this.file.readAsBinaryString(event.currentFiles[0]);
    this.file.onload = () => this.converterArquivo()
  }

  public converterArquivo(): void {
    this.formGroup.get('foto').setValue(btoa(this.file.result.toString()));
  }


  public criaDropdownSenioridade() : void{
    this.listaSenioridade = JSON.parse(localStorage.getItem('senioridade'));
    
    this.dropdownSenioridade = this.listaSenioridade.map(
      item => ({
        label : item.descricao,
        value : item.id,
        items : []
      })
    )

  }

  public inserirColaborador() : void {
    this.listaCompetenciaSelecionado.forEach(item => {
      item.nivel = 1
    })

    this.formGroup.get('competencia').setValue(this.listaCompetenciaSelecionado);

    this.colaborador = this.formGroup.getRawValue();

      this._colaborador.inserir(this.colaborador).subscribe(
        res => {
          this._messageService.add({severity:'success', summary:'Sucesso ao Inserir', 
                                    detail:'O Colaborador e suas Competências foram inseridos com sucesso!'})
        },
        err => {
          this._messageService.add({severity:'error', summary:'Ocorreu um error na busca', 
          detail:'Error ao buscar!'})
        },
    )
                                                    
  }

  public buscarCompetencia(): void {
    this._competencia.obterCompetenciasDropdown('competencia').subscribe(
      res => {
        this.listaCompetencia = res
        this.dropdownCompetencia = res.map(
            item => ({
              label : item.nome,
              value : item.id
            })
          )
        },
      err => {
        this._messageService.add({severity:'error', summary:'Ocorreu um error na busca', 
                                  detail:'Error ao buscar!'})
      }
    )
  }

  public criarFormulario() : void{
    this.formGroup = this.formBuilder.group({
      nome : ['', [Validators.required]],

      sobrenome : ['', [Validators.required]],
      
      cpf : ['', [Validators.required, Validators.maxLength(11), Validators.minLength(11)]],
    
      email : ['', [Validators.required, Validators.email]],
  
      dataNascimento : ['', [Validators.required]],
  
      dataAdmissao : ['', [Validators.required]],
  
      idSenioridade : [null, [Validators.required]],

      competencia : [[]],

      foto : ['']

    })
  }



}
