import { CompetenciaListarComponent } from './competencia-listar/competencia-listar.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
    {
    path: '', component:CompetenciaListarComponent
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CompetenciaRoutingModule { }
