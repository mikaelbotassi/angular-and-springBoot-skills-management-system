import { CategoriaService } from './service/categoria.service';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SharedModule } from './../../shared/shared.module';
import { FormCompetenciaComponent } from './form-competencia/form-competencia.component';
import { CompetenciaRoutingModule } from './competencia-routing.module';
import { CompetenciaListarComponent } from './competencia-listar/competencia-listar.component';
import {CardModule} from 'primeng/card';
import { CompetenciaService } from './service/competencia.service';
import {InputTextModule} from 'primeng/inputtext';
import { ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [CompetenciaListarComponent, FormCompetenciaComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CardModule,
    SharedModule,
    InputTextModule,
    CompetenciaRoutingModule,
  ],
  exports:[CompetenciaListarComponent],
  providers: [CompetenciaService, CategoriaService]
})
export class CompetenciaModule { }
