import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_PATH } from '../../../../environments/environment';
import { CadastrarColaboradorModel } from '../models/cadastro-colaborador.model';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  url : String = 'colaborador'

  constructor(private _http : HttpClient) { }

  public inserir (colaborador : CadastrarColaboradorModel): Observable<CadastrarColaboradorModel>{
    return this._http.post<CadastrarColaboradorModel>(API_PATH + this.url, colaborador);
  }

}
