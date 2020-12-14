export class Participa{
    id_participa: number;
    id_alumno: number;
    id_evento: number;

    constructor(id_participa, id_alumno, id_evento){
        this.id_participa = id_participa;
        this.id_alumno = id_alumno;
        this.id_evento = id_evento;
    }
}