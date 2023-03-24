package br.com.carrefour.cfc.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrefour.cfc.business.services.credit.LancamentoCreditoService;
import br.com.carrefour.cfc.persistence.dto.LancamentoCreditoDTO;

@RestController
@RequestMapping("/creditos")
public class LancamentoCreditoEndpoint {
	
	@Autowired
	private LancamentoCreditoService lancamentoCreditoService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LancamentoCreditoDTO>> listarTodosCreditos(){
		var creditos = this.lancamentoCreditoService.listarTodosCreditos();
		return new ResponseEntity<List<LancamentoCreditoDTO>>(creditos, HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/{id}")
	public ResponseEntity<LancamentoCreditoDTO> listarCreditoById(@PathVariable("id") Long id){
		var creditos = this.lancamentoCreditoService.listarCreditoById(id);
		return new ResponseEntity<LancamentoCreditoDTO>(creditos, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> cadastrarCredito(@RequestBody LancamentoCreditoDTO dto) {
		this.lancamentoCreditoService.cadastrarCredito(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
