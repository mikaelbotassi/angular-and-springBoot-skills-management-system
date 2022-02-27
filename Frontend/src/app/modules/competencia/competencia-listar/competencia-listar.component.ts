import { FormCompetenciaModalComponent } from './../form-competencia/form-competencia-modal.component';
import { DialogService } from 'primeng/dynamicdialog';
import { Component, OnInit} from '@angular/core';

import { CompetenciaService } from '../service/competencia.service';
import { CompetenciaModel } from '../models/competencia.model';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { MessageService } from 'primeng';

const URL_COMPETENCIA:string = 'competencia';
@Component({
  selector: 'app-competencia-listar',
  templateUrl: './competencia-listar.component.html',
  styleUrls: ['./competencia-listar.component.scss']
})
export class CompetenciaListarComponent implements OnInit {

    @BlockUI() block: NgBlockUI;
    competenciasTotal:CompetenciaModel[] = [];
    competenciasFiltrada: CompetenciaModel[] = [];
    display: boolean = false;
    competenciaDetalhada: CompetenciaModel;
    competenciaEditada: CompetenciaModel;

  constructor(private competenciaService: CompetenciaService, private dialogService: DialogService, private messageService:MessageService) {}

  ngOnInit(): void {
    this.listarCompetencias();
  }


  private showSucess(){
    this.messageService.add({severity:'success', summary: 'Sucesso', detail:'Competência Salva'});
  }

  listarCompetencias(){

    this.block.start('Carregando...')
    this.competenciaService.obterTodasCompetenciasComURL(URL_COMPETENCIA).subscribe(competencias => {
        this.competenciasTotal = competencias;
        this.competenciasFiltrada = competencias;
    })
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
        console.log(isNovo);
        if(isNovo === true) {
            const ref = this.dialogService.open(FormCompetenciaModalComponent, {

                header: 'CADASTRAR COMPETENCIA',
                width: '600px',
                height:'500px',
                contentStyle: { "overflow": "auto"},
                data: {}

            })

            ref.onClose.subscribe((competencia: CompetenciaModel)=>{
                if(competencia){
                    this.showSucess();
                    this.listarCompetencias();
                }
            })
            return;
        }

        const ref = this.dialogService.open(FormCompetenciaModalComponent, {

            header: this.competenciaDetalhada.nome + ' EDIT',
            width: '600px',
            height:'500px',
            contentStyle: { "overflow": "auto"},
            data: {competencia: this.competenciaDetalhada}

        })

        ref.onClose.subscribe((competencia: CompetenciaModel)=>{
            if(competencia){
                this.showSucess();
                this.listarCompetencias();
            }
        })
    }
}
