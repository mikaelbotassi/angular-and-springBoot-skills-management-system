import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorFormComponent } from './components/colaborador-lista/colaborador-form/colaborador-form.component';
import { ColaboradorService } from './service/colaborador.service';
import { ButtonModule, CalendarModule, CheckboxModule, DialogModule, Dropdown, DropdownModule, FileUploadModule, Footer, InputMaskModule, InputText, InputTextModule, ToastModule } from 'primeng';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CompetenciaService } from '../competencia/service/competencia.service';
import { SharedModule } from 'src/app/shared/shared.module';
import { ColaboradorListaComponent } from './components/colaborador-lista/colaborador-lista.component';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {ConfirmationService} from 'primeng/api';
import { cpf } from 'cpf-cnpj-validator'; 


@NgModule({
  declarations: [
    ColaboradorListaComponent,
    ColaboradorFormComponent,
  ],
  imports: [
    CommonModule,
    ColaboradorRoutingModule,
    DialogModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    InputTextModule,
    CalendarModule,
    DropdownModule,
    CheckboxModule,
    SharedModule,
    InputMaskModule,
    FileUploadModule,
    ToastModule,
    ConfirmDialogModule,
  ],
  providers: [
    ColaboradorService,
    CompetenciaService,
    ConfirmationService,
  ]
})
export class ColaboradorModule { }
