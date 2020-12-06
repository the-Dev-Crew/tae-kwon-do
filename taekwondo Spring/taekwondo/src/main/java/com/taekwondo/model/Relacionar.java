package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Relacionar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_relacionar;
	
	private Integer id_evento;
	
	private String actividad;

	public Relacionar() {}

	public Relacionar(Integer id_relacionar, Integer id_evento, String actividad) {
		super();
		this.id_relacionar = id_relacionar;
		this.id_evento = id_evento;
		this.actividad = actividad;
	}

	public Integer getId_relacionar() {
		return id_relacionar;
	}

	public void setId_relacionar(Integer id_relacionar) {
		this.id_relacionar = id_relacionar;
	}

	public Integer getId_evento() {
		return id_evento;
	}

	public void setId_evento(Integer id_evento) {
		this.id_evento = id_evento;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	
	
	
	

}
