package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Examen;
import com.taekwondo.model.Presentar;

public interface PresentarService {
	public abstract List<Presentar> getPresentar();
	public abstract List<Examen> getExamenesPresentados(int id_alumno);
	public abstract List<Alumno> getAlumnosPresentados(int id_examen);
}
