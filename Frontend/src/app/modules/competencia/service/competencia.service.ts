import { CompetenciaModel } from './../models/competencia.model';
import { Observable } from 'rxjs';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from 'src/environments/environment';
import { CadastrarCompetenciaModel } from '../models/cadastro-competencia.model';

@Injectable()
export class CompetenciaService{

    //exemplo constante
    // private static readonly constExample

    private competencias: CompetenciaModel[] = [];

    constructor(private httpClient: HttpClient){
    }

    obterTodasCompetenciasComURL(url: String): Observable<CompetenciaModel[]>{
        return this.httpClient.get<CompetenciaModel[]>(environment.apiUrl + url);
    }

    obterCompetenciasDropdown(url: String): Observable<Array<CadastrarCompetenciaModel>>{
        return this.httpClient.get<Array<CadastrarCompetenciaModel>>(environment.apiUrl + url + '/dropdown');
    }

}
