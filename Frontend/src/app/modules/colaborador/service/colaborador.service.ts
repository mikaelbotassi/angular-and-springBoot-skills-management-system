import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_PATH } from '../../../../environments/environment';
import { CadastrarColaboradorModel } from '../models/cadastro-colaborador.model';
import {ColaboradorModel} from '../models/ColaboradorModel';

@Injectable({
    providedIn: 'root'
})
export class ColaboradorService {

  private url : String = 'colaborador'

  constructor(private _http : HttpClient) { }

  public inserir (colaborador : CadastrarColaboradorModel): Observable<CadastrarColaboradorModel>{
    return this._http.post<CadastrarColaboradorModel>(API_PATH + this.url, colaborador);
  }

    getColaborador(): Observable<ColaboradorModel[]> {
        return this._http.get<ColaboradorModel[]>(API_PATH + this.url);
    }

    atualizar(colaborador : CadastrarColaboradorModel): Observable<CadastrarColaboradorModel>{
      return this._http.put<CadastrarColaboradorModel>(API_PATH + this.url, colaborador);
    }
}
