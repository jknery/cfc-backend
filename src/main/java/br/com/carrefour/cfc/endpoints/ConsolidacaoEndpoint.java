package br.com.carrefour.cfc.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrefour.cfc.business.services.report.ConsolidacaoService;
import br.com.carrefour.cfc.persistence.dto.ConsolidacaoDTO;

@RestController
@RequestMapping("/consolidacao")
public class ConsolidacaoEndpoint {

	
	@Autowired
	private ConsolidacaoService consolidacaoService;
	
	@PatchMapping(path = "/{op}/{date}")
	public ResponseEntity<String> gerarReport(@PathVariable("op") String operador, @PathVariable("date") String data) {
		this.consolidacaoService.criarReport(data, operador);
		return new ResponseEntity<String>("CONSOLIDAÇÃO GERADA", HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{date}")
	public ResponseEntity<ConsolidacaoDTO> recuperarReport(@PathVariable("date") String data) {
		return new ResponseEntity<ConsolidacaoDTO>(this.consolidacaoService.recuprarReport(data), HttpStatus.CREATED);
	}
	
	
}
