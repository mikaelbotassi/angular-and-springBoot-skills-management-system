import { Injectable } from "@angular/core";

import { CompetenciaModel } from './../models/competencia.model';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { environment } from 'src/environments/environment';
import { CadastrarCompetenciaModel } from '../models/cadastro-competencia.model';

@Injectable()
export class CompetenciaService{

    //exemplo constante
    // private static readonly constExample

    competencias: CompetenciaModel[] = [];

    constructor(private httpClient: HttpClient){
    }

    obterTodasCompetenciasComURL(url: String): Observable<CompetenciaModel[]>{
        return this.httpClient.get<CompetenciaModel[]>(environment.apiUrl + url);
    }

    obterCompetenciasDropdown(url: String): Observable<Array<CadastrarCompetenciaModel>>{
        return this.httpClient.get<Array<CadastrarCompetenciaModel>>(environment.apiUrl + url + '/dropdown');
    }

    atualizarCompetencia(competencia: CompetenciaModel):Observable<CompetenciaModel>{
        return this.httpClient.put<CompetenciaModel>(environment.apiUrl + 'competencia', competencia);
    }

    criarCompetencia(competencia: CompetenciaModel): Observable<CompetenciaModel[]>{
        return this.httpClient.post<CompetenciaModel[]>(environment.apiUrl + 'competencia', competencia);
    }

}
