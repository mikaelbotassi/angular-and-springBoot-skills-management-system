import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorListaComponent } from './components/colaborador-lista/colaborador-lista/colaborador-lista.component';
import { ColaboradorService } from './service/colaborador.service';
import { ButtonModule, CalendarModule, DialogModule, InputText, InputTextModule } from 'primeng';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';


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
  ],
  providers: [
    ColaboradorService,
  ]
})
export class ColaboradorModule { }
