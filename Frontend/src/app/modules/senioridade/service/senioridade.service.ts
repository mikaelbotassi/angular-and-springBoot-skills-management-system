import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SenioridadeModel} from '../models/SenioridadeModel';

@Injectable({
    providedIn: 'root'
})
export class SenioridadeService {
    private url = environment.apiUrl + 'senioridade';

    constructor(private http: HttpClient) {}

    getSenioridades(): Observable<SenioridadeModel[]> {
        return this.http.get<SenioridadeModel[]>(this.url);
    }
}
