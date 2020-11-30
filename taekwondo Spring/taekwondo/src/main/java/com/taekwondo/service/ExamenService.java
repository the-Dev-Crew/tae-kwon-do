package com.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.Examen;

public interface ExamenService {
	public abstract List<Examen> getExamenes();
	public abstract ResponseEntity<Object> getExamen(int id);
	public abstract ResponseEntity<Object> createExamen(Examen e);
	public abstract void updateExamen(int id, Examen e);
	public abstract void deleteExamen(int id);
}
