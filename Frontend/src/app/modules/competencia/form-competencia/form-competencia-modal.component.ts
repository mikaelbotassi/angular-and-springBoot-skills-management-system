import { Component, AfterViewInit, ViewChild } from '@angular/core';
import {DialogService, DynamicDialogRef, DynamicDialogConfig} from 'primeng/dynamicdialog';

@Component({
    selector: 'app-competencia-form-modal',
    template: '<app-form-competencia (fechar)="ref.close($event)" [competenciaEditada] = config.data.competencia></app-form-competencia>',
    providers: [DialogService]
})
export class FormCompetenciaModalComponent implements AfterViewInit{

    // @ViewChild(FormCompetenciaComponent, {static: false}) form:FormCompetenciaComponent;

    constructor(public ref: DynamicDialogRef, public config:DynamicDialogConfig) {}

    ngAfterViewInit(): void {
    }

}
