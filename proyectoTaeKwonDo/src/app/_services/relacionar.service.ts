import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Relacionar } from '../_models/relacionar';

@Injectable({
  providedIn: 'root'
})
export class RelacionarService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getRelacionar(){
    return this.http.get(this.API_URI+'/relacionar');
  }
  getRelacionadosConActividad( actividad: string){
    return this.http.get(this.API_URI+'/relacionar/actividad/'+ actividad);
  }

  getActividadesEvento( id_evento: number){
    return this.http.get(this.API_URI+'/relacionar/evento/'+ id_evento);
  }

  createTener(relacionar: Relacionar){
    return this.http.post(this.API_URI+'/relacionar', relacionar);
  }

  deleteRelacionar(id_evento: number, actividad: string){
    return this.http.delete(this.API_URI+'/relacionar/'+id_evento+'/'+actividad);
  }
}
