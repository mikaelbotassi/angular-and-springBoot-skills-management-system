import { TurmaFormacaoModule } from './modules/turma-formacao/turma-formacao.module';
import { CompetenciaModule } from './modules/competencia/competencia.module';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DiarioErrosComponent } from './components/diario-erros/diario-erros.component';
import { LoginSuccessComponent } from '@nuvem/angular-base';
import { ColaboradorModule } from './modules/colaborador/colaborador.module';

const routes: Routes = [
    { path: 'diario-erros', component: DiarioErrosComponent, data: { breadcrumb: 'Diário de Erros'} },
    { path: 'login-success', component: LoginSuccessComponent },
    { path: 'colaborador', loadChildren : () => ColaboradorModule},
    { path: 'turma', loadChildren : () => TurmaFormacaoModule},
    {path: 'competencia', loadChildren: () => CompetenciaModule}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
