import { TurmaFormacaoModel } from '../models/TurmaFormacaoModel';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { API_PATH } from "src/environments/environment";

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
}
