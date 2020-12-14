import { Component, OnInit } from '@angular/core';

import { Usuario } from '../../_models/usuario';
import { UsuarioService } from '../../_services/usuario.service';

import { FormBuilder, Validators, FormGroup } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  
  usuarios: Usuario[] | any;
  usuario: Usuario | any;
  usuarioDetalles: Usuario | any;
  usuarioForm: FormGroup;
  editarUsuarioForm: FormGroup;
  submitted = false;

  constructor(private usuarioService: UsuarioService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    // Inicie el formulario vacio
    this.usuarioForm = this.formBuilder.group({
      usuario: ['', Validators.required],
      password: ['', Validators.required],
      tipo_usuario: ['', Validators.required]
    });
    this.editarUsuarioForm = this.formBuilder.group({
      usuario: ['', Validators.required],
      password: ['', Validators.required],
      tipo_usuario: ['', Validators.required]
    });

    // Consulte lista personas
    this.getUsuarios();
  }

  getUsuarios(){
    this.usuarios = [];
    this.usuarioService.getUsuarios().subscribe(
      res => {
        this.usuarios = res;
        console.log(this.usuarios)
      },
      err => console.error(err)
    )
  }

  getUsuario(usuario){
    this.usuario = null;
    this.usuarioService.getUsuario(usuario).subscribe(
      res => {
        this.usuario = res;
      },
      err => console.error(err)
    )
  }

  deleteUsuario(usuario){
    this.usuarioService.deleteUsuario(usuario).subscribe(
      res => {
        this.getUsuarios();
      },
      err => console.error(err)
    )
  }

  createUsuario(){
    this.submitted = true;

    if(this.usuarioForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    let aux: Usuario = this.usuarioForm.value;
    console.log('Nuevo Usuario: '+ aux.usuario);
    console.log('Contraseña: ' + aux.password);
    console.log('tipo: ' + aux.tipo_usuario);

    $("#usuarioModal").modal("hide");
    this.usuarioService.createUsuario(this.usuarioForm.value).subscribe(
      res => {
        $("#usuarioModal").modal("hide");
        this.getUsuarios();
      },
      err => console.error(err)
    )
  }

  updateUsuario(){
    this.submitted = true;

    if(this.editarUsuarioForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    let aux: Usuario = this.editarUsuarioForm.value;
    console.log('Nuevo Usuario: '+ aux.usuario);
    console.log('Nueva contraseña: ' + aux.password);
    console.log('Nuevo tipo: ' + aux.tipo_usuario);
    $("#editarUsuarioModal").modal("hide");

    this.usuarioService.updateUsuario(this.editarUsuarioForm.value).subscribe(
      res => {
        $("#editarUsuarioModal").modal("hide");
        this.getUsuarios();
      },
      err => console.error(err)
    )
  }

  get f() { return this.usuarioForm.controls;}
  get fe() { return this.editarUsuarioForm.controls;}

  openModalUsuario(){
    this.submitted = false;
    this.usuarioForm.reset();
    $("#usuarioModal").modal("show");
  }

  openModalVerUsuario(usuario){
    this.usuarioDetalles = usuario;
    $("#verUsuarioModal").modal("show");
  }

  openModalEditarUsuario(user){
    this.editarUsuarioForm.reset();
    this.editarUsuarioForm.setValue({
      usuario: user.usuario,
      password: user.password,
      tipo_usuario: user.tipo_usuario,
    });
    $("#editarUsuarioModal").modal("show");
  }
}
