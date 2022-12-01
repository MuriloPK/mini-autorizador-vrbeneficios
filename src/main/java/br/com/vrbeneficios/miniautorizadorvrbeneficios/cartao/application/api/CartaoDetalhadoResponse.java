package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Cartao;
import lombok.Value;

@Value
public class CartaoDetalhadoResponse {

	private UUID idCartao;
	private String numeroCartao;
	private String senha;
	private Double limiteCartao;
	private LocalDate validadeCartao;
	private LocalDate dataHoraCriacaoCartao;

	public CartaoDetalhadoResponse(Cartao cartao) {
		this.idCartao = cartao.getIdCartao();
		this.numeroCartao = cartao.getNumeroCartao();
		this.senha = cartao.getSenha();
		this.limiteCartao = cartao.getLimiteCartao();
		this.validadeCartao = cartao.getValidadeCartao();
		this.dataHoraCriacaoCartao = cartao.getDataHoraCriacaoCartao();
	}
}
