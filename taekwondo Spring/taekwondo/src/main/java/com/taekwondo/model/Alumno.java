package com.taekwondo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Alumno;
	
	@NotNull
	@Size(min=2, message="El nombre de la persona debe tener al menos 2 letras")
	private String nombre;
	
	@NotNull
	@Size(min=2, message="El apellido Paterno de la persona deben tener al menos 2 letras")
	private String a_paterno;
	
	@Size(min=2, message="El apellido Materno de la persona deben tener al menos 2 letras")
	private String a_materno;
	
	private String fotografia;
	
	@Past
	private Date fecha_nacimiento;
	
	private String seguro_medico;
	
	private String certificado_medico;
	
	private String carta_responsiva;
	
	@Size(min= 3, message="Debe estar en alguna actividad")
	private String actividad;
	
	private String grado;
	
	@NotNull
	@Column(unique=true)
	private String username;
	
	public Alumno() {}
	
	public Alumno(Integer id_Alumno,
			@Size(min = 2, message = "El nombre de la persona debe tener al menos 2 letras") String nombre,
			@Size(min = 2, message = "El apellido Paterno de la persona deben tener al menos 2 letras") String a_paterno,
			@Size(min = 2, message = "El apellido Materno de la persona deben tener al menos 2 letras") String a_materno,
			String fotografia, @Past Date fecha_nacimiento, String seguro_medico, String certificado_medico,
			String carta_responsiva, @Size(min = 3, message = "Debe estar en alguna actividad") String actividad,
			String grado, String username) {
		super();
		this.id_Alumno = id_Alumno;
		this.nombre = nombre;
		this.a_paterno = a_paterno;
		this.a_materno = a_materno;
		this.fotografia = fotografia;
		this.fecha_nacimiento = fecha_nacimiento;
		this.seguro_medico = seguro_medico;
		this.certificado_medico = certificado_medico;
		this.carta_responsiva = carta_responsiva;
		this.actividad = actividad;
		this.grado = grado;
		this.username = username;
	}

	public Integer getId_Alumno() {
		return id_Alumno;
	}

	public void setId_Alumno(Integer id_Alumno) {
		this.id_Alumno = id_Alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getA_paterno() {
		return a_paterno;
	}

	public void setA_paterno(String a_paterno) {
		this.a_paterno = a_paterno;
	}

	public String getA_materno() {
		return a_materno;
	}

	public void setA_materno(String a_materno) {
		this.a_materno = a_materno;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getSeguro_medico() {
		return seguro_medico;
	}

	public void setSeguro_medico(String seguro_medico) {
		this.seguro_medico = seguro_medico;
	}

	public String getCertificado_medico() {
		return certificado_medico;
	}

	public void setCertificado_medico(String certificado_medico) {
		this.certificado_medico = certificado_medico;
	}

	public String getCarta_responsiva() {
		return carta_responsiva;
	}

	public void setCarta_responsiva(String carta_responsiva) {
		this.carta_responsiva = carta_responsiva;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Alumno [id_Alumno=" + id_Alumno + ", nombre=" + nombre + ", a_paterno=" + a_paterno + ", a_materno="
				+ a_materno + ", fotografia=" + fotografia + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", seguro_medico=" + seguro_medico + ", certificado_medico=" + certificado_medico
				+ ", carta_responsiva=" + carta_responsiva + ", actividad=" + actividad + ", grado=" + grado
				+ ", username=" + username + "]";
	}
	
	
	
}
