package com.taekwondo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
