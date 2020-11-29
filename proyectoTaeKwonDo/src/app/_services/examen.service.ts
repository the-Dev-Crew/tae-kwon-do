import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Examen } from '../_models/examen';

@Injectable({
  providedIn: 'root'
})
export class ExamenService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getExamenes(){
    return this.http.get(this.API_URI+'/examen');
  }

  getExamen(id_examen: number){
    return this.http.get(this.API_URI+'/examen/'+id_examen);
  }

  createExamen(examen: Examen){
    return this.http.post(this.API_URI+'/examen', examen);
  }

  updateExamen(examen: Examen){
    return this.http.put(this.API_URI+'/examen/'+examen.id_examen, examen);
  }

  deleteExamen(id_examen: number){
    return this.http.delete(this.API_URI+'/examen/'+id_examen);
  }
}
