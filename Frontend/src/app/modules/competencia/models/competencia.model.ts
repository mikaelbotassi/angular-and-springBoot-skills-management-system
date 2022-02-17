import { CategoriaModel } from './categoria.model';
export class CompetenciaModel{
    id: number;
    nome: String;
    descricao: String;
    categoria: CategoriaModel;

    constructor(id:number, nome:String, descricao: String, idCategoria: number){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = new CategoriaModel(idCategoria);
    }

}
