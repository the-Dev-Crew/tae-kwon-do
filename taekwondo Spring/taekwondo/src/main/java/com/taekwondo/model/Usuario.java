package com.taekwondo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario {
	
	@Id
	@Size(min=2, message="El usuario debe tener al menos 2 caracteres")
	private String username;
	
	@Size(min=2, message="El password debe tener al menos 8 caracteres")
	private String password;
	
	private String tipo_usuario;
	
	public Usuario() {
		
	}

	public Usuario( @Size(min = 2, message = "El usuario debe tener al menos 2 caracteres") String username,
			@Size(min = 2, message = "El password debe tener al menos 8 caracteres") String password,
			String tipo_usuario) {
		super();

		this.username = username;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
	}

	public String getUsuario() {
		return username;
	}

	public void setUsuario(String usuario) {
		this.username = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	@Override
	public String toString() {
		return "Usuario [ username=" + username + ", password=" + password + ", tipo_usuario=" + tipo_usuario
				+ "]";
	}

}