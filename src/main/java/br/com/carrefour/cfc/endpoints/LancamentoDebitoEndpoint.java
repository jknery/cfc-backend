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

import br.com.carrefour.cfc.business.services.debit.LancamentoDebitoService;
import br.com.carrefour.cfc.persistence.dto.LancamentoDebitoDTO;

@RestController
@RequestMapping("/debitos")
public class LancamentoDebitoEndpoint {
	
	@Autowired
	private LancamentoDebitoService lancamentoDebitoService;
		
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LancamentoDebitoDTO>> listarTodosDebitos(){
		var debitos = this.lancamentoDebitoService.listarTodosDebitos();
		return new ResponseEntity<List<LancamentoDebitoDTO>>(debitos, HttpStatus.OK);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path="/{id}")
	public ResponseEntity<LancamentoDebitoDTO> listarDebitoById(@PathVariable("id") Long id){
		var debitos = this.lancamentoDebitoService.listarDebitoById(id);
		return new ResponseEntity<LancamentoDebitoDTO>(debitos, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> cadastrarDebito(@RequestBody LancamentoDebitoDTO dto) {
		this.lancamentoDebitoService.cadastrarDebito(dto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
