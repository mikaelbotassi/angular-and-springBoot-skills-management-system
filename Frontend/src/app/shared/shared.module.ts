import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { PRIMENG_IMPORTS } from './primeng-imports';


@NgModule({
    imports: [
        FormsModule,
        ReactiveFormsModule,
        PRIMENG_IMPORTS,
    ],
    providers: [],
    exports: [
        FormsModule,
        ReactiveFormsModule,
        PRIMENG_IMPORTS,
    ]
})
export class SharedModule { }
