export class Presentar{
    id_presentar: number;
    id_alumno: number;
    id_examen: number;

    constructor(id_presentar, id_alumno, id_examen){
        this.id_presentar = id_presentar;
        this.id_alumno = id_alumno;
        this.id_examen = id_examen;
    }
}