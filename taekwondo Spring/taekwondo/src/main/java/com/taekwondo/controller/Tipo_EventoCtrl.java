package com.taekwondo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.Tipo_Evento;
import com.taekwondo.service.Tipo_EventoService;

@RestController
public class Tipo_EventoCtrl {
	
	@Autowired
	private Tipo_EventoService tipoEService;
	
	@GetMapping("/tipo_evento")
	public List<Tipo_Evento> getTipos_Evento(){
		return tipoEService.getTipos_Evento();
	}
	
	@GetMapping("/tipo_evento/{id}")
	public ResponseEntity<Object> getTipo_Evento(@PathVariable int id){
		return tipoEService.getTipo_Evento(id);
	}
	
	@PostMapping("/tipo_evento")
	public ResponseEntity<Object> createTipo_Evento(@Valid @RequestBody Tipo_Evento te){
		ResponseEntity<Object> savedTipo = tipoEService.createTipo_Evento(te);
		
		return null;
	}
	
	@PutMapping("/tipo_evento/{id}")
	public void updateTipo_Evento( @RequestBody Tipo_Evento te, @PathVariable int id) {
		tipoEService.updateTipo_Evento(id, te);
	}
	
	@DeleteMapping("/tipo_evento/{id}")
	public void deleteTipo_Evento(@PathVariable int id) {
		tipoEService.deleteTipo_Evento(id);
	}
}
