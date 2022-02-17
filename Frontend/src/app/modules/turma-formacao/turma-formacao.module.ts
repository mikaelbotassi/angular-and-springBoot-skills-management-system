import { ButtonModule } from 'primeng/button';
import { TurmaFormacaoCrudComponent } from './models/pages/turma-formacao-crud/turma-formacao-crud.component';
import { NgModule, Output } from '@angular/core';
import { CommonModule } from '@angular/common';


import { TurmaFormacaoRoutingModule } from './turma-formacao-routing.module';
import {SplitButtonModule} from 'primeng/splitbutton';
import {DialogModule} from 'primeng/dialog';
import {InputTextModule} from 'primeng/inputtext';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {FieldsetModule} from 'primeng/fieldset';


@NgModule({
  declarations: [TurmaFormacaoCrudComponent],
  imports: [
    CommonModule,
    TurmaFormacaoRoutingModule,
    SplitButtonModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    InputTextareaModule,
    FieldsetModule
  ]
})
export class TurmaFormacaoModule { }
