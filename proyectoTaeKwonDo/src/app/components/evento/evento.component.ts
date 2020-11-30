import { Component, OnInit } from '@angular/core';

import { Evento } from '../../_models/evento';
import { EventoService } from '../../_services/evento.service';

import { FormBuilder, Validators, FormGroup } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-evento',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.css']
})
export class EventoComponent implements OnInit {

  eventos: Evento[] | any;
  evento: Evento | any;
  eventoDetalles: Evento | any;
  eventoForm: FormGroup;
  editarEventoForm: FormGroup;
  submitted = false;

  constructor(private eventoService:EventoService, private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    //iniciamos el formulario vacío para evento nuevo.
    this.eventoForm = this.formBuilder.group({
      id_evento: [''],
      nombre: ['', Validators.required],
      fecha_inicio: ['', Validators.required],
      fecha_fin: ['', Validators.required],
      costo: ['', Validators.required],
      descripcion: ['', Validators.requiredTrue],
      //NOS FALTA VER QUE ONDA CON SU RESPECTIVA LISTA DE TIPO_EVENTO
      tipo_evento: ['', Validators.required]
    });
    //iniciamos el formulario vacío para modificar un evento.
    this.editarEventoForm = this.formBuilder.group({
      id_evento: [''],
      nombre: ['', Validators.required],
      fecha_inicio: ['', Validators.required],
      fecha_fin: ['', Validators.required],
      costo: ['', Validators.required],
      descripcion: ['', Validators.requiredTrue],
      //NOS FALTA VER QUE ONDA CON SU RESPECTIVA LISTA DE TIPO_EVENTO
      tipo_evento: ['', Validators.required]
    });
    this.getEventos();
  }

  //Consultamos la lista de todos los eventos en la base.
  getEventos(){
    this.eventos = [];
    this.eventoService.getEventos().subscribe(
      res => {
        this.eventos = res;
        console.log(this.eventos)
      },
      err => console.error(err)
    )

    this.eventos = [new Evento(1, "Cumpleaños de Aries", "2021-04-09", "2021-04-09", 55.55, "Evento para el cumpleaños de Aries.", []), new Evento(2, "Cumpleaños de Haans", "2021-04-16", "2021-04-16", 55.5,"Evento para festejar el cumpleaños de Haans", []), new Evento(3, "Cumpleaños de Christian", "2021-09-17", "2021-09-17", 55.5, "Evento para festejar el cumpleaños de Christian", [])];
  }

  //Obtenemos un evento en específico a partir de un id_evento.
  getEvento(id_evento){
    this.evento = null;
    this.eventoService.getEvento(id_evento).subscribe(
      res => {
        this.evento = res;
      },
      err => console.error(err)
    )
  }

  //Eliminamos un evento de la base a partir de su id_evento.
  deleteEvento(id_evento){
    this.eventoService.deleteEvento(id_evento).subscribe(
      res => {
        this.getEventos();
      },
      err => console.error(err) 
    )
  }

  //Creamos un evento nuevo y lo mandamos a la base.
  createEvento(){
    this.submitted = true;

    if(this.eventoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    let aux: Evento = this.eventoForm.value;
    console.log('Nuevo Evento: '+ aux.nombre);
    console.log('Fecha de Inicio: '+ aux.fecha_inicio);
    console.log('Fecha de Fin: '+ aux.fecha_fin);
    console.log('Costo: '+ aux.costo);
    console.log('Descripcion: '+ aux.descripcion);
    console.log('Tipo de Evento: '+ aux.tipo_evento);

    this.eventoService.createEvento(this.eventoForm.value).subscribe(
      res => {
        $("#eventoModal").modal("hide");
        this.getEventos();
      },
      err => console.error(err)
    )
  }

  //Actualizamos un evento existente en la base.
  updateEvento(){
    this.submitted = true;

    if(this.editarEventoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    this.eventoService.updateEvento(this.editarEventoForm.value).subscribe(
      res => {
        this.getEventos();
      },
      err => console.error(err)
    )
  }

  //No me acuerdo que hacen estas funciones xD
  get f() { return this.eventoForm.controls;}
  get fe(){ return this.editarEventoForm.controls;}

  //Modal para crear evento.
  openModalEvento(){
    this.eventoForm.reset();
    $("#eventoModal").modal("show");
  }

  //Modal para ver los datos de un Evento.
  openModalVerEvento(id_evento){
    this.getEvento(id_evento);
    this.eventoDetalles = this.eventos[(id_evento-1)];
    $("#verEventoModal").modal("show");
  }

  //Modal para editar un evento.
  openModalModificarEvento(evento){
    this.editarEventoForm.reset();
    this.editarEventoForm.setValue({
      id_evento: [evento.id_evento],
      nombre: [evento.nombre],
      fecha_inicio: [evento.fecha_inicio],
      fecha_fin: [evento.fecha_fin],
      costo: [evento.costo],
      descripcion: [evento.descripcion],
      tipo_evento: [evento.tipo_evento],
    });
    $("#modificarEvento").modal("show");
  }
}
