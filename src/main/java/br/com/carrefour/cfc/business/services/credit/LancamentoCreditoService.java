package br.com.carrefour.cfc.business.services.credit;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.carrefour.cfc.persistence.dao.LancamentoCreditoDAO;
import br.com.carrefour.cfc.persistence.dto.LancamentoCreditoDTO;
import br.com.carrefour.cfc.persistence.mappers.Converter;
import br.com.carrefour.cfc.persistence.models.LancamentoCredito;

@Service @Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LancamentoCreditoService {

	@Autowired
	private LancamentoCreditoDAO lancamentoCreditoDAO;

	
	public BigDecimal calculoSaldoDia(String data) {
		return this.lancamentoCreditoDAO.calculoCreditoDiario(data);
	}

	public List<LancamentoCreditoDTO> listarTodosCreditos(){
		var creditos = this.lancamentoCreditoDAO.findAll();
		return Converter.converterList(creditos, LancamentoCreditoDTO.class);
	}
	
	public LancamentoCreditoDTO listarCreditoById(Long id){
		var creditos = this.lancamentoCreditoDAO.findById(id);
		if(creditos.isPresent()) {
			return Converter.converter(creditos.get(), LancamentoCreditoDTO.class);
		}
		return new LancamentoCreditoDTO();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class, RuntimeException.class})
	public void cadastrarCredito(LancamentoCreditoDTO dto) {
		var credito = Converter.converter(dto, LancamentoCredito.class);
		this.lancamentoCreditoDAO.save(credito);
	}
	
}
