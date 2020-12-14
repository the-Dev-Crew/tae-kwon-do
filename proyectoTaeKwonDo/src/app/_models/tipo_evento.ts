export class Tipo_Evento{
    id_tipo: number;
    nombre: string;
    descripcion: string;

    constructor(id_tipo, nombre, descripcion){
        this.id_tipo = id_tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}