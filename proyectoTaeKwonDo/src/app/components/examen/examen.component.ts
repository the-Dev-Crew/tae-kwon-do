import { Component, OnInit } from '@angular/core';

import { Examen } from '../../_models/examen';
import { Presentar } from '../../_models/presentar';
import { ExamenService } from '../../_services/examen.service';
import { PresentarService } from '../../_services/presentar.service';

import { FormBuilder, Validators,FormGroup } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-examen',
  templateUrl: './examen.component.html',
  styleUrls: ['./examen.component.css']
})
export class ExamenComponent implements OnInit {

  examenes: Examen[] | any;
  examen: Examen | any;
  examenDetalles: Examen | any;
  examenForm: FormGroup;
  editarExamenForm: FormGroup;
  inscribirAlumnoForm: FormGroup; 
  submitted = false;

  constructor(private examenService:ExamenService, private presentarService:PresentarService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    //iniciamos el formulario vacío para nuevo examen
    this.examenForm = this.formBuilder.group({
      id_examen: [''],
      nombre: ['', Validators.required],
      costo: ['', Validators.required],
      tipo: ['', Validators.required],
      fecha: ['', Validators.required],
      actividad: ['', Validators.required],
      grado: ['', Validators.required]
    });
    //iniciamos el formulario para modificar un examen en específico.
    this.editarExamenForm = this.formBuilder.group({
      id_examen: [''],
      nombre: ['', Validators.required],
      costo: ['', Validators.required],
      tipo: ['', Validators.required],
      fecha: ['', Validators.required],
      actividad: ['', Validators.required],
      grado: ['', Validators.required]
    });
    this.inscribirAlumnoForm = this.formBuilder.group({
      id_presentar: [''],
      id_alumno: ['', Validators.required],
      id_examen:['', Validators.required]
    });
    this.getExamenes();
  }

  //Consultamos la lista de todos los examenes en la base.
  getExamenes(){
    this.examenes = [];
    this.examenService.getExamenes().subscribe(
      res => {
        this.examenes = res;
        console.log(this.examenes)
      },
      err => console.error(err)
    )

    this.examenes = [new Examen(1, 'Examen de Cinta', 500.00, 'Cambio de Cinta', '2021-12-04', 'taekwondo', 'café'), new Examen(2, 'Examen de Colocación', 500.00, 'colocación de grado', '2021-12-05', 'taekwondo', 'todos los grados')];
  }

  //Obtenemos un examen en específico a partir de un id_examen.
  getExamen(id_examen){
    this.examenDetalles = null;
    this.examenService.getExamen(id_examen).subscribe(
      res => {
        this.examenDetalles = res;
      },
      err => console.error(err)
    )
  }

  //Eliminamos un examen a partir de su id_examen.
  deleteExamen(id_examen){
    this.examenService.deleteExamen(id_examen).subscribe(
      res => {
        this.getExamenes();
        $("#verExamenModal").modal("hide");
      },
      err => console.error(err)
    )
  }

  //Creamos un examen nuevo y mandamos a la base.
  createExamen(){
    this.submitted = true;

    if(this.examenForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    let aux: Examen = this.examenForm.value;
    console.log('Nuevo Examen: '+ aux.nombre);
    console.log('Costo: ' + aux.costo);
    console.log('tipo: ' + aux.tipo);
    console.log('fecha: ' + aux.fecha);
    console.log('Actividad: ' + aux.actividad);
    console.log('grado: ' + aux.grado);
    $("examenModal").modal("hide");
    this.examenService.createExamen(this.examenForm.value).subscribe(
      res => {
        $("#examenModal").modal("hide");
        this.getExamenes();
      },
      err => console.error(err)
    )
  }

  //Actualizamos un examen ya existente.
  updateExamen(){
    this.submitted = true;
    
    if(this.editarExamenForm.invalid){
      console.log("Formulario inválido");
      return;
    }

    this.examenService.updateExamen(this.editarExamenForm.value).subscribe(
      res => {
        this.getExamenes();
        $("#modificarExamen").modal("hide");
      },
      err => console.error(err)
    )
  }

  //Aquí creamos el objeto presentar para agregar la participación de un alumno en un examen 
  createPresentar(){
    this.submitted = true;

    if(this.inscribirAlumnoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    let aux: Presentar = this.inscribirAlumnoForm.value;
    console.log('id_presentar: '+ aux.id_presentar);
    console.log('id_Alumno: '+ aux.id_alumno);
    console.log('id_examen: ' + aux.id_examen);

    this.presentarService.createPresentar(this.inscribirAlumnoForm.value).subscribe(
      res => {
        $("#inscribirAlumno").modal("hide");
        this.getExamenes();
      },
      err => console.error(err)
    )
  }

  //No me acuerdo para que son estas funciones.
  get f() { return this.examenForm.controls;}
  get fe() { return this.editarExamenForm.controls;}
  get fee() { return this.inscribirAlumnoForm.controls;}

  //Modal para crear examen.
  openModalExamen(){
    this.examenForm.reset();
    $("#examenModal").modal("show");
  }

  //Modal para ver los detalles de un examen.

  openModalVerExamen(examen){
    this.submitted = false;
    this.examenDetalles = examen;
    $("#verExamenModal").modal("show");
  }

  openModalModificarExamen(examen){
    this.submitted = false;
    this.editarExamenForm.reset();
    this.editarExamenForm.setValue({
      id_examen: examen.id_examen,
      nombre: examen.nombre,
      costo: examen.costo,
      tipo: examen.tipo,
      fecha: examen.fecha.substring(0, 10),
      actividad: examen.actividad,
      grado: examen.grado,
    });
    $("#modificarExamen").modal("show");
  }

  openModalInscribirAlumno(id_examen){
    this.submitted = false;
    this.inscribirAlumnoForm.reset();
    this.inscribirAlumnoForm.setValue({
      id_presentar: '',
      id_alumno: '',
      id_examen: id_examen,
    });
    $("#inscribirAlumno").modal("show");
    $("#verExamenModal").modal("hide");
  }
}
