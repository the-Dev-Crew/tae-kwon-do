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
  alumnoDetalles: Alumno | any;
  alumnoForm: FormGroup;
  editarAlumnoForm: FormGroup;
  submitted = false;

  constructor(private alumnoService: AlumnoService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    //Inice el formulario.
    this.alumnoForm = this.formBuilder.group({
      //id: [''],
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
      username: ['', Validators.required]
    });
    this.editarAlumnoForm = this.formBuilder.group({
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
      username: ['', Validators.required]
    })

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
    
    //this.alumnos = [new Alumno(1, "Aries", "Becerra", "", "assets/img/karate.jpg", "1996-04-09", "000000000001", "9878967436574", "907867868768768", "TaeKwonDo", "Café", "BAries"), new Alumno (2, "Haans", "Lopez", "Hernández", "assets/img/karate.jpg", "1996-04-16", "000000000002", "", "", "TaeKwonDo", "Blanco", "killerhaans"), new Alumno(3, "Christian", "Tello", "Ruiz", "foto", "1996-09-21", "0000000003", "87364817364", "587294898475", "TaeKwonDo", "Amarillo", "ChrisTellox"), new Alumno(4, "Mauricio", "Apellido1", "Apellido2", "foto", "1996-05-03", "0000000004", "746578465874589", "4875874584708", "Tae Kwon Do", "Azul", "MauSinApellidos")];
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
        $("#verAlumnoModal").modal("hide");
      },
      err => console.error(err)
    )
  }

  // Crear un alumno
  createAlumno(){
    this.submitted = true;

    if(this.alumnoForm.invalid){
      console.log('Formulario inválido')
      return;
    }

    let aux: Alumno = this.alumnoForm.value;
    console.log("fecha" + aux.fotografia);
    $("#alumnoModal").modal("hide");

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

    if(this.editarAlumnoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    this.alumnoService.updateAlumno(this.editarAlumnoForm.value).subscribe(
      res => {
        this.getAlumnos();
      },
      err => console.error(err)
    )
  }

  get f() { return this.alumnoForm.controls;}
  get fe() {return this.editarAlumnoForm.controls;}
  
  //Ventana para formulario de agregar alumno.
  openModalAlumno(){    
    this.submitted = false;
    this.alumnoForm.reset();    
    $("#alumnoModal").modal("show");  
  }

  //Ventana para ver un alumno.
  openModalVerAlumno(alumno){
    this.alumnoDetalles = alumno;
    $("#verAlumnoModal").modal("show");
  }

  //Ventana para modificar un alumno.
  openModalModificarAlumno(alumno){
    this.editarAlumnoForm.reset();
    this.editarAlumnoForm.setValue({
      nombre: [alumno.nombre],
      a_paterno: [alumno.a_paterno],
      a_materno: [alumno.a_materno],
      fotografia: [''],
      fecha_nacimiento: [alumno.fecha_nacimiento],
      seguro_medico: [alumno.seguro_medico],
      certificado_medico: [''],
      carta_responsiva: [''],
      actividad: [alumno.actividad],
      grado: [alumno.grado],
      username: [alumno.username],
    });
    
    $("#modificarAlumno").modal("show");
  }
}
