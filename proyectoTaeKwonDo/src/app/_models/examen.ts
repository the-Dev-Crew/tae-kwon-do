import { ThrowStmt } from '@angular/compiler';

export class Examen{
    id_examen: number;
    nombre: string;
    costo: number;
    tipo: string;
    fecha: Date;
    actividad: string;
    grado: string;

    constructor(id_examen, nombre, costo, tipo, fecha, actividad, grado){
        this.id_examen = id_examen;
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.actividad = actividad;
        this.grado = grado;
    }
}