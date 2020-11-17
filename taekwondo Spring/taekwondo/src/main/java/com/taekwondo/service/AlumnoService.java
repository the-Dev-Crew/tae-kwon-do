package com.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.Alumno;

public interface AlumnoService {
	public abstract List<Alumno> getAlumnos();
	public abstract ResponseEntity<Object> getAlumno(int id);
	public abstract ResponseEntity<Object> createAlumno(Alumno alumno);
	public abstract void updateAlumno(int id, Alumno alumno);
	public abstract void deleteAlumno(int id);
}
