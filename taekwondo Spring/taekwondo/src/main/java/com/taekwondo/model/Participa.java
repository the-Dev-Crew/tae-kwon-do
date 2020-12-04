package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_participa;
	private Integer id_alumno;
	private Integer id_evento;
	
	public Participa() {}
	
	public Participa(Integer id_alumno, Integer id_evento) {
		super();
		this.id_alumno = id_alumno;
		this.id_evento = id_evento;
	}
	public Integer getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}
	public Integer getId_evento() {
		return id_evento;
	}
	public void setId_evento(Integer id_evento) {
		this.id_evento = id_evento;
	}

	public Integer getId_participa() {
		return id_participa;
	}

	public void setId_participa(Integer id_participa) {
		this.id_participa = id_participa;
	}
	
	
	
}
