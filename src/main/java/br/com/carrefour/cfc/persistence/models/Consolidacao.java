package br.com.carrefour.cfc.persistence.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CONSOLIDACAO")
@Data @EqualsAndHashCode(callSuper = true) @Builder @NoArgsConstructor @AllArgsConstructor
@SequenceGenerator(name = "SQ_CONSOLIDACAO", sequenceName = "SQ_CONSOLIDACAO", allocationSize = 1, initialValue = 1)
public class Consolidacao extends EntidadeBase<Long>{
	
	private static final long serialVersionUID = -9028601673114325756L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CONSOLIDACAO")
	private Long id;
	
	private BigDecimal saldo;
	
	private LocalDate data;
	
	private String operador;

}
