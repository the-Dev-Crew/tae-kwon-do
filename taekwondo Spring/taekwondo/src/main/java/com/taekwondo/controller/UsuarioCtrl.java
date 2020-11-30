package com.taekwondo.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taekwondo.service.UsuarioService;
//import com.sun.el.stream.Optional;
import com.taekwondo.model.*;
import com.taekwondo.repository.UsuarioRepository;

@RestController
public class UsuarioCtrl {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@GetMapping("/usuario")
	public List<Usuario> getUsuarios(){
		return usuarioService.getUsuarios();
	}
	
	
	@GetMapping("/usuario/{username}")
	public ResponseEntity<Object> getUsuario(@PathVariable String username){
		Usuario user = usuarioService.getUsuario(username);
		
		HashMap<String,String> response = new HashMap<>();
		
		if(user.getTipo_usuario().equals("BAJA")) {
			response.put("status","failure");
			response.put("message","El usuario que se desea consultar ha sido dado de baja");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(user, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<Object> createUsuario(@Valid @RequestBody Usuario usuario){
		ResponseEntity<Object> savedUsuario = usuarioService.createUsuario(usuario);
		
		return savedUsuario;
	}
	
	@PutMapping("/usuario/{username}")
	public ResponseEntity<Object> updateUsuario(@Valid @RequestBody Usuario usuario, @PathVariable String username) {
		HashMap<String,String> response = new HashMap<>();
		
		if(!usuario.getUsuario().equals(username)) {
			response.put("status","failure");
			response.put("message","El nombre de usuario no coincide");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		usuarioService.updateUsuario(username, usuario);
		
		response.put("status","success");
		response.put("message","Usuario actualizado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/usuario/{username}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable String username) {
		usuarioService.deleteUsuario(username);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Tweet eliminado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}