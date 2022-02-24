import { CompetenciaModel } from './../../../../competencia/models/competencia.model';
import { ColaboradorModel } from './../../../../colaborador/models/ColaboradorModel';
import { CompetenciaListaModel } from './../../CompetenciaListaModel';
import { ColaboradorListaModel } from './../../ColaboradorListaModel';
import { TurmaColaboradorCompetenciaNivelModel } from './../../../../turma-colaborador-competencia/models/TurmaColaboradorCompetenciaNivelModel';
import { TurmaFormacaoModel } from './../../TurmaFormacaoModel';
import { turmaFormacaoService } from './../../../service/turma-formacao.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { TurmaColaboradorCompetenciaModel } from 'src/app/modules/turma-colaborador-competencia/models/TurmaColaboradorCompetenciaModel';
import { TriStateCheckbox } from 'primeng';


@Component({
  selector: 'app-turma-formacao-crud',
  templateUrl: './turma-formacao-crud.component.html',
  styleUrls: ['./turma-formacao-crud.component.scss']
})
export class TurmaFormacaoCrudComponent implements OnInit {

  display: boolean = false;
  colab: boolean = false;
  turmas:TurmaFormacaoModel[] = [];
  turmasFiltradas: TurmaFormacaoModel[] = [];
  turmaFormacaoModel: TurmaFormacaoModel;
  succes: boolean = false;
  displayAlt: boolean = false;
  turmaDetalhada: TurmaFormacaoModel;
  turmaColaboradorCompetencia: TurmaColaboradorCompetenciaNivelModel;
  turmaColaboradorCompetenciaList:TurmaColaboradorCompetenciaNivelModel[] = [];
  colaboradoresDisponiveis:  ColaboradorListaModel[] =[];
  colaboradoresTotal:ColaboradorListaModel[] = [];
  competenciasTotal: CompetenciaListaModel[] = [];
  competenciasDisponiveis: CompetenciaListaModel[] = [];
  colaboradorCompetenciaHolder: TurmaColaboradorCompetenciaNivelModel[] = [];
  colaboradorHolder: TurmaColaboradorCompetenciaNivelModel;
  colaboradorAutoComplete;
  competenciaAutoComplete;

  


@ViewChild('dt') table: TurmaFormacaoModel;


 ngOnInit(): void {
  this.listarTurmas();
  this.listarColaboradoresAutoComplete();
  this.listarCompetenciasAutoComplete();
  this.colaboradorHolder = new TurmaColaboradorCompetenciaNivelModel(null,null,null,null,null,null, null);
}

constructor(private turmaFormacaoService: turmaFormacaoService) {}




//Mostrar modais

showDialog(){
  this.display = true;
}

showColab(){
 this.colab = true;
}

showDialogAlt(turma: TurmaFormacaoModel){
  this.displayAlt = true;
this.turmaDetalhada = turma;
}

teste(event){
console.log(event);
}

//Listar 

listarTurmas(){
  this.turmaFormacaoService.obterTodasTurmasComURL().subscribe(turmas => {
      this.turmas = turmas;
      this.turmasFiltradas = turmas;
  })
}


listarColaboradoresAutoComplete(){
this.turmaFormacaoService.listarColaborador().subscribe(colaborador => {
  this.colaboradoresTotal = colaborador;
})



}

listarCompetenciasAutoComplete(){
  this.turmaFormacaoService.listarCompetencia().subscribe(competencia => {
    this.competenciasTotal = competencia;
  })
  
  
  }

listarTurmaColaboradorCompetencia(turmaId: number){
  this.turmaFormacaoService.listarTurmaColaboradorCompetencia(turmaId).subscribe(colaborador => {
    this.colaboradorCompetenciaHolder = colaborador;
    console.log("certo");
  })
}

//inserir

inserirTurma(nome: String, descricao: String){
  this.turmaFormacaoModel = new TurmaFormacaoModel(nome,descricao,new Date,null,1);
  this.turmaFormacaoService.registrarTurma(this.turmaFormacaoModel).subscribe(
    turma => {
      return this.inserirListaColaborador(turma.id)
    }
  );
  

}

inserirListaColaborador(turmaId:number){
  let turmaColaboradoresTemp: TurmaColaboradorCompetenciaModel[] = [];
    this.turmaFormacaoService.listarTurmaColaboradorCompetencia(turmaId).subscribe(colaboradoresTurma => {
      turmaColaboradoresTemp = colaboradoresTurma;
    });
  this.colaboradorCompetenciaHolder.forEach(colaborador =>{
    let turmaTemp = new TurmaColaboradorCompetenciaModel(turmaId,colaborador.colaboradorId,colaborador.competenciaId);
    if(turmaColaboradoresTemp.indexOf(turmaTemp) == -1){
      this.turmaFormacaoService.registrarTurmaColaboradorCompetencia(turmaTemp).subscribe(retorno =>{
        console.log("certo");
      });
    }
  }


    )
  this.succes = true;

}

inserirTurmaIniciando(nome: String, descricao: String){
  this.turmaFormacaoModel = new TurmaFormacaoModel(nome,descricao,new Date,null,2);
  this.turmaFormacaoService.registrarTurma(this.turmaFormacaoModel).subscribe(
    turma => {
      return this.inserirListaColaborador(turma.id)
    }
  );
  this.succes = true;

}

inserirColaboradorCompetenciaHolder(){
  console.log(this.colaboradorAutoComplete);
  this.turmaFormacaoService.procurarNivelColaboradorCompetencia(this.colaboradorHolder.colaboradorId, this.colaboradorHolder.competenciaId).subscribe(colaboradorTemp =>{
    if(this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaborador.colaboradorId  === this.colaboradorHolder.colaboradorId && colaborador.competenciaId === this.colaboradorHolder.competenciaId) == -1) {
      this.colaboradorCompetenciaHolder.push(colaboradorTemp);   
    }
    this.colaboradorHolder = new TurmaColaboradorCompetenciaNivelModel(null,null, null,null,null,null,null);
  })
  console.log(this.colaboradorCompetenciaHolder);
  
}


