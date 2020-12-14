export class Relacionar{
    id_relacionar: number;
    id_evento: number;
    actividad: string;

    constructor( id_evento, actividad){
        this.id_evento = id_evento;
        this.actividad = actividad;
    }
}