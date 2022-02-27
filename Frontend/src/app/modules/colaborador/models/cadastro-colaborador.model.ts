import { CadastrarCompetenciaModel } from "../../competencia/models/cadastro-competencia.model";

export class CadastrarColaboradorModel{
    constructor(
        public id : number,
        
        public nome : String,

        public sobrenome : String,
    
        public cpf : String,
    
        public email : String,
    
        public dataNascimento : Date,
    
        public dataAdmissao : Date,

        public foto : string, 
    
        public  idSenioridade : number,
    
        public competencia : Array<CadastrarCompetenciaModel> ,

    ) {}
}