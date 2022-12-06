package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api;

import javax.validation.constraints.Size;

import lombok.Value;

@Value
public class TransacaoRequest {

	private Double valorCompra;
	@Size(min = 4, max = 4, message = "senha deve ter 4 digitos")
	private String senha;

}
