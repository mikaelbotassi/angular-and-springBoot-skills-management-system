import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ColaboradorModel} from '../models/ColaboradorModel';

@Injectable({
    providedIn: 'root'
})
export class ColaboradorService {
    private categoriaUrl = 'api/colaborador';

    constructor(
        private http: HttpClient
    ) {
    }

    getColaborador(): Observable<ColaboradorModel[]> {
        return this.http.get<ColaboradorModel[]>(this.categoriaUrl);
    }
}
