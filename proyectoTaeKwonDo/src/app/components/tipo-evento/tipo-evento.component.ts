import { Component, OnInit } from '@angular/core';

import { Tipo_Evento } from '../../_models/tipo_evento';
import { TipoEventoService } from '../../_services/tipo-evento.service';

import { FormBuilder, Validators, FormGroup } from '@angular/forms';

declare var $: any;

@Component({
  selector: 'app-tipo-evento',
  templateUrl: './tipo-evento.component.html',
  styleUrls: ['./tipo-evento.component.css']
})
export class TipoEventoComponent implements OnInit {
  tiposEvento: Tipo_Evento[] | any;
  tipoEvento: Tipo_Evento | any;
  tipoEventoForm: FormGroup;
  editarTipoEventoForm: FormGroup;
  submitted = false;
  constructor(private tipoEventoService: TipoEventoService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    //inicie el formulario vacio
    /*this.tipoEventoForm = this.formBuilder.group([
      id: [''],
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required]
    ]);
    this.editarTipoEventoForm =this.formBuilder.group([
      id: [''],
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required]
    ]);*/

  }

  getTipos_Evento(){
    this.tiposEvento = [];
    this.tipoEventoService.getTipos_Evento().subscribe(
      res => {
        this.tiposEvento = res;
        console.log(this.tiposEvento)
      },
      err => console.error(err)
    )
  }

  getTipo_Evento(id){
    this.tipoEvento = null;
    this.tipoEventoService.getTipo_Evento(id).subscribe(
      res => {
        this.tipoEvento = res;
      },
      err => console.error(err)
    )
  }

  deleteTipo_Evento(id){
    this.tipoEventoService.deleteTipo_Evento(id).subscribe(
      res => {
        this.getTipos_Evento();
      },
      err => console.error(err)
    )
  }

  createTipo_Evento(){
    this.submitted = true;

    if(this.tipoEventoForm.invalid){
      console.log('Formulario Inválido');
      return;
    }

    let aux: Tipo_Evento = this.tipoEventoForm.value;
    console.log('Nuevo Tipo de Evento: '+ aux.nombre);
    console.log('Descripcion: ' + aux.descripcion);
    //$("tipoEventoModal").modal("hide");
    this.tipoEventoService.createTipo_Evento(this.tipoEventoForm.value).subscribe(
      res => {
        //$("tipoEventoModal").modal("hide");
        this.getTipos_Evento();
      },
      err => console.error(err)
    )
  }

  updateTipo_Evento(){
    this.submitted = true;

    if(this.editarTipoEventoForm.invalid){
      console.log('Formulario inválido');
      return;
    }

    let aux: Tipo_Evento = this.editarTipoEventoForm.value;
    console.log('Nombre del evento: ' + aux.nombre);
    console.log('Descripcion del evento: ' + aux.descripcion);
    //$("#editarTipoEventoModal").modal("hide");

    this.tipoEventoService.updateTipo_Evento(this.editarTipoEventoForm.value).subscribe(
      res => {
        //$("#editarTipoEventoModal").modal("hide");
        this.getTipos_Evento();
      },
      err => console.error(err)
    )
  }

  get f(){ return this.tipoEventoForm.controls;}
  get fe(){ return this.editarTipoEventoForm.controls;}

  openModalTipoEvento(){
    this.submitted = false;
    this.tipoEventoForm.reset();
    $("#tipoEventoModal").modal("show");
  }

  /*
  openModalEditarTipoEvento(tipoEvento){
    this.editarTipoEventoForm.reset();
    this.editarTipoEventoForm.setValue({
      id: [tipoEvento.id],
      nombre: [tipoEvento.nombre],
      descripcion: [tipoEvento.descripcion],
    });
    $("#editarTipoUsuarioModal").modal("show");
  }*/

}
