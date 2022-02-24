import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { SenioridadeService } from './services/senioridade.service';

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [
        SenioridadeService,
    ],
    exports: [
        PRIMENG_IMPORTS,
    ]
})
export class SharedModule { }
