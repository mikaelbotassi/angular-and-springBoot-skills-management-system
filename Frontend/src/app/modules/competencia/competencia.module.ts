import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DialogService } from 'primeng/dynamicdialog';
import { CategoriaService } from './service/categoria.service';
import { SharedModule } from './../../shared/shared.module';
import { FormCompetenciaComponent } from './form-competencia/form-competencia.component';
import { CompetenciaRoutingModule } from './competencia-routing.module';
import { CompetenciaListarComponent } from './competencia-listar/competencia-listar.component';
import {CardModule} from 'primeng/card';
import { CompetenciaService } from './service/competencia.service';
import {InputTextModule} from 'primeng/inputtext';
import { FormCompetenciaModalComponent } from './form-competencia/form-competencia-modal.component';
@NgModule({
  declarations: [CompetenciaListarComponent, FormCompetenciaComponent, FormCompetenciaModalComponent],
  imports: [
    CommonModule,
    CardModule,
    SharedModule,
    InputTextModule,
    CompetenciaRoutingModule,
  ],
  exports:[CompetenciaListarComponent],
  providers: [CompetenciaService, CategoriaService, DialogService],
  entryComponents:[FormCompetenciaModalComponent]
})
export class CompetenciaModule { }
