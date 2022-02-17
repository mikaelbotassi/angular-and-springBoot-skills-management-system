const NOME_CATEGORIA: String[] = ["Backend", "Frontend", "Banco", "Arquitetura", "Metodologia Ágil", "Testes",
    "Devops", "Liderança"];

export class CategoriaModel{

    id: number;
    nome: String;

    constructor(id:number){

        this.id = id;
        this.nome = NOME_CATEGORIA[id-1];
    }
}
