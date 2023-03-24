package br.com.carrefour.cfc.business.services.report;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.carrefour.cfc.business.services.credit.LancamentoCreditoService;
import br.com.carrefour.cfc.business.services.debit.LancamentoDebitoService;
import br.com.carrefour.cfc.persistence.dao.ConsolidacaoDAO;
import br.com.carrefour.cfc.persistence.dto.ConsolidacaoDTO;
import br.com.carrefour.cfc.persistence.mappers.Converter;
import br.com.carrefour.cfc.persistence.models.Consolidacao;

@Service @Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ConsolidacaoService {
	
	@Autowired
	private ConsolidacaoDAO consolidacaoDAO;
	
	@Autowired
	private LancamentoCreditoService lancamentoCreditoService;
	
	@Autowired
	private LancamentoDebitoService lancamentoDebitoService;
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
	public void criarReport(String data, String operador) {
		
		var credito = this.lancamentoCreditoService.calculoSaldoDia(data);
		
		var debito = this.lancamentoDebitoService.calculoSaldoDia(data);
		
		var saldo = credito.doubleValue() - debito.doubleValue();
		
		var report = Consolidacao.builder().operador(operador).saldo(new BigDecimal(saldo)).data(LocalDate.parse(data)).build();
		
		this.consolidacaoDAO.save(report);
	}
	
	public ConsolidacaoDTO recuprarReport(String data) {
		var report = this.consolidacaoDAO.findByData(LocalDate.parse(data));
		return Converter.converter(report, ConsolidacaoDTO.class);
	}

}
