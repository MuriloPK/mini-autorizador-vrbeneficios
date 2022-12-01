package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api;

import java.util.UUID;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.StatusCompra;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TransacaoResponse {

	private StatusCompra statusCompra;
	private Double valor;
	private String numeroCartao;
	private Double limiteCartao;
	private UUID idTransacao;

}
