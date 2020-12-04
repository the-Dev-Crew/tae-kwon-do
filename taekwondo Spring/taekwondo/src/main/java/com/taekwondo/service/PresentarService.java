package com.taekwondo.service;

import java.util.List;

import com.taekwondo.model.Alumno;
import com.taekwondo.model.Examen;
import com.taekwondo.model.Presentar;

public interface PresentarService {
	public abstract List<Presentar> getPresentar();
	public abstract List<Examen> getExamenesPresentados(int id_alumno);
	public abstract List<Alumno> getAlumnosPresentados(int id_examen);
	public abstract void deletePresentar(int id);
	public abstract Presentar getPresentar(int id_alumno, int id_examen);
	public abstract void createPresentar(Presentar p);
	public abstract Presentar getPresentar(int id);

}
