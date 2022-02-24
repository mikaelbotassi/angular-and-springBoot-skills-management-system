import { FormCompetenciaModalComponent } from './../form-competencia/form-competencia-modal.component';
import { DialogService } from 'primeng/dynamicdialog';
import { Component, OnInit, Output } from '@angular/core';

import { CompetenciaService } from '../service/competencia.service';
import { CompetenciaModel } from '../models/competencia.model';
import { BlockUI, NgBlockUI } from 'ng-block-ui';

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

  constructor(private competenciaService: CompetenciaService, private dialogService: DialogService) {}

  ngOnInit(): void {
    this.listarCompetencias();
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

  showDialogEdit(){

        this.display = false;

        const ref = this.dialogService.open(FormCompetenciaModalComponent, {

            header: this.competenciaDetalhada.nome + ' EDIT',
            width: '40%',
            contentStyle: { "overflow": "auto"},
            data: {competencia: this.competenciaDetalhada}

        })

        ref.onClose.subscribe((competencia: CompetenciaModel)=>{
            if(competencia){
                this.listarCompetencias();
            }
        })
  }


}
