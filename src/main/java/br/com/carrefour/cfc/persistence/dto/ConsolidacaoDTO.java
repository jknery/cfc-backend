package br.com.carrefour.cfc.persistence.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode(callSuper = false) @Builder @NoArgsConstructor @AllArgsConstructor
public class ConsolidacaoDTO extends BaseDTO {

	private static final long serialVersionUID = 8847995497690537263L;

	private Long id;
	
	private BigDecimal saldo;
	
	private LocalDate data;
	
	private String operador;
	
}
