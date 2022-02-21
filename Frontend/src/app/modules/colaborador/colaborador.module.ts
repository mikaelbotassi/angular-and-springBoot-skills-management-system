import { SharedModule } from './../../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ColaboradorRoutingModule } from './colaborador-routing.module';
import { ColaboradorListaComponent } from './components/colaborador-lista/colaborador-lista.component';


@NgModule({
  declarations: [
    ColaboradorListaComponent,
  ],
  imports: [
    CommonModule,
    ColaboradorRoutingModule,
    SharedModule
  ]
})
export class ColaboradorModule { }
