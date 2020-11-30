import { ThrowStmt } from '@angular/compiler';
import { Tipo_Evento } from './tipo_evento';

export class Evento{
    id_evento: number;
    nombre: string;
    fecha_inicio: Date;
    fecha_fin: Date;
    costo: number;
    descripcion: string;
    //tipo_evento: Tipo_Evento[];

    constructor(id_evento, nombre, fecha_inicio, fecha_fin, costo, descripcion/*, tipo_evento*/){
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.costo = costo;
        this.descripcion = descripcion;
        //this.tipo_evento = tipo_evento;
    }
}