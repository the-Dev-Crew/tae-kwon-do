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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.model.Evento;
import com.taekwondo.model.Relacionar;
import com.taekwondo.model.Tener;
import com.taekwondo.model.Tipo_Evento;
import com.taekwondo.service.TenerService;

@RestController
public class TenerCtrl {
	
	@Autowired
	private TenerService tenSrvc;
	
	@GetMapping("/tener")
	public List<Tener> getRelacionar(){
		return tenSrvc.getTener();
	}
	
	@GetMapping("/tener/tipo_evento/{id}")
	public List<Evento> getEventosConTipo(@PathVariable int id){
		return tenSrvc.getEventosConTipo(id);
	}
	
	@GetMapping("/tener/evento/{id}")
	public List<Tipo_Evento> getTiposDelEvento(@PathVariable int id){
		return tenSrvc.getTiposDelEvento(id);
	}
	
	@PostMapping("/tener")
	public ResponseEntity<Object> createTener(@Valid @RequestBody Tener t){
		tenSrvc.createTener(t);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Tipo de evento asociado con evento creada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/tener/{id}")
	public ResponseEntity<Object> deleteTener(@PathVariable int id){
		tenSrvc.deleteTener(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Tipo asociado con evento eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/tener/{id_evento}/{id_tipo}")
	public ResponseEntity<Object> deleteTener(@PathVariable int id_evento, @PathVariable int id_tipo){
		Tener t = tenSrvc.getTener(id_tipo, id_evento);
		tenSrvc.deleteTener(t.getId_tener());
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Tipo asociado con evento eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
