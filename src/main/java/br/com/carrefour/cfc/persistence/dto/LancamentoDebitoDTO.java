package br.com.carrefour.cfc.persistence.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @EqualsAndHashCode(callSuper = false) @Builder @NoArgsConstructor @AllArgsConstructor
public class LancamentoDebitoDTO extends BaseDTO {

	private static final long serialVersionUID = 5301141770850830958L;
	
	private Long id;
	
	private LocalDate data;
	
	private String operador;
	
	private BigDecimal valor;

}
