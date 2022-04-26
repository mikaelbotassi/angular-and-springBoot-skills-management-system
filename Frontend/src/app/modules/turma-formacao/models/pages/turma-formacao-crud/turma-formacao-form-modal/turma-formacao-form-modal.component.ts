import { BlockUIService } from 'ng-block-ui';
import { finalize } from 'rxjs/operators';
import { ConfirmationService } from 'primeng/api';
import { ColaboradorListaModel } from '../../../ColaboradorListaModel';
import { CompetenciaListaModel } from '../../../CompetenciaListaModel';
import { TurmaFormacaoCrudComponent } from '../turma-formacao-crud.component';
import { TurmaColaboradorCompetenciaModel } from 'src/app/modules/turma-colaborador-competencia/models/TurmaColaboradorCompetenciaModel';
import { ConfirmDialog, MessageService } from 'primeng';
import { turmaFormacaoService } from '../../../../service/turma-formacao.service';
import { TurmaColaboradorCompetenciaNivelModel } from '../../../../../turma-colaborador-competencia/models/TurmaColaboradorCompetenciaNivelModel';
import { Component, OnInit, Output, EventEmitter, ViewChild } from '@angular/core';
import { TurmaFormacaoModel } from '../../../TurmaFormacaoModel';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-turma-formacao-form-modal',
  templateUrl: './turma-formacao-form-modal.component.html',
  styleUrls: ['./turma-formacao-form-modal.component.scss']
})
export class TurmaFormacaoAlterarModalComponent implements OnInit {

  @ViewChild('cd') confirmDialog: ConfirmDialog;

  @Output() atualizaLista: EventEmitter<null> = new EventEmitter();

  colaboradorCompetenciaHolder: TurmaColaboradorCompetenciaNivelModel[] = [];
  colaboradoresTotal: ColaboradorListaModel[] = [];
  competenciasTotal: CompetenciaListaModel[] = [];
  display: boolean = false;

  formBuilder: FormBuilder = new FormBuilder();

  formTurma: FormGroup;
  formCompetencias: FormGroup;

  constructor(private turmaFormacaoService: turmaFormacaoService, private messageService: MessageService,
     public confirmationService: ConfirmationService, private blockUIService: BlockUIService) { }

  ngOnInit(): void {
    this.criarFormularioTurma();
        
  }




  //mensagens

  private showSucess(): void {
    this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Turma Alterada' });
  }

  private showSucessDelete(): void {
    this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Colaborador foi retirado da turma' });
  }

  private showSucessIniciada(): void {
    this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Turma iniciada' });
  }

  private showSucessFinalizada(): void {
    this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Turma finalizadda' });
  }

  //init

  iniciarTela(turma: TurmaFormacaoModel): void {
    if(!(turma)){
      this.display = true;
      this.listarColaboradoresAutoComplete();
      this.listarCompetenciasAutoComplete();
      return;
    }    
    let turmaObj: TurmaFormacaoModel
    
    this.blockUIService.start("");
    
    this.turmaFormacaoService.procurarTurmaPorId(turma.id).pipe(finalize(() => console.log('') )).subscribe(turmaRetorno => {
      turmaObj = turmaRetorno
      this.formTurma.patchValue(turmaObj);
      this.display = true;
      this.listarTurmaColaboradorCompetencia(turmaObj.id);
      this.listarColaboradoresAutoComplete();
      this.listarCompetenciasAutoComplete();
    });

  }

  atualizarTela(turma: TurmaFormacaoModel){
    this.formTurma.patchValue(turma);
  }


  listarColaboradoresAutoComplete(): void {
    this.turmaFormacaoService.listarColaborador().subscribe(colaborador => {
      this.colaboradoresTotal = colaborador;
    })

  }

  listarCompetenciasAutoComplete(): void {
    this.turmaFormacaoService.listarCompetencia().subscribe(competencia => {
      this.competenciasTotal = competencia;
    })


  }

  public criarFormularioTurma(): void {
    let formCompetencias = this.formBuilder.group({

      colaboradorDropDown: [null, [Validators.required]],

      competenciaDropDown: [null, [Validators.required]],


    })

    this.formTurma = this.formBuilder.group({
      id: [null],

      nome: [null, [Validators.required]],

      descricao: [null, [Validators.required]],

      statusId: [null],

      inicio: [null],

      formCompetencias

    })

    this.formCompetencias = formCompetencias;
  }

  //desabilitar

  desabilitarSubmitTurma(): boolean {
    if (this.formTurma.get('statusId').value == 3) {
      return true;
    }
    if (!(this.formTurma.get('nome').valid && this.formTurma.get('descricao').valid)) {
      return true;
    }

    return false;
  }


  desabilitarSubmitTurmaIniciando(): boolean {
    if (!(this.validacaoTurma())) {
      return true;
    }
    if (this.desabilitarSubmitTurma()) {
      return true;
    }
    if (this.formTurma.get('statusId').value == 2) {
      return true;
    }
    if (this.formTurma.get('statusId').value == 3) {
      return true;
    }
    return false;
  }

