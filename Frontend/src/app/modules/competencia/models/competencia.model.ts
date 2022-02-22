import { CategoriaModel } from './categoria.model';
export class CompetenciaModel{

    id:number;
    nome:string;
    descricao: string;
    categoria: CategoriaModel;

    getNome():string{
        return this.nome;
    }

}
