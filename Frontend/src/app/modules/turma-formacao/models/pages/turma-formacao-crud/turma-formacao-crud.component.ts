import { turmaFormacaoService } from './../../../service/turma-formacao.service';
import { TurmaFormacaoModel } from '../../TurmaFormacaoModel';
import { CheckboxModule } from 'primeng/checkbox';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-turma-formacao-crud',
  templateUrl: './turma-formacao-crud.component.html',
  styleUrls: ['./turma-formacao-crud.component.scss']
})
export class TurmaFormacaoCrudComponent implements OnInit {

  display: boolean = false;
  colab: boolean = false;
  turmas:TurmaFormacaoModel[] = [];
  turmaFormacaoModel: TurmaFormacaoModel;
  succes: boolean = false;

  showDialog(){
    this.display = true;
  }
 
 showColab(){
   this.colab = true;
 }

 ngOnInit(): void {
  this.listarTurmas();
}

constructor(private turmaFormacaoService: turmaFormacaoService) {}

listarTurmas(){
  this.turmaFormacaoService.obterTodasTurmasComURL().subscribe(turmas => {
      this.turmas = turmas;
      console.log(this.turmas);
  })
}

inserirTurma(nome: String, descricao: String){
  this.turmaFormacaoModel = new TurmaFormacaoModel(nome,descricao,new Date,null,1);
  this.turmaFormacaoService.registrarTurma(this.turmaFormacaoModel).subscribe(
    turma => {
      console.log("certo");
    }
  );
  this.succes = true;
}

}
