export class CadastrarColaboradorModel{
    constructor(
        public nome : String,

        public sobrenome : String,
    
        public cpf : String,
    
        public email : String,
    
        public dataNascimento : Date,
    
        public dataAdmissao : Date,
    
        public  idSenioridade : number,
    
        public competencia : Array<any> ,

    ) {}
}