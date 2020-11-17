import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tipo_Evento} from '../_models/tipo_evento';

@Injectable({
  providedIn: 'root'
})
export class TipoEventoService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getTipos_Evento(){
    return this.http.get(this.API_URI+'/tipo_evento');
  }

  getTipo_Evento(id: number){
    return this.http.get(this.API_URI+'/tipo_evento/'+ id);
  }

  createTipo_Evento(tipoE: Tipo_Evento){
    return this.http.post(this.API_URI + '/tipo_evento', tipoE);
  }

  updateTipo_Evento(tipoE: Tipo_Evento){
    return this.http.put(this.API_URI + '/tipo_evento/' + tipoE.id, tipoE);
  }

  deleteTipo_Evento(id: number){
    return this.http.delete(this.API_URI + '/tipo_evento/'+ id);
  }


}
