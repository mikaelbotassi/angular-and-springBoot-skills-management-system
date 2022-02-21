import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CadastrarColaboradorModel } from '../../../models/cadastro-colaborador.model';
import { ColaboradorService } from '../../../service/colaborador.service';

@Component({
  selector: 'app-colaborador-lista',
  templateUrl: './colaborador-lista.component.html',
  styleUrls: ['./colaborador-lista.component.css']
})
export class ColaboradorListaComponent implements OnInit {

  colaborador : CadastrarColaboradorModel;
  formGroup : FormGroup;

  listaCompetencia : Array<any> = new Array(); 

  constructor(private _colaborador : ColaboradorService,
              private _formBuilder : FormBuilder) { }

  ngOnInit(): void {

    this.formGroup = this._formBuilder.group({
      nome : [''],

      sobrenome : [''],
      
      cpf : [''],
    
      email : [''],
  
      dataNascimento : [''],
  
      dataAdmissao : [''],
  
      idSenioridade : [''],

    })
  }

  public inserirColaborador() {

      this._colaborador.inserir(this.colaborador).subscribe(
        res => console.log('Certo'),
        err => console.log('Erro'),
    )
                                                    
  }



}
