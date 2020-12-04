package com.leo.financeiro.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class UsuarioDTO {

	private String email;
	private String nome;
	private String senha;
}
