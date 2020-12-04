package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Presentar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_presentar;
	private Integer id_alumno;
	private Integer id_examen;
	
	public Presentar() {}

	public Presentar(Integer id_presentar, Integer id_alumno, Integer id_examen) {
		super();
		this.id_presentar = id_presentar;
		this.id_alumno = id_alumno;
		this.id_examen = id_examen;
	}

	public Integer getId_presentar() {
		return id_presentar;
	}

	public void setId_presentar(Integer id_presentar) {
		this.id_presentar = id_presentar;
	}

	public Integer getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}

	public Integer getId_examen() {
		return id_examen;
	}

	public void setId_examen(Integer id_examen) {
		this.id_examen = id_examen;
	}
	
	
}
