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
import com.taekwondo.model.Examen;
import com.taekwondo.service.ExamenService;

@RestController
public class ExamenCtrl {
	
	@Autowired
	private ExamenService examenSrvc;
	
	@GetMapping("/examen")
	public List<Examen> getExamenes(){
		return examenSrvc.getExamenes();
	}
	
	@GetMapping("/examen/{id}")
	public ResponseEntity<Object> getExamen(@PathVariable int id){
		return examenSrvc.getExamen(id);
	}
	
	@PostMapping("/examen")
	public ResponseEntity<Object> createExamen(@Valid @RequestBody Examen e){
		ResponseEntity<Object> savedTipo = examenSrvc.createExamen(e);
		return null;
	}
	
	@PutMapping("/examen/{id}")
	public ResponseEntity<Object> updateExamen(@Valid @RequestBody Examen e, @PathVariable int id) {
		HashMap<String,String> response = new HashMap<>();
		
		if(id != e.getId_examen()) {
			response.put("status","failure");
			response.put("message","El id no coincide");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		examenSrvc.updateExamen(id, e);
		response.put("status","success");
		response.put("message","Examen actualizado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/examen/{id}")
	public void deleteExamen(@PathVariable int id) {
		examenSrvc.deleteExamen(id);
	}
}
