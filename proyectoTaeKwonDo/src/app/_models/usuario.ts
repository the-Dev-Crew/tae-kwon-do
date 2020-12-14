export class Usuario{
    username: String;
    password: String;
    tipo_usuario: number;

    constructor(username, password, tipo_usuario){ 
        this.username = username;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }

}