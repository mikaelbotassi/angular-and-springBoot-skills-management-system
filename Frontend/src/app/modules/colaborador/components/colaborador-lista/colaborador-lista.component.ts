import {Component, OnInit, ViewChild} from '@angular/core';
import {ColaboradorModel} from '../../models/ColaboradorModel';
import {ColaboradorService} from '../../service/colaborador.service';
import {SenioridadeService} from '../../../senioridade/service/senioridade.service';
import { CadastrarColaboradorModel } from '../../models/cadastro-colaborador.model';
import { ColaboradorFormComponent } from './colaborador-form/colaborador-form.component';

@Component({
    selector: 'app-colaborador-lista',
    templateUrl: './colaborador-lista.component.html',
    styleUrls: ['./colaborador-lista.component.scss']
})
export class ColaboradorListaComponent implements OnInit {
    colaboradores: ColaboradorModel[] = [];
    senioridades: any[] = [];
    coloumns: any[] = [];

    colaboradorAlteracao : CadastrarColaboradorModel;

    @ViewChild('dtColaborador') table: ColaboradorModel;

    @ViewChild('colaboradorForm') colaboradorForm: ColaboradorFormComponent;

    visivel : boolean = false;

    constructor(
        private colaboradorService: ColaboradorService,
        private senioridadeService: SenioridadeService
    ) {
    }

    ngOnInit(): void {
        this.getColaboradores();
        this.getSenioridade();
        this.coloumns = [
            {field: 'nome', header: 'Nome'},
            {field: 'nomeSenioridade', header: 'Senioridade'},
            {header: 'Ação'}
        ];
    }

    getColaboradores(): void {
        this.colaboradorService.getColaborador()
            .subscribe(colaboradores => this.colaboradores = colaboradores);
    }

    getSenioridade(): void {
        this.senioridadeService.getSenioridades()
            .subscribe(senioridades => this.senioridades = senioridades.map(senioridade => ({
                label: senioridade.descricao,
                value: senioridade.descricao
            })));
    }

    abrirDialogAlterar(colaborador : ColaboradorModel) : void {
        this.visivel = !this.visivel;
        this.colaboradorForm.buscarColaboradorPorId(colaborador.id); 
    }

    limparFormularioFilho() : void {
        this.colaboradorForm.limparFormulario()
    }
}
