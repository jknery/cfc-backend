package br.com.carrefour.cfc.persistence.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.carrefour.cfc.persistence.models.LancamentoDebito;

@Repository
public interface LancamentoDebitoDAO extends JpaRepository<LancamentoDebito, Long>{
	@Query(nativeQuery = true, value = "SELECT SUM(D.VALOR) FROM DEBITOS D WHERE D.DATA = :data")
	BigDecimal calculoDebitoDiario(@Param("data") String data);
}
