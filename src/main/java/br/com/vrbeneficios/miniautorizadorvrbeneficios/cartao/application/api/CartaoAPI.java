package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/cartoes")
public interface CartaoAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	CartaoResponse criaCartao(@PathVariable UUID idCliente, @RequestBody @Valid CartaoRequest cartaoRequest);

	@GetMapping(value = "numeroCartao")
	@ResponseStatus(code = HttpStatus.OK)
	CartaoDetalhadoResponse getCartaoPorNumero(@RequestParam String numeroCartao);

	@PostMapping("realizaTransacao")
	@ResponseStatus(code = HttpStatus.OK)
	TransacaoResponse postTransacao(@RequestBody @Valid TransacaoRequest transacaoRequest,
			@RequestParam String numeroCartao);

}
