import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { CategoriaModel } from './../models/categoria.model';
import { environment } from 'src/environments/environment';

@Injectable()
export class CategoriaService {

    private categoria: CategoriaModel[] = []

    constructor(private httpClient: HttpClient) { }

    obterCategorias(): Observable<CategoriaModel[]>{
        return this.httpClient.get<CategoriaModel[]>(environment.apiUrl + 'categoria');
    }

}
