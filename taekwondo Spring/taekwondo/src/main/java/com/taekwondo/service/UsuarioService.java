package com.taekwondo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.taekwondo.model.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> getUsuarios();
	public abstract Usuario getUsuario(String username);
	public abstract ResponseEntity<Object> createUsuario(Usuario usuario);
	public abstract void updateUsuario(String username, Usuario usuario);
	public abstract void deleteUsuario(String username);
}