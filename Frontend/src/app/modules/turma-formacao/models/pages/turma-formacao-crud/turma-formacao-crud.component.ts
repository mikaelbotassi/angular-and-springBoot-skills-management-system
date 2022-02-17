import { CheckboxModule } from 'primeng/checkbox';
import { Observable } from 'rxjs';
import { Component, OnInit } from '@angular/core';
import { turmaFormacaoModel } from '../../turmaFormacaoModel';

@Component({
  selector: 'app-turma-formacao-crud',
  templateUrl: './turma-formacao-crud.component.html',
  styleUrls: ['./turma-formacao-crud.component.scss']
})
export class TurmaFormacaoCrudComponent implements OnInit {

  display: boolean = false;
  colab: boolean = false;

  showDialog(){
    this.display = true;
  }
 // public listar():Observable<turmaFormacaoModel>{
 //   return this.http.get<turmaFormacaoModel>("");
 // }
 
 showColab(){
   this.colab = true;
 }

  ngOnInit(): void {
  }

}
