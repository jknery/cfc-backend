package br.com.carrefour.cfc.business.services.debit;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.carrefour.cfc.persistence.dao.LancamentoDebitoDAO;
import br.com.carrefour.cfc.persistence.dto.LancamentoDebitoDTO;
import br.com.carrefour.cfc.persistence.mappers.Converter;
import br.com.carrefour.cfc.persistence.models.LancamentoDebito;

@Service @Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LancamentoDebitoService {

	@Autowired
	private LancamentoDebitoDAO lancamentoDebitoDAO;
	
	public BigDecimal calculoSaldoDia(String data) {
		return this.lancamentoDebitoDAO.calculoDebitoDiario(data);
	}
	
	public List<LancamentoDebitoDTO> listarTodosDebitos(){
		var debitos = this.lancamentoDebitoDAO.findAll();
		return Converter.converterList(debitos, LancamentoDebitoDTO.class);
	}
	
	public LancamentoDebitoDTO listarDebitoById(Long id){
		var debitos = this.lancamentoDebitoDAO.findById(id);
		if(debitos.isPresent()) {
			return Converter.converter(debitos.get(), LancamentoDebitoDTO.class);
		}
		return new LancamentoDebitoDTO();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
	public void cadastrarDebito(LancamentoDebitoDTO dto) {
		var debito = Converter.converter(dto, LancamentoDebito.class);
		this.lancamentoDebitoDAO.save(debito);
	}
	
}
