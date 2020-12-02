package com.leo.financeiro.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.financeiro.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	boolean existsByEmail(String email);
}
