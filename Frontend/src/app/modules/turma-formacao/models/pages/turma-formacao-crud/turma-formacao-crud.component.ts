import { CompetenciaListaModel } from './../../CompetenciaListaModel';
import { ColaboradorListaModel } from './../../ColaboradorListaModel';
import { TurmaColaboradorCompetenciaNivelModel } from './../../../../turma-colaborador-competencia/models/TurmaColaboradorCompetenciaNivelModel';
import { TurmaFormacaoModel } from './../../TurmaFormacaoModel';
import { turmaFormacaoService } from './../../../service/turma-formacao.service';
import { Component, OnInit, ViewChild } from '@angular/core';


@Component({
  selector: 'app-turma-formacao-crud',
  templateUrl: './turma-formacao-crud.component.html',
  styleUrls: ['./turma-formacao-crud.component.scss']
})
export class TurmaFormacaoCrudComponent implements OnInit {

  display: boolean = false;
  colab: boolean = false;
  turmas:TurmaFormacaoModel[] = [];
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
  mostrarField: boolean = true;
  colaboradorCompetenciaHolder: TurmaColaboradorCompetenciaNivelModel[] = []
  





 ngOnInit(): void {
  this.listarTurmas();
  this.listarColaboradoresAutoComplete();
  this.listarCompetenciasAutoComplete();
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

//Listar 

listarTurmas(){
  this.turmaFormacaoService.obterTodasTurmasComURL().subscribe(turmas => {
      this.turmas = turmas;
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
    console.log(this.competenciasTotal);
  })
  
  
  }

listarTurmaColaboradorCompetencia(turmaId: number){
  this.turmaFormacaoService.listarTurmaColaboradorCompetencia(turmaId).subscribe(colaborador => {
    this.turmaColaboradorCompetenciaList = colaborador;
    console.log("certo");
  })
}

//inserir

inserirTurma(nome: String, descricao: String){
  this.turmaFormacaoModel = new TurmaFormacaoModel(nome,descricao,new Date,null,1);
  this.turmaFormacaoService.registrarTurma(this.turmaFormacaoModel).subscribe(
    turma => {
      console.log("certo");
    }
  );
  this.succes = true;

}

inserirColaboradorCompetenciaHolder(colaboradorId: number, competenciaId: number, colaboradorNome: String, competenciaNome: String){
  let colaborador: TurmaColaboradorCompetenciaNivelModel;
  colaborador.colaboradorId = colaboradorId;
  colaborador.competenciaId = competenciaId;
  colaborador.colaboradorNome = colaboradorNome;
  colaborador.competenciaNome = competenciaNome;
  this.colaboradorCompetenciaHolder.push(colaborador);
}


//filtrar

filtrarColaboradores(event){
  let value = event.query;

  if(value == undefined || value.trim() == ''){
    this.colaboradoresDisponiveis = this.colaboradoresTotal;
    return;
}
  console.log(value);
  this.colaboradoresDisponiveis = this.colaboradoresTotal.filter((colaborador)=>
    colaborador.nome.toLowerCase().indexOf(value.toLowerCase()) >=0
  
  );
  console.log(this.colaboradoresDisponiveis)

}

filtrarCompetencias(event){
  let value = event.query;

  if(value == undefined || value.trim() == ''){
    this.competenciasDisponiveis = this.competenciasTotal;
    return;
}
  console.log(value);
  this.competenciasDisponiveis = this.competenciasTotal.filter((competencia)=>
    competencia.nome.toLowerCase().indexOf(value.toLowerCase()) >=0
  
  );
  console.log(this.competenciasDisponiveis)

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
}

//desabilitar

desabilitarBotaoIniciar(status:number){
if(status == 1){
  return false;
} else{
  return true;
}
}

desabilitarBotaoTerminar(status:number){
  if(status == 2){
    return false;
  } else{
    return true;
  }
  }

  desabilitarInputCompetencia(valor:String){
    if(valor == null){
      return true
    }
    return false
  }

//deletar

deletarTurma(turmaId: number){
  this.turmaFormacaoService.deletarTurma(turmaId).subscribe(
    turma => {
      console.log("certo");
    }
  );
}

deletarColaboradorCompetenciaHolder(colaboradorId: number, competenciaId: number){
  let colaborador: TurmaColaboradorCompetenciaNivelModel;
  colaborador.colaboradorId = colaboradorId;
  colaborador.competenciaId = competenciaId;
  this.colaboradorCompetenciaHolder.splice(this.colaboradorCompetenciaHolder.indexOf(colaborador));
}




}
