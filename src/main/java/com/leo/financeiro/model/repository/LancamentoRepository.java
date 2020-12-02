package com.leo.financeiro.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.financeiro.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
