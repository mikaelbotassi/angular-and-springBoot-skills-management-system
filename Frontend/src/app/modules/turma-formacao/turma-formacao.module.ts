import { BlockUIService, BlockUIModule } from 'ng-block-ui';
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
import {CardModule} from 'primeng/card';
import { turmaFormacaoService } from './service/turma-formacao.service';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {TooltipModule} from 'primeng/tooltip';
import {AutoCompleteModule} from 'primeng/autocomplete';
import {CheckboxModule} from 'primeng/checkbox';
import {DropdownModule} from 'primeng/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {CalendarModule} from 'primeng/calendar';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import { TurmaFormacaoAlterarModalComponent } from './models/pages/turma-formacao-crud/turma-formacao-form-modal/turma-formacao-form-modal.component';



@NgModule({
  declarations: [TurmaFormacaoCrudComponent, TurmaFormacaoAlterarModalComponent],
  imports: [
    CommonModule,
    TurmaFormacaoRoutingModule,
    SplitButtonModule,
    ButtonModule,
    DialogModule,
    InputTextModule,
    InputTextareaModule,
    FieldsetModule,
    CardModule,
    TableModule,
    ToastModule,
    TooltipModule,
    AutoCompleteModule,
    CheckboxModule,
    DropdownModule,
    FormsModule,
    CalendarModule,
    ConfirmDialogModule,
    ReactiveFormsModule,
  ],
  exports:[TurmaFormacaoCrudComponent],
  providers: [turmaFormacaoService, ConfirmationService, BlockUIService]
})
export class TurmaFormacaoModule { }
