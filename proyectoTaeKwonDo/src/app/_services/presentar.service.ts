import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Presentar } from '../_models/presentar';
import { Examen } from '../_models/examen';
import { Alumno } from '../_models/alumno';

@Injectable({
  providedIn: 'root'
})
export class PresentarService {

  API_URI = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getPresentar(){
    return this.http.get(this.API_URI+'/presentar');
  }

  getExamenesPresentados(id_Alumno: number){
    return this.http.get(this.API_URI+'/presentar/alumno/'+id_Alumno);
  }

  getAlumnosPresentados(id_examen: number){
    return this.http.get(this.API_URI+'/presentar/examen/'+id_examen);
  }

  createPresentar(presentar: Presentar){
    return this.http.post(this.API_URI+'/presentar', presentar);
  }

  deletePresentar(id_Alumno: number, id_examen: number){
    return this.http.delete(this.API_URI+'/presentar/'+id_examen+'/'+id_Alumno);
  }
}
