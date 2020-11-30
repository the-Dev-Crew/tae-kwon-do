package com.taekwondo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_evento;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private Date fecha_inicio;
	
	@NotNull
	private Date fecha_fin;
	
	@NotNull
	private double costo;
	
	@NotNull
	private String descripcion;
	
	public Evento() {}
	
	public Evento(Integer id_evento, @NotNull String nombre, @NotNull Date fecha_inicio, @NotNull Date fecha_fin,
			@NotNull double costo, @NotNull String descripcion) {
		super();
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.costo = costo;
		this.descripcion = descripcion;
	}

	public Integer getId_evento() {
		return id_evento;
	}

	public void setId_evento(Integer id_evento) {
		this.id_evento = id_evento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
