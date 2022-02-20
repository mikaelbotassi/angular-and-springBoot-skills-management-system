import { CategoriaModel } from './categoria.model';
export class CompetenciaModel{

    id:number;
    nome:string;
    descricao: string;
    categoriaId: number;
    categoriaNome: string;

    getNome():string{
        return this.nome;
    }

}
