export class Usuario{
    usuario: String;
    password: String;
    tipo_usuario: String;

    constructor(usuario, password, tipo_usuario){ 
        this.usuario = usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }

}