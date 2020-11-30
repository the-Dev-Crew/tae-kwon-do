package com.taekwondo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Examen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_examen;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private double costo;
	
	@NotNull
	private String tipo;
	
	@NotNull
	private Date fecha;
	
	@NotNull
	private String actividad;
	
	@NotNull
	private String grado;
	
	public Examen() {}
	
	public Examen(Integer id_examen, @NotNull String nombre, @NotNull double costo, @NotNull String tipo,
			@NotNull Date fecha, @NotNull String actividad, @NotNull String grado) {
		super();
		this.id_examen = id_examen;
		this.nombre = nombre;
		this.costo = costo;
		this.tipo = tipo;
		this.fecha = fecha;
		this.actividad = actividad;
		this.grado = grado;
	}

	public Integer getId_examen() {
		return id_examen;
	}

	public void setId_examen(Integer id_examen) {
		this.id_examen = id_examen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}
	
	
	
}
