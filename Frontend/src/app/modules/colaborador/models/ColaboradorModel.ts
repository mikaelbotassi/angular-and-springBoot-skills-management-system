export class ColaboradorModel{
    constructor(
    public id : number,

    public nome : String,

    public sobrenome : String,

    public cpf : String,

    public foto : ArrayBuffer,

    public email : String,

    public dataNascimento : Date,

    public dataAdmissao : Date,

    public nomeSenioridade : String,

    public idSenioridade : number,
    ) {}
   
}

