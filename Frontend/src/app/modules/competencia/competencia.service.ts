import { Injectable } from "@angular/core";
import { CompetenciaModel } from "./models/competencia.model";

@Injectable()
export class CompetenciaService{

    //exemplo constante
    private static readonly constExample

    private competencias: CompetenciaModel[] = [];

    constructor(){
        this.competencias.push(new CompetenciaModel(1, 'Git', 'Versionamento de código', 5));
        this.competencias.push(new CompetenciaModel(2, 'Angular', 'Framework de FrontEnd', 2));
        this.competencias.push(new CompetenciaModel(3, 'Spring', 'Framework de Backend', 1));
    }

    getCompetencias(): CompetenciaModel[]{
        return this.competencias;
    }

}
