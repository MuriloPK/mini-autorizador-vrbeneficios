package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Value;

@Value
public class CartaoRequest {

	@NotNull
	@Size(min = 4, max = 4, message = "senha deve ter 4 digitos")
	private String senha;
	private LocalDate dataHoraCriacaoCartao;
}
