import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Participa } from '../_models/participa';

@Injectable({
  providedIn: 'root'
})
export class ParticipaService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getParticipa(){
    return this.http.get(this.API_URI+'/participa');
  }

  getEventosParticipado(id_Alumno: number){
    return this.http.get(this.API_URI+'/participa/alumno/'+id_Alumno);
  }

  getAlumnosParticipando(id_evento: number){
    return this.http.get(this.API_URI+'/participa/evento/'+id_evento);
  }

  createParticipa(participa: Participa){
    return this.http.post(this.API_URI+'/participa', participa);
  }

  deleteParticipa(id_Alumno: number, id_evento: number){
    return this.http.delete(this.API_URI+'/participa/'+id_evento+'/'+id_Alumno);
  }
}
