package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tener {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tener;
	
	private Integer id_evento;
	private Integer id_tipo;
	
	public Tener() {}
	
	public Tener(Integer id_tener, Integer id_evento, Integer id_tipo) {
		super();
		this.id_tener = id_tener;
		this.id_evento = id_evento;
		this.id_tipo = id_tipo;
	}

	public Integer getId_tener() {
		return id_tener;
	}

	public void setId_tener(Integer id_tener) {
		this.id_tener = id_tener;
	}

	public Integer getId_evento() {
		return id_evento;
	}

	public void setId_evento(Integer id_evento) {
		this.id_evento = id_evento;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
	
}
