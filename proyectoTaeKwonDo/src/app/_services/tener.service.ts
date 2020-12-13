import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tener } from '../_models/tener';

@Injectable({
  providedIn: 'root'
})
export class TenerService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getTener(){
    return this.http.get(this.API_URI+'/tener');
  }

  getEventosDeTipo(id_tipo_evento: number){
    return this.http.get(this.API_URI+'/tener/tipo_evento/'+id_tipo_evento);
  }

  getTiposDelEvento(id_evento: number){
    return this.http.get(this.API_URI+'/tener/evento/'+id_evento);
  }

  createTener(tener: Tener){
    return this.http.post(this.API_URI+'/tener', tener);
  }

  deleteTener(id_evento: number, id_tipo: number){
    return this.http.delete(this.API_URI+'/tener/'+id_evento+'/'+id_tipo);
  }
}
