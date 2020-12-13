export class Usuario{
    username: String;
    password: String;
    tipo_usuario: number;

    constructor(usuario, password, tipo_usuario){ 
        this.username = usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }

}