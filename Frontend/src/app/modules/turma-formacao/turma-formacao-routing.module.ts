import { TurmaFormacaoCrudComponent } from './models/pages/turma-formacao-crud/turma-formacao-crud.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { pathToFileURL } from 'url';


const routes: Routes = [{
  path: '', component: TurmaFormacaoCrudComponent
}

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TurmaFormacaoRoutingModule { }
