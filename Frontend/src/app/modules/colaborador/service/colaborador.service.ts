import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ColaboradorModel} from '../models/ColaboradorModel';
import { API_PATH } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ColaboradorService {
    private url = API_PATH + "colaborador"

    constructor(
        private http: HttpClient
    ) {
    }

    getColaborador(): Observable<ColaboradorModel[]> {
        return this.http.get<ColaboradorModel[]>(this.url);
    }
}
