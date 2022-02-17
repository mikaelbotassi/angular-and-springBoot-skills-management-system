import { Component, OnInit } from '@angular/core';

import { CompetenciaService } from '../service/competencia.service';
import { CompetenciaModel } from '../models/competencia.model';

@Component({
  selector: 'app-competencia-listar',
  templateUrl: './competencia-listar.component.html',
  styleUrls: ['./competencia-listar.component.css']
})
export class CompetenciaListarComponent implements OnInit {

    competencias:CompetenciaModel[] = [];

  constructor(private competenciaService: CompetenciaService) {}

  ngOnInit(): void {
    this.listarCompetencias();
  }

  listarCompetencias(){
    this.competenciaService.obterTodasCompetenciasComURL('competencia').subscribe(competencias => {
        this.competencias = competencias;
        console.log(this.competencias);
    })
  }

}