  desabilitarFinalizarTurma(): boolean {
    if (this.formTurma.get('statusId').value != 2) {
      return true;
    }
    if(!(this.validacaoTurma())){
      return true;
    }
    return false;
  }

  desabilitarTurmaConcluida(): boolean {
    if(this.formTurma.get('statusId').value == 3){
      return true;
    }
    return false;
  }

  validacaoTurma(): boolean {
    let colaboradorCompetenciaMaterias: number[] = [];
    let validador: boolean = true;

    if (this.colaboradorCompetenciaHolder.length == 0) {
      return false;
    }

    this.colaboradorCompetenciaHolder.forEach((colaborador) => {
      if (colaborador.nivel == 3) {
        colaboradorCompetenciaMaterias.push(colaborador.competenciaId);
      }
    });

    if (colaboradorCompetenciaMaterias.length == 0) {
      return false;
    }

    this.colaboradorCompetenciaHolder.forEach((colaborador) => {
      if ((((colaborador.nivel != 3) && (colaboradorCompetenciaMaterias.indexOf(colaborador.competenciaId) == -1)) || (colaborador == undefined))) {
        validador = false;
      }
    });

    return validador;
  }




  finalizarTurma(): void {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja finalizar a turma? nenhuma alteração poderá ser feita apos finalizar a turma',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      accept: () => this.callFinalizarTurma(this.formTurma.getRawValue())
    });
  }

  callFinalizarTurma(turma: TurmaFormacaoModel): void {
    turma.statusId = 3;
    turma.termino = new Date;
    this.callAlterarTurma(turma);

    this.listarTurmaColaboradorCompetencia(turma.id);
      this.turmaFormacaoService.subirNivelColaboradorCompetencia(this.colaboradorCompetenciaHolder).subscribe(retorno => {
        this.display = false;
      })
    
  }

  //listar

  listarTurmaColaboradorCompetencia(turmaId: number): void {
    this.turmaFormacaoService.listarTurmaColaboradorCompetencia(turmaId).subscribe(colaborador => {
      this.colaboradorCompetenciaHolder = colaborador;
    })
  }

  //alterar

  submitTurma(): void {
    if (this.formTurma.get('id').value){
      this.alterarTurma();
      return;
    }
    this.inserirTurma();
  }

  inserirTurma(): void {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja cadastrar essa turma?',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      accept: () => this.callInserirTurma(this.formTurma.getRawValue())
    });
  }

  callInserirTurma(turma: TurmaFormacaoModel){
    turma.statusId = 1;
    this.turmaFormacaoService.registrarTurma(turma).subscribe(
      turma => {
        this.showSucess();
        this.inserirListaColaboradorSemLimpar(turma.id);
        this.atualizarTela(turma);
      }
    );
  }

  alterarTurma(): void {
    if (this.formTurma.get('id').value){

    this.confirmationService.confirm({
      message: 'Tem certeza que deseja alterar?',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      accept: () => this.callAlterarTurma(this.formTurma.getRawValue())
    });
  }
  }

  callAlterarTurma(turma: TurmaFormacaoModel): void {
    this.turmaFormacaoService.alterarTurma(turma).subscribe(
      turma => {
        this.showSucess();
        this.inserirListaColaboradorSemLimpar(turma.id);
        this.atualizarTela(turma);
      }
    );
    

    
  }

  submitTurmaIniciando():void{
    if (this.formTurma.get('id').value){
      this.alterarTurmaIniciando();
      return;
    }
    this.inserirTurmaIniciando();
  }

inserirTurmaIniciando(){
  this.confirmationService.confirm({
    message: 'Tem certeza que deseja iniciar essa turma? Após o início da turma não poderá retirar instrutores ou adicionar colaboradores',
    header: 'Confirmação',
    icon: 'pi pi-exclamation-triangle',
    accept: () => this.callInserirTurmaIniciando(this.formTurma.getRawValue())
  });

}

