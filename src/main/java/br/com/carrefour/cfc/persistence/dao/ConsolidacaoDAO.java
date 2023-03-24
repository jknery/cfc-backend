package br.com.carrefour.cfc.persistence.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carrefour.cfc.persistence.models.Consolidacao;

public interface ConsolidacaoDAO extends JpaRepository<Consolidacao, Long>{
	Consolidacao findByData(LocalDate data);
}
