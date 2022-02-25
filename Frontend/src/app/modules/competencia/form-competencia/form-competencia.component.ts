import {Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { CategoriaService } from './../service/categoria.service';
import { CompetenciaService } from './../service/competencia.service';
import { CategoriaModel } from './../models/categoria.model';
import { CompetenciaModel } from './../models/competencia.model';
import { SelectItem } from 'primeng';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { finalize } from 'rxjs/operators';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'app-form-competencia',
  templateUrl: './form-competencia.component.html',
  styleUrls: ['./form-competencia.component.scss']
})
export class FormCompetenciaComponent implements OnInit{

    @BlockUI() block: NgBlockUI;
    @Output() fechar:EventEmitter<CompetenciaModel> = new EventEmitter();
    @Input() competenciaEditada:CompetenciaModel;
    visible: boolean = true;
    formCompetencia: FormGroup;
    categorias: CategoriaModel[] = [];

    constructor(private formBuilder: FormBuilder, private categoriaService:CategoriaService, private competenciaService:CompetenciaService) { }

    ngOnInit() {

        this.formCompetencia = this.createForm();
        this.getCategorias();
        this.formCompetencia.patchValue(this.finalizarFormulario);
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
    }

    converterParaDropDown(categorias: CategoriaModel[], campoValue:string, campoLabel:string):SelectItem[]{
        return categorias.map((categoria:CategoriaModel) => ({
            value:campoValue ? categoria[campoValue] : categoria,
            label:categoria[campoLabel]
        }))
    }

    atualizarCompetencia(): void{

        this.block.start('Carregando...')
        if(!this.formCompetencia.valid){

            this.block.stop;
            this.fechar.emit();
            return;

        }
        this.competenciaService.atualizarCompetencia(this.formCompetencia.getRawValue()).pipe(finalize(()=> this.block.stop())).subscribe(

            resultado => {
              console.log('Competência alterada com sucesso.');
              this.fechar.emit(this.competenciaEditada);
            },
            erro => {
              switch(erro.status) {
                case 400:
                  console.log(erro.error.mensagem);
                  this.fechar.emit();
                  break;
                case 404:
                    this.fechar.emit();
                  console.log('Competência não localizada.');
                  break;
              }
            }
          );

    }

    cancel(){
        this.fechar.emit();
    }

    criarCompetencia(): void{
        this.competenciaService.criarCompetencia(this.formCompetencia.getRawValue()).pipe(finalize(()=> this.block.stop())).subscribe(
            resultado => {
              console.log('Competência Criada.');
              this.fechar.emit(this.competenciaEditada);
            },
            erro => {
              switch(erro.status) {
                case 400:
                  console.log(erro.error.mensagem);
                  this.fechar.emit();
                  break;
                case 404:
                    this.fechar.emit();
                  console.log('ERRO...Competência Não Pôde Ser Criada.');
                  break;
              }
            }
        );
        this.formCompetencia.reset();
    }

    finalizarFormulario() :void {
        this.visible ? this.criarCompetencia():this.atualizarCompetencia();
        this.cancel();
    }
}
