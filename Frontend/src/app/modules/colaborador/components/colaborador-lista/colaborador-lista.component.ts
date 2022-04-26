import { ColabodorFuncaoTurmaModel } from './../../../turma-formacao/models/ColaboradorFuncaoTurmaModel';
import {Component, OnInit, ViewChild} from '@angular/core';
import {ColaboradorModel} from '../../models/ColaboradorModel';
import {ColaboradorService} from '../../service/colaborador.service';
import {SenioridadeService} from '../../../senioridade/service/senioridade.service';
import { CadastrarColaboradorModel } from '../../models/cadastro-colaborador.model';
import { ColaboradorFormComponent } from './colaborador-form/colaborador-form.component';
import { MessageService, SelectItem, ConfirmationService } from 'primeng/api';


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
        private senioridadeService: SenioridadeService,
        private confirmationService: ConfirmationService,
        private messageService: MessageService
    ) {
    }

    private showSucess(): void {
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Colaborador deletado' });
      }
      
      showError(mensagem: string) {
        this.messageService.add({severity:'error', summary: 'Erro', detail:mensagem});
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

    deletarColaborador(colaborador: ColaboradorModel){
        this.confirmationService.confirm({
            message: 'Tem certeza que deseja excluir esse colaborador? essa ação não poderá ser desfeita',
            header: 'Confirmação',
            icon: 'pi pi-exclamation-triangle',
            accept: () => this.callDeleteColaborador(colaborador)
          });
    }

    callDeleteColaborador(colaborador: ColaboradorModel){
        this.colaboradorService.deletar(colaborador.id).subscribe(colaborador =>{
            this.getColaboradores();
            this.showSucess();
        }, erro => this.showError("Este colaborador esta em uma turma pendente ou em andamento"));
    }
}
