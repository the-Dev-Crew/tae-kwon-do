import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Evento } from '../_models/evento';

@Injectable({
  providedIn: 'root'
})
export class EventoService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  //Obtenemos un listados de todos los eventos en la base.
  getEventos(){
    return this.http.get(this.API_URI+'/evento')
  }

  //Obtenemos un evento en específico del cual contamos con su id_evento.
  getEvento(id_evento: number){
    return this.http.get(this.API_URI+'/evento/'+id_evento)
  }

  //Creamos un evento nuevo desde cero y lo mandamos a guardar en la base.
  createEvento(evento: Evento){
    return this.http.post(this.API_URI+'/evento', evento);
  }

  //Modificamos los datos (uno o más) de un evento en específico y guardamos dichos cambios en la base.
  updateEvento(evento: Evento){
    return this.http.put(this.API_URI+'/evento/'+evento.id_evento, evento);
  }

  //Borramos un evento en especifíco de la base a partir de su id_evento.
  deleteEvento(id_evento: number){
    return this.http.delete(this.API_URI+'/evento/'+id_evento);
  }
}
