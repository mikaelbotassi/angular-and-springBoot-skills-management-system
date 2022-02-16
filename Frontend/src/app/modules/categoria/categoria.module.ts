import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CategoriaRoutingModule} from './categoria-routing.module';


@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        CategoriaRoutingModule
    ]
})
export class CategoriaModule {
    id: number;
    descricao: string;
}
