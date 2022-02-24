import { Component, Input, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { CompetenciaListarComponent } from './../competencia-listar/competencia-listar.component';
import { CategoriaService } from './../service/categoria.service';
import { CompetenciaService } from './../service/competencia.service';
import { CategoriaModel } from './../models/categoria.model';
import { CompetenciaModel } from './../models/competencia.model';
import { SelectItem } from 'primeng';

@Component({
  selector: 'app-form-competencia',
  templateUrl: './form-competencia.component.html',
  styleUrls: ['./form-competencia.component.scss']
})
export class FormCompetenciaComponent implements OnInit {

    @Input() competenciaEditada:CompetenciaModel;
    formCompetencia: FormGroup;
    categorias: CategoriaModel[] = [];

    constructor(private formBuilder: FormBuilder, private categoriaService:CategoriaService, private competenciaService:CompetenciaService) { }

    ngOnInit() {
        this.formCompetencia = this.createForm();
        this.formCompetencia.patchValue(this.competenciaEditada);
        this.getCategorias();
    }

    createForm(): FormGroup {
        return this.formBuilder.group({
        id: [null, [Validators.required]],
        nome: [null, [Validators.required]],
        descricao: [null, [Validators.required]],
        categoria: [null, [Validators.required]],
        });
    }

    getCategorias(){
        this.categoriaService.obterCategorias().subscribe(categorias => {
            this.categorias = categorias;
        })
        console.log(this.categorias);
    }

    converterParaDropDown(categorias: CategoriaModel[], campoValue:string, campoLabel:string):SelectItem[]{
        return categorias.map((categoria:CategoriaModel) => ({
            value:campoValue ? categoria[campoValue] : categoria,
            label:categoria[campoLabel]
        }))
    }

    atualizarCompetencia(): void{

        if(!this.formCompetencia.valid){
            return;
        }
        this.competenciaService.atualizarCompetencia(this.formCompetencia.getRawValue()).subscribe(
            resultado => {
              console.log('Competência alterada com sucesso.')
            },
            erro => {
              switch(erro.status) {
                case 400:
                  console.log(erro.error.mensagem);
                  break;
                case 404:
                  console.log('Competência não localizada.');
                  break;
              }
            }
          );
        this.formCompetencia.reset();

    }

}
