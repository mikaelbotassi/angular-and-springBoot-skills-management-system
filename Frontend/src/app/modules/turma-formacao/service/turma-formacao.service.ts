import { ColaboradorListaModel } from './../models/ColaboradorListaModel';
import { TurmaColaboradorCompetenciaNivelModel } from './../../turma-colaborador-competencia/models/TurmaColaboradorCompetenciaNivelModel';
import { TurmaColaboradorCompetenciaModel } from './../../turma-colaborador-competencia/models/TurmaColaboradorCompetenciaModel';
import { TurmaFormacaoModel } from '../models/TurmaFormacaoModel';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { API_PATH } from "src/environments/environment";
import { CompetenciaListaModel } from '../models/CompetenciaListaModel';

@Injectable()
export class turmaFormacaoService{
    url = 'turmaFormacao'

    private turmas: TurmaFormacaoModel[] = [];

    constructor(private httpClient: HttpClient){
    }

    obterTodasTurmasComURL(): Observable<TurmaFormacaoModel[]>{
        return this.httpClient.get<TurmaFormacaoModel[]>(API_PATH + this.url);
    }

    registrarTurma(turmaFormacaoModel: TurmaFormacaoModel): Observable<TurmaFormacaoModel>{
        return this.httpClient.post<TurmaFormacaoModel>(API_PATH + this.url, turmaFormacaoModel);
   }

   alterarTurma(turma: TurmaFormacaoModel): Observable<TurmaFormacaoModel>{
       return this.httpClient.put<TurmaFormacaoModel>(API_PATH+ this.url, turma);
   }

   deletarTurma(turmaId: number): Observable<TurmaFormacaoModel>{
    return this.httpClient.delete<TurmaFormacaoModel>(API_PATH + this.url + '/' + turmaId);
   }

   listarTurmaColaboradorCompetencia(turmaId: number): Observable<TurmaColaboradorCompetenciaNivelModel[]>{
    return this.httpClient.get<TurmaColaboradorCompetenciaNivelModel[]>(API_PATH + this.url + '/todosColaboradorCompetenciaTurma/' + turmaId);
   }
   registrarTurmaColaboradorCompetencia(turmaColaboradorCompetenciaModel: TurmaColaboradorCompetenciaModel): Observable<TurmaColaboradorCompetenciaModel>{
    return this.httpClient.post<TurmaColaboradorCompetenciaModel>(API_PATH + this.url + "/inserirColaborador", turmaColaboradorCompetenciaModel);
}

    listarColaboradorCompetencia(): Observable<TurmaColaboradorCompetenciaNivelModel[]>{
        return this.httpClient.get<TurmaColaboradorCompetenciaNivelModel[]>(API_PATH + this.url + "/Colaboradores");
    }

    listarColaborador(): Observable<ColaboradorListaModel[]>{
        return this.httpClient.get<ColaboradorListaModel[]>(API_PATH + "colaborador");
    }

    listarCompetencia(): Observable<CompetenciaListaModel[]>{
        return this.httpClient.get<CompetenciaListaModel[]>(API_PATH + "competencia");
    }

    procurarNivelColaboradorCompetencia(colaboradorId: number, competenciaId: number): Observable<TurmaColaboradorCompetenciaNivelModel>{
        return this.httpClient.get<TurmaColaboradorCompetenciaNivelModel>(API_PATH + this.url + "/ColaboradorCompetencia/" + colaboradorId + "/" + competenciaId);
    }

    deletarTurmaColaboradorCompetencia(turmaColaboradorCompetenciaModel: TurmaColaboradorCompetenciaModel): Observable<TurmaColaboradorCompetenciaModel>{
        return this.httpClient.delete<TurmaColaboradorCompetenciaModel>(API_PATH + this.url + "/turmaColaboradorCompetenciaDeletar/" + turmaColaboradorCompetenciaModel.turmaId + '/' + turmaColaboradorCompetenciaModel.colaboradorId + '/' + turmaColaboradorCompetenciaModel.competenciaId);
    }

}
