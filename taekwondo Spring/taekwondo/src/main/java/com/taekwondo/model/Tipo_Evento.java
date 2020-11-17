package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Tipo_Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_tipo;
	@Size(min=2, message="El tipo de evento debe tener al menos 2 letras")
	private String nombre;
	@Size(min=2, message="La descripción debe tener al menos 2 letras")
	private String descripcion;
	
	
	public Tipo_Evento(Integer id_tipo,
			@Size(min = 2, message = "El tipo de evento debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "La descripción debe tener al menos 2 letras") String descripcion) {
		super();
		this.id_tipo = id_tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public Tipo_Evento() {
		super();
	}


	public Integer getId_tipo() {
		return id_tipo;
	}


	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Tipo_Evento [id_tipo=" + id_tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	
}
