import { ThrowStmt } from '@angular/compiler';

export class Alumno{
    id: number;
    nombre: string;
    a_paterno: string;
    a_materno: string;
    fotografia: string;
    fecha_nacimiento: Date;
    seguro_medico: string;
    certificado_medico: string;
    carta_responsiva: string;
    actividad: string;
    grado: string;
    username: string;
    

    constructor(id, nombre, a_paterno, a_materno, fotografia, fecha_nacimiento, seguro_medico, certificado_medico, carta_responsiva, actividad, grado, username){
        this.id = id;
        this.nombre = nombre;
        this.a_paterno = a_paterno;
        this.a_materno = a_materno;
        this.fotografia = fotografia;
        this.fecha_nacimiento = fecha_nacimiento;
        this.seguro_medico = seguro_medico;
        this.certificado_medico = certificado_medico;
        this.carta_responsiva = carta_responsiva;
        this.actividad = actividad;
        this.grado = grado;
        this.username = username;
    }

}