//filtrar

filtrarColaboradores(event){
  let value = event.query;

  if(value == undefined || value.trim() == ''){
    this.colaboradoresDisponiveis = this.colaboradoresTotal;
    return;
}
  this.colaboradoresDisponiveis = this.colaboradoresTotal.filter((colaborador)=>
    colaborador.nome.toLowerCase().indexOf(value.toLowerCase()) >=0
  
  );

}

filtrarCompetencias(event){
  let value = event.query;

  if(value == undefined || value.trim() == ''){
    this.competenciasDisponiveis = this.competenciasTotal;
    return;
}
  this.competenciasDisponiveis = this.competenciasTotal.filter((competencia)=>
    competencia.nome.toLowerCase().indexOf(value.toLowerCase()) >=0
  
  );
}

filtrarTurmaNome(value){

  if(value == undefined || value.trim() == ''){
    this.turmasFiltradas = this.turmas;
    return;
}
  this.turmasFiltradas = this.turmas.filter((turma)=>
    turma.nome.toLowerCase().indexOf(value.toLowerCase()) >=0
  
  );
  console.log(this.turmasFiltradas);
}

filtrarTurmaStatus(value){

  if(value == undefined || value.trim() == ''){
    this.turmasFiltradas = this.turmas;
    return;
}
  this.turmasFiltradas = this.turmas.filter((turma)=>
    turma.statusId == value
  
  );
}

//modificar


iniciarTurma(turma: TurmaFormacaoModel){
turma.statusId = 2;
  this.turmaFormacaoService.alterarTurma(turma).subscribe(
    turma => {
      console.log("certo");
    }
  );

}

finalizarTurma(turma: TurmaFormacaoModel){
  turma.statusId = 3;
  turma.termino = new Date;
    this.turmaFormacaoService.alterarTurma(turma).subscribe(
      turma => {
        console.log("certo");
      }
    );
  
  }


alterarTurma(turma: TurmaFormacaoModel, nome: String, descricao: String){
  turma.nome = nome;
  turma.descricao = descricao;
  this.turmaFormacaoService.alterarTurma(turma).subscribe(
    turma => {
      console.log("certo");
    }
  );
  this.inserirListaColaborador(turma.id)
}

limparHolderColaboradorCompetencia(event){
  this.colaboradorCompetenciaHolder = [];
}

//desabilitar

desabilitarBotaoIniciar(status:number) : boolean{
if(status == 1){
  return false;
} else{
  return true;
}
}

desabilitarBotaoPorColaborador(status:number) : boolean{
  if(status == 1){
    return false;
  } else{
    return true;
  }
  }

desabilitarBotaoTerminar(status:number): boolean{
  if(status == 2){
    return false;
  } else{
    return true;
  }
  }

  desabilitarInputCompetencia(valor:String): boolean{
    if(valor == null || valor == ''){
      return true
    }
    return false
  }

desabilitarBotaoColaboradorCompetencia(valor:Number): boolean{
  if(valor == 1){
    return false
  }
  return true
}

desabilitarBotaoColaboradorCompetenciaAlt(valor:Number): boolean{
  if(valor == 3){
    return true;
  }
  return false;
}

desabilitarAdicionarColaboradorCompetenciaPorCampo(campo1: String, campo2: String): boolean{
  if(campo1 == null || campo2 == null){
    return true
  }
  return false
}

desabilitarDeletarTurma(status:Number): boolean{
  if(status == 1){
    return true;
  }
  return false;
}


//deletar

deletarTurma(turmaId: number){
  this.turmaFormacaoService.deletarTurma(turmaId).subscribe(
    turma => {
      console.log("certo");
    }
  );
}

deletarColaboradorCompetenciaHolder(colaboradorSelecionado: TurmaColaboradorCompetenciaNivelModel){
  this.colaboradorCompetenciaHolder.splice(this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaboradorSelecionado.colaboradorId === colaborador.colaboradorId && colaborador.competenciaId === colaboradorSelecionado.competenciaId ), 1);
}

deletarColaboradorCompetenciaHolderAlt(colaboradorSelecionado: TurmaColaboradorCompetenciaNivelModel, turmaId: number){
  colaboradorSelecionado.turmaId = turmaId;

  
  if(this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaboradorSelecionado.colaboradorId === colaborador.colaboradorId &&
   colaborador.competenciaId === colaboradorSelecionado.competenciaId) !=-1){
     this.turmaFormacaoService.deletarTurmaColaboradorCompetencia(colaboradorSelecionado).subscribe();
     console.log("testando");
   }

  this.colaboradorCompetenciaHolder.splice(this.colaboradorCompetenciaHolder.findIndex((colaborador) => colaboradorSelecionado.colaboradorId === colaborador.colaboradorId && colaborador.competenciaId === colaboradorSelecionado.competenciaId ), 1);
}



//associações

escolherCompetencia(competencia: CompetenciaListaModel){
  this.colaboradorHolder.competenciaId = competencia.id;
  this.colaboradorHolder.competenciaNome = competencia.nome;
}

escolherColaborador(colaborador: ColaboradorListaModel){
  this.colaboradorHolder.colaboradorId = colaborador.id;
  this.colaboradorHolder.colaboradorNome = colaborador.nome;
}


}
