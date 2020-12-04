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
import com.taekwondo.model.Participa;
import com.taekwondo.service.ParticipaService;

@RestController
public class ParticipaCtrl {
	
	@Autowired
	private ParticipaService pSrvc;
	
	
	//todas las participaciones
	@GetMapping("/participa")
	public List<Participa> getParticipa(){
		return pSrvc.getParticipaciones();
	}
	
	//da todos los eventos con sus detalles en los que ha participado el alumno con el id dado
	@GetMapping("/participa/alumno/{id}")
	public List<Evento> getParticipa(@PathVariable int id){
		return pSrvc.getEventosdeAlumno(id);
	}
	
	//da todos los alumnos con sus detalles que asistieron al evento con id dado
	@GetMapping("/participa/evento/{id}")
	public List<Alumno> getAsistencia(@PathVariable int id){
		return pSrvc.getAlumnosParticipantes(id);
	}
	
	//da los detalles (id_participa, id_evento, id_alumno) de la participacion con los id's dados
	@GetMapping("/participa/{id_evento}/{id_alumno}")
	public ResponseEntity<Object> getParticipacion(@PathVariable int id_evento, @PathVariable int id_alumno){
		return new ResponseEntity<Object>(pSrvc.getParticipacion(id_alumno, id_evento),HttpStatus.OK) ;
	}
	
	@PostMapping("/participa")
	public ResponseEntity<Object> createParticipacion(@Valid @RequestBody Participa p){
		pSrvc.createParticipacion(p);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Participacion creada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	//borra la participacion con id dado
	@DeleteMapping("/participa/{id}")
	public ResponseEntity<Object> deleteParticipacion(@PathVariable int id){
		pSrvc.deleteParticipacion(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Participacion eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	//borra la participacion que tiene el id_evento y id_alumno dados.
	@DeleteMapping("/participa/{id_evento}/{id_alumno}")
	public ResponseEntity<Object> deleteParticipacion(@PathVariable int id_alumno, @PathVariable int id_evento){
		Participa a = pSrvc.getParticipacion(id_alumno, id_evento);
		pSrvc.deleteParticipacion(a.getId_participa());
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Participacion eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
}
