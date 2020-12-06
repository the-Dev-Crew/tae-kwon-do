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
import com.taekwondo.model.Presentar;
import com.taekwondo.model.Relacionar;
import com.taekwondo.service.RelacionarService;

@RestController
public class RelacionarCtrl {
	
	@Autowired
	private RelacionarService relSrvc;
	
	//todas las relaciones
	@GetMapping("/relacionar")
	public List<Relacionar> getRelacionar(){
		return relSrvc.getRelacionar();
	}
	
	@GetMapping("/relacionar/actividad/{actividad}")
	public List<Evento> getRelacionadosConActividad(@PathVariable String actividad){
		return relSrvc.getRelacionadosConActividad(actividad);
	}
	
	@GetMapping("/relacionar/evento/{id_evento}")
	public List<String> getActividadesEvento(@PathVariable int id_evento){
		return relSrvc.getActividadesEvento(id_evento);
	}
	
	@PostMapping("/relacionar")
	public ResponseEntity<Object> createRelacionar(@Valid @RequestBody Relacionar r){
		relSrvc.createRelacionar(r);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Actividad asociada a evento  creada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//borra la relacion con id dado
	@DeleteMapping("/relacionar/{id}")
	public ResponseEntity<Object> deleteRelacionar(@PathVariable int id){
		relSrvc.deleteRelacionar(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Relacionn eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//borra la relacion con id dado
	@DeleteMapping("/relacionar/{id_evento}/{actividad}")
	public ResponseEntity<Object> deleteRelacionar(@PathVariable int id_evento, @PathVariable String actividad){
		Relacionar r = relSrvc.getRelacionar(id_evento, actividad);
		relSrvc.deleteRelacionar(r.getId_relacionar());
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Relacionn eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