callInserirTurmaIniciando(turma:TurmaFormacaoModel){
  turma.statusId = 2;
  turma.inicio = new Date();
  this.turmaFormacaoService.registrarTurma(turma).subscribe(
    turma => {
      this.iniciarTurma(turma);
      this.inserirListaColaboradorSemLimpar(turma.id);
      this.atualizarTela(turma);
    }
  );
}


  alterarTurmaIniciando(): void {
    this.confirmationService.confirm({
      message: 'Tem certeza que deseja iniciar essa turma? Após o início da turma não poderá retirar instrutores ou adicionar colaboradores',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      accept: () => this.callAlterarTurmaIniciando(this.formTurma.getRawValue())
    });

  }

  callAlterarTurmaIniciando(turma: TurmaFormacaoModel): void {
    this.turmaFormacaoService.alterarTurma(turma).subscribe(
      turma => {
        this.iniciarTurma(turma);
        this.inserirListaColaboradorSemLimpar(turma.id);
        this.atualizarTela(turma);
      }
    );
  }

  limparHolder() {
    this.colaboradorCompetenciaHolder = [];
    this.atualizaLista.emit(null);
    this.criarFormularioTurma();
    this.confirmationService.close();
  }

  inserirListaColaboradorSemLimpar(turmaId: number): void {    
    let turmaColaboradoresTemp: TurmaColaboradorCompetenciaModel[] = [];
    this.turmaFormacaoService.listarTurmaColaboradorCompetencia(turmaId).subscribe(colaboradoresTurma => {
      turmaColaboradoresTemp = colaboradoresTurma;
    });
    this.colaboradorCompetenciaHolder.forEach(colaborador => {
      let turmaTemp = new TurmaColaboradorCompetenciaModel(turmaId, colaborador.colaboradorId, colaborador.competenciaId);
      if (turmaColaboradoresTemp.indexOf(turmaTemp) == -1) {
        this.turmaFormacaoService.registrarTurmaColaboradorCompetencia(turmaTemp).subscribe();
      }
    }


    )
  }

  iniciarTurma(turma: TurmaFormacaoModel): void {
    turma.statusId = 2;
    turma.inicio = new Date();
    this.turmaFormacaoService.alterarTurma(turma).subscribe(
      turma => {
        this.showSucessIniciada();
      }
    );

  }

  inserirColaboradorCompetenciaHolder(): void {
    let colaboradorObj = null;
    let colaboradorDropDown : ColaboradorListaModel =  this.formCompetencias.get('colaboradorDropDown').value
    let competenciaDropDown : CompetenciaListaModel =  this.formCompetencias.get('competenciaDropDown').value
    this.turmaFormacaoService.procurarNivelColaboradorCompetencia(colaboradorDropDown.id, competenciaDropDown.id)
      .subscribe(colaboradorTempAdd => {
        colaboradorObj = colaboradorTempAdd;
        if (colaboradorObj == null) {
          this.turmaFormacaoService.cadastrarColaboradorCompetenciaZero(colaboradorDropDown.id, competenciaDropDown.id).subscribe(temp => {
            this.turmaFormacaoService.procurarNivelColaboradorCompetencia(colaboradorDropDown.id, competenciaDropDown.id).subscribe(colaboradorTemp => {
              if (this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaborador.colaboradorId === colaboradorDropDown.id && colaborador.competenciaId === competenciaDropDown.id) == -1) {
                this.colaboradorCompetenciaHolder.push(colaboradorTemp);
              }
              this.formCompetencias.get('colaboradorDropDown').setValue(null);
              this.formCompetencias.get("competenciaDropDown").setValue(null);
            })
          })
        } else {
          this.turmaFormacaoService.procurarNivelColaboradorCompetencia(colaboradorDropDown.id, competenciaDropDown.id).subscribe(colaboradorTemp => {
            if (this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaborador.colaboradorId === colaboradorDropDown.id && colaborador.competenciaId === competenciaDropDown.id) == -1) {
              this.colaboradorCompetenciaHolder.push(colaboradorTemp);
            }
            this.formCompetencias.get('colaboradorDropDown').setValue(null);
            this.formCompetencias.get("competenciaDropDown").setValue(null);
          })
        }
      }, erro => {

      })
  }

  //deletar
  deletarColaboradorCompetenciaHolderAlt(colaboradorSelecionado: TurmaColaboradorCompetenciaNivelModel): void {
    if (this.formTurma.get('statusId').value === 2) {
      this.confirmationService.confirm({
        message: 'Tem certeza que deseja retirar esse aluno? Ele não poderá ser adicionado a esta turma novamente',
        header: 'Confirmação',
        icon: 'pi pi-exclamation-triangle',
        accept: () => this.deletandoColaboradorCompetenciaHolder(colaboradorSelecionado)
      });
      return;
    }
    this.deletandoColaboradorCompetenciaHolder(colaboradorSelecionado);
  }

  deletandoColaboradorCompetenciaHolder(colaboradorSelecionado: TurmaColaboradorCompetenciaNivelModel): void {
    
    if(!this.formTurma.get('id').value){
      this.colaboradorCompetenciaHolder.splice(this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaboradorSelecionado.colaboradorId === colaborador.colaboradorId && colaborador.competenciaId === colaboradorSelecionado.competenciaId), 1);
      return;
    }
    colaboradorSelecionado.turmaId = this.formTurma.get('id').value;
    if (this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaboradorSelecionado.colaboradorId === colaborador.colaboradorId &&
      colaborador.competenciaId === colaboradorSelecionado.competenciaId) != -1) {
      this.turmaFormacaoService.procurarTurmaColaboradorCompetencia(colaboradorSelecionado.colaboradorId, colaboradorSelecionado.competenciaId, colaboradorSelecionado.turmaId).subscribe(() => {
        this.turmaFormacaoService.deletarTurmaColaboradorCompetencia(colaboradorSelecionado).subscribe(() => {
        });

      }, () => {

      });
    }
    this.colaboradorCompetenciaHolder.splice(this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaboradorSelecionado.colaboradorId === colaborador.colaboradorId && colaborador.competenciaId === colaboradorSelecionado.competenciaId), 1);
    this.showSucessDelete();
  }

  mudarCorColaboradorNivel(nivel: number): any {
    if (nivel === 3)
      return { 'background-color': '#C0C0C0' };

  }


}
