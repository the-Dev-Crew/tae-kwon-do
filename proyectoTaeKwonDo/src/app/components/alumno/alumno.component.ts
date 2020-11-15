import { Component, OnInit } from '@angular/core';

import { Alumno } from '../../_models/alumno';
import { AlumnoService } from '../../_services/alumno.service';

import { FormBuilder, Validators, FormGroup, ReactiveFormsModule } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent implements OnInit {

  alumnos: Alumno[] | any;
  alumno: Alumno | any;
  alumnoForm: FormGroup;
  submitted = false;

  constructor(private alumnoService: AlumnoService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    //Inice el formulario.
    this.alumnoForm = this.formBuilder.group({
      id: [''],
      nombre: ['', Validators.required],
      a_paterno: ['', Validators.required],
      a_materno: ['', Validators.required],
      fotografia: ['', Validators.required],
      fecha_nacimiento: ['', Validators.required],
      seguro_medico: ['', Validators.required],
      certificado_medico: ['', Validators.required],
      carta_responsiva: ['', Validators.required],
      actividad: ['', Validators.required],
      grado: ['', Validators.required],
      usuario: ['', Validators.required]
    });

    //Consulta lista de alumnos.
    this.getAlumnos();
  }

  // Consultar lista de alumnos
  getAlumnos(){
    this.alumnos = [];
    this.alumnoService.getAlumnos().subscribe(
      res => {
        this.alumnos = res;
        console.log(this.alumnos)
      },
      err => console.error(err)
    )
    
    this.alumnos = [new Alumno(1, "Aries", "Becerra", " ", "algo", "1996-04-09", "000000000001", "9878967436574", "907867868768768", "TaeKwonDo", "Café", "BAries"), new Alumno(2, "Christian", "Tello", "Ruiz", "foto", "1996-09-20", "0000000002", "87364817364", "587294898475", "TaeKwonDo", "Amarillo", "ChrisTellox"), new Alumno(3, "Mauricio", "Apellido1", "Apellido2", "foto", "1996-05-03", "0000000003", "746578465874589", "4875874584708", "Tae Kwon Do", "Azul", "MauSinApellidos")];
  }

  // Consultar un alumno
  getAlumno(id){
    this.alumno = null;
    this.alumnoService.getAlumno(id).subscribe(
      res => {
        this.alumno = res;
      },
      err => console.error(err)
    )
  }

  // Eliminar un alumno
  deleteAlumno(id){
    this.alumnoService.deleteAlumno(id).subscribe(
      res => {
        this.getAlumnos();
      },
      err => console.error(err)
    )
  }

  // Crear un alumno
  createAlumno(){
    this.submitted = true;

    if(this.alumnoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    this.alumnoService.createAlumno(this.alumnoForm.value).subscribe(
      res => {
        $("#alumnoModal").modal("hide");
        this.getAlumnos();
      },
      err => console.error(err)
    )
  }

  // Actualizar un usuario
  updateAlumno(){
    this.submitted = true;

    if(this.alumnoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    this.alumnoService.updateAlumno(this.alumnoForm.value).subscribe(
      res => {
        this.getAlumnos();
      },
      err => console.error(err)
    )
  }

  get f() { return this.alumnoForm.controls;}
  
  //Ventana para formulario de agregar alumno.
  openModalAlumno(){    
    this.alumnoForm.reset();    
    $("#alumnoModal").modal("show");  
  }
}
