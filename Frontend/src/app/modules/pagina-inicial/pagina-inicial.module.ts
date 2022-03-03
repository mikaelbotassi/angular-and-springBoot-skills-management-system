import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PaginaInicialRoutingModule } from './pagina-inicial-routing.module';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';


@NgModule({
  declarations: [PaginaInicialComponent],
  imports: [
    CommonModule,
    PaginaInicialRoutingModule
  ]
})
export class PaginaInicialModule { }
