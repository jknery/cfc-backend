package br.com.carrefour.cfc.persistence.models;

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
@Table(name = "DEBITOS")
@Data @EqualsAndHashCode(callSuper = true) @Builder @NoArgsConstructor @AllArgsConstructor
@SequenceGenerator(name = "SQ_LMT_DEBITO", sequenceName = "SQ_LMT_DEBITO", allocationSize = 1, initialValue = 1)
public class LancamentoDebito extends Lancamento {

	private static final long serialVersionUID = 2727755657046664624L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LMT_DEBITO")
	private Long id;
	
}
