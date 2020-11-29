import { Component, OnInit } from '@angular/core';

import { Examen } from '../../_models/examen';
import { ExamenService } from '../../_services/examen.service';

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
  submitted = false;

  constructor(private examenService:ExamenService, private formBuilder: FormBuilder) { }

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
    this.examen = null;
    this.examenService.getExamen(id_examen).subscribe(
      res => {
        this.examen = res;
      },
      err => console.error(err)
    )
  }

  //Eliminamos un examen a partir de su id_examen.
  deleteExamen(id_examen){
    this.examenService.deleteExamen(id_examen).subscribe(
      res => {
        this.getExamenes();
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
      },
      err => console.error(err)
    )
  }

  //No me acuerdo para que son estas funciones.
  get f() { return this.examenForm.controls;}
  get fe() { return this.editarExamenForm.controls;}

  //Modal para crear examen.
  openModalExamen(){
    this.examenForm.reset();
    $("#examenModal").modal("show");
  }

  //Modal para ver los detalles de un examen.
  openModalVerExamen(id_examen){
    this.getExamen(id_examen);
    this.examenDetalles = this.examenes[(id_examen-1)];
    $("#verExamenModal").modal("show");
  }
}
