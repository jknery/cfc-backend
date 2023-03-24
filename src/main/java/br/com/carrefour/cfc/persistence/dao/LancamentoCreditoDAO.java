package br.com.carrefour.cfc.persistence.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.carrefour.cfc.persistence.models.LancamentoCredito;

@Repository
public interface LancamentoCreditoDAO extends JpaRepository<LancamentoCredito, Long>{
	
	@Query(nativeQuery = true, value = "SELECT SUM(C.VALOR) FROM CREDITOS C WHERE C.DATA = :data")
	BigDecimal calculoCreditoDiario(@Param("data") String data);
	
}
