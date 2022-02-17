import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CompetenciaRoutingModule } from './competencia-routing.module';
import { CompetenciaListarComponent } from './competencia-listar/competencia-listar.component';
import {CardModule} from 'primeng/card';
import { CompetenciaService } from './service/competencia.service';
import {InputTextModule} from 'primeng/inputtext';

@NgModule({
  declarations: [CompetenciaListarComponent],
  imports: [
    CommonModule,
    CardModule,
    SharedModule,
    InputTextModule,
    CompetenciaRoutingModule,
  ],
  exports:[CompetenciaListarComponent],
  providers: [CompetenciaService]
})
export class CompetenciaModule { }
