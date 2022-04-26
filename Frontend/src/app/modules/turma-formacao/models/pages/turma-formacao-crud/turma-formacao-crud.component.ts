import { BlockUIService } from 'ng-block-ui';
import { ConfirmationService } from 'primeng/api';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MessageService, Table } from 'primeng';
import { turmaFormacaoService } from './../../../service/turma-formacao.service';
import { TurmaFormacaoModel } from './../../TurmaFormacaoModel';
import { TurmaFormacaoAlterarModalComponent } from './turma-formacao-form-modal/turma-formacao-form-modal.component';


@Component({
  selector: 'app-turma-formacao-crud',
  templateUrl: './turma-formacao-crud.component.html',
  styleUrls: ['./turma-formacao-crud.component.scss']
})


export class TurmaFormacaoCrudComponent implements OnInit {

  turmas: TurmaFormacaoModel[] = [];
  statusDisponiveis: any[] = [];

  @ViewChild('turma') turmaModal: TurmaFormacaoAlterarModalComponent = new TurmaFormacaoAlterarModalComponent(null, null, null, null);
  @ViewChild('dt') table: Table;


  ngOnInit(): void {
    this.listarTurmas();
  }

  constructor(private turmaFormacaoService: turmaFormacaoService,
     private messageService: MessageService, private confirmationService: ConfirmationService,
     blockUIService: BlockUIService) { }




  //Mostrar modais

  private showSucess(): void {
    this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Turma deletada' });
  }

  showDialog(turma: TurmaFormacaoModel): void {
    this.turmaModal.iniciarTela(turma);
  }


  //Listar 

  listarTurmas(): void {

    this.turmaFormacaoService.obterTodasTurmasComURL().subscribe(turmas => {
      this.turmas = turmas;
    })

    this.turmaFormacaoService.listarStatus()
      .subscribe((status) => this.statusDisponiveis = status.map(status => ({
        label: status.descricao,
        value: status.descricao,
      })));
    this.confirmationService.close();    
  }


  onDateSelect(value): void {
    this.table.filter(this.formatDate(value), 'inicio', 'equals')
  }

  onDateSelectTermino(value): void {
    this.table.filter(this.formatDate(value), 'termino', 'equals')
  }

  formatDate(date): String {
    let month = date.getMonth() + 1;
    let day = date.getDate();

    if (month < 10) {
      month = '0' + month;
    }

    if (day < 10) {
      day = '0' + day;
    }

    return date.getFullYear() + '-' + month + '-' + day;
  }

  deletarTurma(turma: TurmaFormacaoModel): void {

    this.confirmationService.confirm({
      message: 'Tem certeza que deseja excluir essa turma? essa ação não poderá ser desfeita',
      header: 'Confirmação',
      icon: 'pi pi-exclamation-triangle',
      accept: () => this.callDeleteTurma(turma)
    });


  }

  callDeleteTurma(turma: TurmaFormacaoModel): void {
    this.turmaFormacaoService.deletarTurma(turma.id)
      .subscribe(turma => {
        this.listarTurmas();
        this.showSucess();
      });

  }

  desabilitarDeletarTurma(turma: TurmaFormacaoModel){
    if(turma.statusId == 3){
      return false;
    }
    return true;
  }
}
