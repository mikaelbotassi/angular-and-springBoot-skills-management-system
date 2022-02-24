import {Component, OnInit} from '@angular/core';
import {ColaboradorModel} from '../../models/ColaboradorModel';
import {ColaboradorService} from '../../service/colaborador.service';

@Component({
    selector: 'app-colaborador-lista',
    templateUrl: './colaborador-lista.component.html',
    styleUrls: ['./colaborador-lista.component.css']
})
export class ColaboradorListaComponent implements OnInit {
    colaboradores: ColaboradorModel[] = [];
    coloumns: any[] = [];
    rows: number = 2;

    constructor(
        private colaboradorService: ColaboradorService
    ) {
    }

    ngOnInit(): void {
        this.getColaboradores();
        this.coloumns = [
            {field: 'nome', header: 'Nome'},
            {field: 'dataNascimento', header: 'Nascimento'},
            {field: 'dataAdmissao', header: 'Admissão'},
            {field: 'nomeSenioridade', header: 'Senioridade'}
        ];
    }

    getColaboradores(): void {
        this.colaboradorService.getColaborador()
            .subscribe(colaboradores => this.colaboradores = colaboradores);
    }
}
