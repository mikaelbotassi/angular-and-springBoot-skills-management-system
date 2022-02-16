import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ColaboradorListaComponent } from './components/colaborador-lista/colaborador-lista/colaborador-lista.component';

const routes: Routes = [
  { path : '', component : ColaboradorListaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ColaboradorRoutingModule { }
