import { CategoriaModel } from './categoria.model';
export class CompetenciaModel{

    id:number;
    nome:string;
    descricao: string;
    categoriaId: number;

    getNome():string{
        return this.nome;
    }

}
