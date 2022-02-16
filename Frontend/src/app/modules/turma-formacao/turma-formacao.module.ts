import { TurmaFormacaoCrudComponent } from './models/pages/turma-formacao-crud/turma-formacao-crud.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TurmaFormacaoRoutingModule } from './turma-formacao-routing.module';


@NgModule({
  declarations: [TurmaFormacaoCrudComponent],
  imports: [
    CommonModule,
    TurmaFormacaoRoutingModule
  ]
})
export class TurmaFormacaoModule { }
