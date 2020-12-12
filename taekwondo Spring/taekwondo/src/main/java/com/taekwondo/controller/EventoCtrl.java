package com.taekwondo.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.Evento;
import com.taekwondo.model.Tipo_Evento;
import com.taekwondo.service.EventoService;

@RestController
public class EventoCtrl {
	
	@Autowired
	private EventoService eventoSrvc;
	
	@GetMapping("/evento")
	public List<Evento> getEventos(){
		return eventoSrvc.getEventos();
	}
	
	@GetMapping("/evento/proximos")
	public List<Evento> getEventosProximos(){
		return eventoSrvc.getEventosProximos();
	}
	
	@GetMapping("/evento/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable int id){
		return eventoSrvc.getEvento(id);
	}
	
	@PostMapping("/evento")
	public ResponseEntity<Object> createEvento(@Valid @RequestBody Evento e){
		ResponseEntity<Object> savedTipo = eventoSrvc.createEvento(e);
		return null;
	}
	
	@PutMapping("/evento/{id}")
	public ResponseEntity<Object> updateEvento(@Valid @RequestBody Evento e, @PathVariable int id) {
		HashMap<String,String> response = new HashMap<>();
		
		if(id != e.getId_evento()) {
			response.put("status","failure");
			response.put("message","El id no coincide");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		eventoSrvc.updateEvento(id, e);
		response.put("status","success");
		response.put("message","Evento actualizado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/evento/{id}")
	public void deleteEvento(@PathVariable int id) {
		eventoSrvc.deleteEvento(id);
	}
}
