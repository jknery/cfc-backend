package br.com.carrefour.cfc.persistence.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data @EqualsAndHashCode(callSuper = true) @MappedSuperclass
public abstract class Lancamento extends EntidadeBase<Long>{

	private static final long serialVersionUID = -2621321287404132084L;

	protected LocalDate data;
	
	protected String operador;
	
	protected BigDecimal valor;
	
}
