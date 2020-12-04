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

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Evento;
import com.taekwondo.model.Examen;
import com.taekwondo.model.Participa;
import com.taekwondo.model.Presentar;
import com.taekwondo.service.PresentarService;

@RestController
public class PresentarCtrl {
	
	@Autowired
	private PresentarService presentarSrvc;
	
	//todas las participaciones
	@GetMapping("/presentar")
	public List<Presentar> getPresentar(){
		return presentarSrvc.getPresentar();
	}
	
	@GetMapping("/presentar/{id}")
	public Presentar getPresentar(@PathVariable int id){
		return presentarSrvc.getPresentar(id);
	}
	
	//da todos los examenes con sus detalles que ha presentado el alumno con el id dado
	@GetMapping("/presentar/alumno/{id}")
	public List<Examen> getExamenesPresentados(@PathVariable int id){
		return presentarSrvc.getExamenesPresentados(id);
	}
	
	//da todos los alumnos con sus detalles que presentaron el examen con id dado
	@GetMapping("/presentar/examen/{id}")
	public List<Alumno> getAlumnosPresentados(@PathVariable int id){
		return presentarSrvc.getAlumnosPresentados(id);
	}
	
	
	@PostMapping("/presentar")
	public ResponseEntity<Object> createPresentar(@Valid @RequestBody Presentar p){
		presentarSrvc.createPresentar(p);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Presentacion de examen  creada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//borra el registro presentado con id dado
	@DeleteMapping("/presentar/{id}")
	public ResponseEntity<Object> deletePresentar(@PathVariable int id){
		presentarSrvc.deletePresentar(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Participacion eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//borra la presentacion que tiene el id_examen y id_alumno dados.
	@DeleteMapping("/presentar/{id_examen}/{id_alumno}")
	public ResponseEntity<Object> deletePresentar(@PathVariable int id_alumno, @PathVariable int id_examen){
		Presentar p = presentarSrvc.getPresentar(id_alumno, id_examen);
		presentarSrvc.deletePresentar(p.getId_presentar());
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Participacion eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
