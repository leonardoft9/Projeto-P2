package com.leo.financeiro.model.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.leo.financeiro.model.entity.Usuario;
import com.leo.financeiro.model.repository.UsuarioRepository;
import com.leo.financeiro.service.UsuarioService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;
	
	@Test()
	public void deveValidarEmail() {
		
		repository.deleteAll();
		
		service.validarEmail("email@email.com");	
		
	}
	
	@Test
	public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
		
		Usuario usuario =  Usuario.builder().nome("üsuario").email("email@email.com").build();
		
		service.validarEmail("email@email.com");
	}
	

}
