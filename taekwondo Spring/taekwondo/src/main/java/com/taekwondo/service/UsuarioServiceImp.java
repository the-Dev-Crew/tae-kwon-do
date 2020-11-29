package com.taekwondo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.taekwondo.model.Usuario;
import com.taekwondo.repository.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	private UsuarioRepository repoUsuario;
	
	public List<Usuario> getUsuarios(){
		return repoUsuario.getUsuarios();
	}
	
	public Usuario getUsuario(String username){
		return repoUsuario.getUsuario(username);
	}
	
	public ResponseEntity<Object> createUsuario(Usuario usuario){
		return new ResponseEntity<>(repoUsuario.save(usuario), HttpStatus.OK);
	}
	
	public void updateUsuario(String username, Usuario usuario) {
		repoUsuario.save(usuario);
	}
	
	public void deleteUsuario(String username) {
		Usuario user = repoUsuario.getUsuario(username);
		user.setTipo_usuario("BAJA");
		repoUsuario.save(user);
	}
}