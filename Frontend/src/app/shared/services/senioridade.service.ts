import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_PATH } from 'src/environments/environment';
import { SenioridadeModel } from '../model/senioridade.model';

@Injectable({
  providedIn: 'root'
})
export class SenioridadeService {

  private url : String = 'senioridade';

  constructor(private _httpClient : HttpClient) { }

  public buscarSenioridades() : Observable<Array<SenioridadeModel>>{
    return this._httpClient.get<Array<SenioridadeModel>>(API_PATH + this.url);
  }

}
