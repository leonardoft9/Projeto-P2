package com.leo.financeiro.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.financeiro.api.dto.LancamentoDTO;
import com.leo.financeiro.exception.RegraNegocioException;
import com.leo.financeiro.model.entity.Lancamento;
import com.leo.financeiro.model.entity.Usuario;
import com.leo.financeiro.model.enums.StatusLancamento;
import com.leo.financeiro.model.enums.TipoLancamento;
import com.leo.financeiro.service.LancamentoService;
import com.leo.financeiro.service.UsuarioService;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoResource {

	private LancamentoService service;
	private UsuarioService usuarioService;
	
	public LancamentoResource(LancamentoService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity salvar( @RequestBody LancamentoDTO dto) {
		
	}
	
	private Lancamento converter(LancamentoDTO dto) {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(dto.getId());
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setAno(dto.getAno());
		lancamento.setMes(dto.getMes());
		lancamento.setValor(dto.getValor());
		
		Usuario usuario = usuarioService
		.obterPorId(dto.getUsuario())
		.orElseThrow( () -> new RegraNegocioException("Usuario não encontrado para o id informado") );
		
		lancamento.setUsuario(usuario);
		lancamento.setTipo(TipoLancamento.valueOf(dto.getTipo()));
		lancamento.setStatus(StatusLancamento.valueOf(dto.getStatus()));
		
		return lancamento;
	}
}
