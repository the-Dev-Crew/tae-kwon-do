import { Component, OnInit } from '@angular/core';

import { Evento } from '../../_models/evento';
import { Alumno } from '../../_models/alumno';
import { Tener } from '../../_models/tener';
import { Relacionar } from '../../_models/relacionar';
import { Participa } from '../../_models/participa';
import { EventoService } from '../../_services/evento.service';
import { ParticipaService } from '../../_services/participa.service';
import { TenerService } from '../../_services/tener.service';
import { RelacionarService } from '../../_services/relacionar.service';

import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Tipo_Evento } from 'src/app/_models/tipo_evento';

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
  inscribirAlumnoForm: FormGroup;
  agregarTipoEventoForm: FormGroup;
  actividadesForm: FormGroup;
  submitted = false;
  alumnos: Alumno[] | any;
  tipos: Tipo_Evento[] | any;
  actividades: string[] | any;
  actividadesBoolean: boolean[] | any;

  constructor(private eventoService:EventoService, private relacionarService:RelacionarService, private participaService:ParticipaService, private tenerService:TenerService, private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    //iniciamos el formulario vacío para evento nuevo.
    this.eventoForm = this.formBuilder.group({
      id_evento: [''],
      nombre: ['', Validators.required],
      fecha_inicio: ['', Validators.required],
      fecha_fin: ['', Validators.required],
      costo: ['', Validators.required],
      descripcion: [''],
      //NOS FALTA VER QUE ONDA CON SU RESPECTIVA LISTA DE TIPO_EVENTO
      //tipo_evento: ['', Validators.required]
    });
    //iniciamos el formulario vacío para modificar un evento.
    this.editarEventoForm = this.formBuilder.group({
      id_evento: [''],
      nombre: ['', Validators.required],
      fecha_inicio: ['', Validators.required],
      fecha_fin: ['', Validators.required],
      costo: ['', Validators.required],
      descripcion: [''],
      //NOS FALTA VER QUE ONDA CON SU RESPECTIVA LISTA DE TIPO_EVENTO
      //tipo_evento: ['', Validators.required]
    });
    this.inscribirAlumnoForm = this.formBuilder.group({
      id_participa: [''],
      id_alumno: ['', Validators.required],
      id_evento: ['', Validators.required]
    });
    this.agregarTipoEventoForm = this.formBuilder.group({
      id_tener: [''],
      id_evento: ['', Validators.required],
      id_tipo: ['', Validators.required]
    });
    this.actividadesForm = this.formBuilder.group({
      taekwondo : '',
      kickboxing : '',
      acondicionamiento: ''
    })
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

    //this.eventos = [new Evento(1, "Cumpleaños de Aries", "2021-04-09", "2021-04-09", 55.55, "Evento para el cumpleaños de Aries.", []), new Evento(2, "Cumpleaños de Haans", "2021-04-16", "2021-04-16", 55.5,"Evento para festejar el cumpleaños de Haans", []), new Evento(3, "Cumpleaños de Christian", "2021-09-17", "2021-09-17", 55.5, "Evento para festejar el cumpleaños de Christian", [])];
  }

  //Obtenemos un evento en específico a partir de un id_evento.
  getEvento(id_evento){
    this.eventoDetalles = null;
    this.eventoService.getEvento(id_evento).subscribe(
      res => {
        this.eventoDetalles = res;
      },
      err => console.error(err)
    )
  }

  //Eliminamos un evento de la base a partir de su id_evento.
  deleteEvento(id_evento){
    this.eventoService.deleteEvento(id_evento).subscribe(
      res => {
        this.getEventos();
        $("#verEventoModal").modal("hide");
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
    //console.log('Tipo de Evento: '+ aux.tipo_evento);

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

    let aux: Evento = this.editarEventoForm.value;
    console.log('Nuevo Evento: '+ aux.nombre);
    console.log('Fecha de Inicio: '+ aux.fecha_inicio);
    console.log('Fecha de Fin: '+ aux.fecha_fin);
    console.log('Costo: '+ aux.costo);
    console.log('Descripcion: '+ aux.descripcion);

    this.eventoService.updateEvento(this.editarEventoForm.value).subscribe(
      res => {
        $("#modificarEvento").modal("hide");
        this.openModalVerEvento(this.editarEventoForm.value);
        this.getEventos();
      },
      err => console.error(err)
    )
  }

  createParticipa(){
    this.submitted = true;

    if(this.inscribirAlumnoForm.invalid){
      console.log('Formulario inválido');
      return
    }

    let aux: Participa = this.inscribirAlumnoForm.value;
    //console.log('id_participa: '+aux.id_participa);
    console.log('id_alumno: '+aux.id_alumno);
    console.log('id_evento: '+aux.id_evento);

    this.participaService.createParticipa(this.inscribirAlumnoForm.value).subscribe(
      res => {
        $("#inscribirAlumno").modal("hide");
        this.openModalVerEvento(this.eventoDetalles);
      },
      err => console.error(err)
    )

  }

  createTener(){
    this.submitted = true;

    if(this.agregarTipoEventoForm.invalid){
      console.log('Formulario inválido');
      return
    }

    let aux: Tener = this.agregarTipoEventoForm.value;

    console.log('id_tener: '+aux.id_tener);
    console.log('id_evento: '+aux.id_evento);
    console.log('id_tipo: '+aux.id_tipo);

    this.tenerService.createTener(this.agregarTipoEventoForm.value).subscribe(
      res => {
        $("#agregarTipoEvento").modal("hide");
        this.openModalVerEvento(this.eventoDetalles);
      },
      err => console.error(err)
    )
  }

  cambiarActividades(){
    var sel=[],nosel=[];
    $('form input:checkbox').map(function(){
      if($(this).prop('checked')){
        sel.push($(this).attr('id'));
    }else{
        nosel.push($(this).attr('id'));
    }
    })
    this.relacionarService.deleteRelacionar(this.eventoDetalles.id_evento, "taekwondo").subscribe(
      res => {
      },
      err => console.error(err)
    )
    this.relacionarService.deleteRelacionar(this.eventoDetalles.id_evento, "kickboxing").subscribe(
      res => {
      },

    )
    this.relacionarService.deleteRelacionar(this.eventoDetalles.id_evento, "acondicionamiento").subscribe(
      res => {
      },

    )
    for(let i = 0;  i < sel.length; i++){
      let aux: Relacionar = {id_relacionar:null, id_evento:this.eventoDetalles.id_evento, actividad: sel[i]};
      this.relacionarService.createRelacionar(aux).subscribe(
        res => {
          this.openModalVerEvento(this.eventoDetalles);
        },
      )
    }
    $("#actividadesModal").modal("hide");


  }

  delete(evento, alumno){
    this.participaService.deleteParticipa(alumno.id_Alumno, evento.id_evento).subscribe(
      res => {
        this.openModalVerEvento(evento);
      },
      err => console.error(err)
    )
  }

  get f() { return this.eventoForm.controls;}
  get fe(){ return this.editarEventoForm.controls;}
  get fee() {return this.inscribirAlumnoForm.controls;}
  get feee() {return this.agregarTipoEventoForm.controls;}

  //Modal para crear evento.
  openModalEvento(){
    this.submitted = false;
    this.eventoForm.reset();
    $("#eventoModal").modal("show");
  }

  //Modal para ver los datos de un Evento.
  openModalVerEvento(evento){
    this.submitted = false;
    this.eventoDetalles = evento;
    this.alumnos = null;
    this.participaService.getAlumnosParticipando(evento.id_evento).subscribe(
      res => {
        this.alumnos = res;
      },
      err => console.error(err)
    )
    this.tipos = null;
    this.tenerService.getTiposDelEvento(evento.id_evento).subscribe(
      res => {
        this.tipos = res;
      },
      err => console.error(err)
    )
    this.actividades = null;
    this.relacionarService.getActividadesEvento(evento.id_evento).subscribe(
      res => {
        this.actividades = res;
      },
      err => console.error(err)      
    )

    $("#verEventoModal").modal("show");
  }

  //Modal para editar un evento.
  openModalModificarEvento(evento){
    this.submitted = false;
    this.editarEventoForm.reset();
    this.editarEventoForm.setValue({
      id_evento: evento.id_evento,
      nombre: evento.nombre,
      fecha_inicio: evento.fecha_inicio.substring(0, 10),
      fecha_fin: evento.fecha_fin.substring(0, 10),
      costo: evento.costo,
      descripcion: evento.descripcion,
      //tipo_evento: [evento.tipo_evento],
    });
    $("#modificarEvento").modal("show");
  }

  openModalInscribirAlumno(id_evento){
    this.submitted = false;
    this.inscribirAlumnoForm.reset();
    this.inscribirAlumnoForm.setValue({
      id_participa: '',
      id_alumno: '',
      id_evento: id_evento,
    });
    $("#inscribirAlumno").modal("show");
    $("#verEventoModal").modal("hide");
  }

  openModalAgregarTipo(id_evento){
    this.submitted = false;
    this.agregarTipoEventoForm.reset();
    this.agregarTipoEventoForm.setValue({
      id_tener: '',
      id_evento: id_evento,
      id_tipo: '',
    });
    $("#agregarTipoEvento").modal("show");
    $("#verEventoModal").modal("hide");
  }
  openModalActividades(eventoDetalles){
    this.submitted = false;
    this.actividadesForm.reset();
    this.actividadesForm.setValue({
      taekwondo : '',
      kickboxing : '',
      acondicionamiento: ''
    });
    $("#actividadesModal").modal("show");
    $("#verEventoModal").modal("hide");
  }
}
