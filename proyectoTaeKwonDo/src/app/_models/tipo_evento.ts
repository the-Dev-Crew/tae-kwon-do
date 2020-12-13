export class Tipo_Evento{
    id_tipo: number;
    nombre: string;
    descripcion: string;

    constructor(id, nombre, descripcion){
        this.id_tipo = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}