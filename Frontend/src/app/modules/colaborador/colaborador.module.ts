import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorListaComponent } from './components/colaborador-lista/colaborador-lista/colaborador-lista.component';
import { ColaboradorService } from './service/colaborador.service';
import { ButtonModule, CalendarModule, CheckboxModule, DialogModule, Dropdown, DropdownModule, FileUploadModule, Footer, InputMaskModule, InputText, InputTextModule } from 'primeng';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CompetenciaService } from '../competencia/service/competencia.service';
import { SharedModule } from 'src/app/shared/shared.module';


@NgModule({
  declarations: [
    ColaboradorListaComponent,
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
  ],
  providers: [
    ColaboradorService,
    CompetenciaService,
  ]
})
export class ColaboradorModule { }
