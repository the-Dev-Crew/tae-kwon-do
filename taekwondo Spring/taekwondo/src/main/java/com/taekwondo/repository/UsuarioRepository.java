package com.taekwondo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taekwondo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="SELECT * FROM usuario WHERE username = :username", nativeQuery=true)
	Usuario getUsuario(String username);
	
	@Query(value="SELECT * FROM usuario WHERE tipo_usuario != 'BAJA'", nativeQuery=true)
	List<Usuario> getUsuarios();
}

