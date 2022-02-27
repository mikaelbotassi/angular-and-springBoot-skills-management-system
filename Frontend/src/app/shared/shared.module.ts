import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { PRIMENG_IMPORTS } from './primeng-imports';
import { SenioridadeService } from './services/senioridade.service';
import { MessageService } from 'primeng';


@NgModule({
    imports: [

        FormsModule,
        ReactiveFormsModule,
        PRIMENG_IMPORTS,
    ],
    providers: [
        SenioridadeService,
    ],
    exports: [

        FormsModule,
        ReactiveFormsModule,
        PRIMENG_IMPORTS,
    ],
    declarations: []
})
export class SharedModule { }
