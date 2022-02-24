import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SelectItemGroup } from 'primeng/api';
import { CadastrarCompetenciaModel } from 'src/app/modules/competencia/models/cadastro-competencia.model';
import { CompetenciaService } from 'src/app/modules/competencia/service/competencia.service';
import { SenioridadeModel } from 'src/app/shared/model/senioridade.model';
import { CadastrarColaboradorModel } from '../../../models/cadastro-colaborador.model';
import { ColaboradorService } from '../../../service/colaborador.service';

@Component({
  selector: 'app-colaborador-lista',
  templateUrl: './colaborador-lista.component.html',
  styleUrls: ['./colaborador-lista.component.css']
})
export class ColaboradorListaComponent implements OnInit {

  file : FileReader = new FileReader(); 
  colaborador : CadastrarColaboradorModel;
  formBuilder : FormBuilder = new FormBuilder();
  formGroup : FormGroup;

  image;

  listaCompetencia : Array<CadastrarCompetenciaModel> = new Array(); 

  listaCompetenciaSelecionado : Array<CadastrarCompetenciaModel> = new Array();

  listaSenioridade : Array<SenioridadeModel> = new Array();

  dropdownSenioridade : SelectItemGroup[];

  constructor(private _colaborador : ColaboradorService,
              private _competencia : CompetenciaService) { }

  ngOnInit(): void {
    this.buscarCompetencia();
    this.criarFormulario();

    this.criaDropdownSenioridade();

  }

  public uploadImagem(event) : void{
    this.image = event.currentFiles[0].objectURL;
    this.file.readAsBinaryString(event.currentFiles[0]);
    this.file.onload = () => this.converterArquivo()
  }

  public converterArquivo(): void {
    this.formGroup.get('foto').setValue(btoa(this.file.result.toString()));
  }


  public criaDropdownSenioridade() : void{
    this.listaSenioridade = JSON.parse(localStorage.getItem('senioridade'));
    
    this.dropdownSenioridade = this.listaSenioridade.map(
      item => ({
        label : item.descricao,
        value : item.id,
        items : []
      })
    )

  }

  public inserirColaborador() : void {
    this.listaCompetenciaSelecionado.forEach(item => {
      item.nivel = 1
    })

    this.formGroup.get('competencia').setValue(this.listaCompetenciaSelecionado);

    this.colaborador = this.formGroup.getRawValue();

      this._colaborador.inserir(this.colaborador).subscribe(
        res => console.log('Certo'),
        err => console.log('Erro'),
    )
                                                    
  }

  public buscarCompetencia(): void {
    this._competencia.obterCompetenciasDropdown('competencia').subscribe(
      res => this.listaCompetencia = res,

      err => console.error(err)
    )
  }

  public criarFormulario() : void{
    this.formGroup = this.formBuilder.group({
      nome : [''],

      sobrenome : [''],
      
      cpf : [''],
    
      email : [''],
  
      dataNascimento : [''],
  
      dataAdmissao : [''],
  
      idSenioridade : [null],

      competencia : [[]],

      foto : ['']

    })
  }



}
