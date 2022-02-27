import {Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup, FormBuilder} from '@angular/forms';

import { CategoriaService } from './../service/categoria.service';
import { CompetenciaService } from './../service/competencia.service';
import { CategoriaModel } from './../models/categoria.model';
import { CompetenciaModel } from './../models/competencia.model';
import { SelectItem, MessageService } from 'primeng';
import { BlockUI, NgBlockUI } from 'ng-block-ui';
import { finalize} from 'rxjs/operators';

@Component({
  selector: 'app-form-competencia',
  templateUrl: './form-competencia.component.html',
  styleUrls: ['./form-competencia.component.scss']
})
export class FormCompetenciaComponent implements OnInit{

    @BlockUI() block: NgBlockUI;
    @Output() fechar:EventEmitter<CompetenciaModel> = new EventEmitter();
    @Input() competenciaEditada:CompetenciaModel;
    formCompetencia: FormGroup;
    categorias: CategoriaModel[] = [];
     visible: boolean;

    constructor(private formBuilder: FormBuilder, private categoriaService:CategoriaService, private competenciaService:CompetenciaService, private messageService:MessageService) { }

    ngOnInit() {

        this.formCompetencia = this.createForm();
        this.getCategorias();
        if (! (typeof this.competenciaEditada === "undefined")) {
            this.formCompetencia.patchValue(this.competenciaEditada);
        }

    }

    showSuccess(mensagem: string) {
        this.messageService.add({severity:'success', summary: 'Sucesso', detail:mensagem});
    }

    showInfo(mensagem: string) {
        this.messageService.add({severity:'info', summary: 'Informações', detail:mensagem});
    }

    showWarn(mensagem: string) {
        this.messageService.add({severity:'warn', summary: 'Atenção', detail:mensagem});
    }

    showError(mensagem: string) {
        this.messageService.add({severity:'error', summary: 'Erro', detail:mensagem});
    }

    clear() {
        this.messageService.clear();
    }

    createForm(): FormGroup {
        return this.formBuilder.group({
        id: [null],
        nome: [null],
        descricao: [null],
        categoria: [null],
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

        this.block.start('Carregando...');

        this.competenciaService.atualizarCompetencia(this.formCompetencia.getRawValue())
        .pipe(finalize(()=> this.block.stop()))
        .subscribe(

            resultado => {

                this.fechar.emit(this.competenciaEditada);

            },
            erro => {
              switch(erro.status) {
                case 400:
                    if(erro.error.ERRORS){
                        this.showError(erro.error.ERRORS);
                    }
                    else if(erro.error.nome){
                        this.showError(erro.error.nome);
                    }

                    else if(erro.error.descricao){
                        this.showError(erro.error.descricao);
                    }

                    else if(erro.error.categoria){
                        this.showError(erro.error.categoria);
                    }

                //   this.fechar.emit();
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
        this.competenciaService.criarCompetencia(this.formCompetencia.getRawValue())
        .pipe(finalize(()=> this.block.stop()))
        .subscribe(

            resultado => {

                this.fechar.emit(this.competenciaEditada);
            },
            erro => {
              switch(erro.status) {
                case 400:
                    if(erro.error.ERRORS){
                        this.showError(erro.error.ERRORS);
                    }
                    else if(erro.error.nome){
                        this.showError(erro.error.nome);
                    }

                    else if(erro.error.descricao){
                        this.showError(erro.error.descricao);
                    }

                    else if(erro.error.categoria){
                        this.showError(erro.error.categoria);
                    }
                  break;
                case 404:
                    this.fechar.emit();
                    console.log('Competência não localizada.');
                    break;
              }
            }
        );

    }

    finalizarFormulario() :void {
        if (typeof this.competenciaEditada === "undefined") {
            this.criarCompetencia();
        }
        else {
            this.atualizarCompetencia();
        }

    }

}
