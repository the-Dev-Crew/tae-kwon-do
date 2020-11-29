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

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Usuario;
import com.taekwondo.repository.AlumnoRepository;
import com.taekwondo.service.AlumnoService;
import com.taekwondo.service.UsuarioService;
import com.taekwondo.service.UsuarioServiceImp;

@RestController
public class AlumnoCtrl {
	
	@Autowired
	private AlumnoService alumnoService;
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	
	@GetMapping("/alumno")
	public List<Alumno> getAlumnos(){
		return alumnoService.getAlumnos();
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<Object> getAlumno(@PathVariable int id){
		return alumnoService.getAlumno(id);
	}
	
	@PostMapping("/alumno")
	public ResponseEntity<Object> createPersona(@Valid @RequestBody Alumno alumno){

		ResponseEntity<Object> savedAlumno = alumnoService.createAlumno(alumno);
		
		return null;
	}
	
	@PutMapping("/alumno/{id}")
	public void updateAlumno(@Valid @RequestBody Alumno alumno, @PathVariable int id) {
		alumnoService.updateAlumno(id, alumno);
	}
	
	@DeleteMapping("/alumno/{id}")
	public void deleteAlumno(@PathVariable int id) {
		alumnoService.deleteAlumno(id);
	}

}
