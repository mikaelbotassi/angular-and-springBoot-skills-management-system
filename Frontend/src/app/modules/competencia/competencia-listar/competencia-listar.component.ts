import { DialogModule } from 'primeng/dialog';
import { ConfirmationService } from 'primeng/api';
import { FormCompetenciaModalComponent } from './../form-competencia/form-competencia-modal.component';
import { DialogService } from 'primeng/dynamicdialog';
import { Component, OnInit, ViewChild} from '@angular/core';

import { CompetenciaService } from '../service/competencia.service';
import { CompetenciaModel } from '../models/competencia.model';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { MessageService, ConfirmDialog } from 'primeng';

const URL_COMPETENCIA:string = 'competencia';
@Component({
  selector: 'app-competencia-listar',
  templateUrl: './competencia-listar.component.html',
  styleUrls: ['./competencia-listar.component.scss']
})
export class CompetenciaListarComponent implements OnInit {

    @ViewChild('dialogCompetencia') dialogAlterar: DialogModule;

    @BlockUI() block: NgBlockUI;
    competenciasTotal:CompetenciaModel[] = [];
    competenciasFiltrada: CompetenciaModel[] = [];
    display: boolean = false;
    competenciaDetalhada: CompetenciaModel;
    competenciaEditada: CompetenciaModel;

  constructor(private competenciaService: CompetenciaService, private dialogService: DialogService, private messageService:MessageService, private confirmationService: ConfirmationService) {}

  ngOnInit(): void {
    this.listarCompetencias();
  }


  private showSucess(){
    this.messageService.add({severity:'success', summary: 'Sucesso', detail:'Competência Salva'});
  }

  private showSucessDelete(){
    this.messageService.add({severity:'success', summary: 'Sucesso', detail:'Competência deletada'});
  }

  showError(mensagem: string) {
    this.messageService.add({severity:'error', summary: 'Erro', detail:mensagem});
}

  listarCompetencias(){

    this.block.start('Carregando...')
    this.competenciaService.obterTodasCompetenciasComURL(URL_COMPETENCIA).subscribe(competencias => {
        this.competenciasTotal = competencias;
        this.competenciasFiltrada = competencias;
    })
    this.confirmationService.close();
    this.block.stop();
  }

  obterCompetencias(filtro){

    if(filtro == undefined || filtro.trim() == ''){
        this.competenciasFiltrada = this.competenciasTotal;
        return;
    }

    this.competenciasFiltrada = this.competenciasTotal.filter((competencia) =>
        competencia.nome.toLowerCase().indexOf(filtro.toLowerCase()) >= 0 || competencia.id === Number(filtro));

  }

  showDialog(competencia: CompetenciaModel){
        this.competenciaDetalhada = competencia;
        this.display = true;
  }

  showDialogEdit(isNovo:boolean){

        this.display = false;
        if(isNovo === true) {
            const ref = this.dialogService.open(FormCompetenciaModalComponent, {

                header: 'CADASTRAR COMPETENCIA',
                width: '600px',
                height:'500px',
                contentStyle: { "overflow": "auto"},
                data: {}

            })

            ref.onClose.subscribe((salvou: boolean)=>{
                if(salvou){
                    this.showSucess();
                    this.listarCompetencias();
                }
            })
            return;
        }

        const ref = this.dialogService.open(FormCompetenciaModalComponent, {

            header: ' Edição ' + this.competenciaDetalhada.nome,
            width: '600px',
            height:'500px',
            contentStyle: { "overflow": "auto"},
            data: {competencia: this.competenciaDetalhada}

        })

        ref.onClose.subscribe((salvou: boolean)=>{
            if(salvou){
                this.showSucess();
                this.listarCompetencias();
            }
        })
    }

    deletarCompetencia(competencia: CompetenciaModel): void{
        this.confirmationService.confirm({
            message: 'Tem certeza que deseja excluir essa turma? essa ação não poderá ser desfeita',
            header: 'Confirmação',
            icon: 'pi pi-exclamation-triangle',
            accept: () => this.callDeletarCompetencia(competencia)
          });
    }

    callDeletarCompetencia(competencia: CompetenciaModel){
        this.competenciaService.deletarCompetencia(competencia.id).subscribe(()=>
        {
            this.showSucessDelete();
            this.listarCompetencias();
            this.display = false;
        },erro => {
            switch(erro.status) {
                case 400:
                    
                        this.showError(erro.error.ERRORS);
              }
        } )
    }


}
