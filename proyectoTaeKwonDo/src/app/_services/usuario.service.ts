import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../_models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  API_URI = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  getUsuarios(){
    return this.http.get(this.API_URI+'/usuario');
  }

  getUsuario(username: string){
    return this.http.get(this.API_URI+'/usuario/'+username);
  }

  createUsuario(usuario: Usuario){
    return this.http.post(this.API_URI+'/usuario', usuario);
  }

  updateUsuario(usuario: Usuario){
    return this.http.put(this.API_URI+'/usuario/'+ usuario.username, usuario);
  }

  deleteUsuario(username: string){
    return this.http.delete(this.API_URI+'/usuario/'+username);
  }
}
