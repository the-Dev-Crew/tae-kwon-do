package com.taekwondo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Alumno;
import com.taekwondo.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepo;
	@Autowired 
	private UsuarioService uService;
	
	@Override
	public List<Alumno> getAlumnos() {
		List<Integer> ids = alumnoRepo.getAlumnos();
		List<Alumno> alumnos = new ArrayList<Alumno>();
		for(int id: ids) {
			alumnos.add(alumnoRepo.findById(id).get());
		}
		return alumnos;
	}

	@Override
	public ResponseEntity<Object> getAlumno(int id) {
		return new ResponseEntity<>(alumnoRepo.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createAlumno(Alumno alumno) {
		return new ResponseEntity<>(alumnoRepo.save(alumno), HttpStatus.OK);
	}

	@Override
	public void updateAlumno(int id, Alumno alumno) {
		alumnoRepo.save(alumno);
		
	}

	@Override
	public void deleteAlumno(int id) {
		Alumno a = alumnoRepo.findById(id).get();
		uService.deleteUsuario(a.getUsername());
		
	}

}
