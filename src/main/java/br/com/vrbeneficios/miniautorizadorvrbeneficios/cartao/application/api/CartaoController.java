package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.service.CartaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class CartaoController implements CartaoAPI {

	private final CartaoService cartaoService;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, @Valid CartaoRequest cartaoRequest) {
		log.info("[inicia] CartaoController - criaCartao");
		log.info("[idCliente] {}", idCliente);
		CartaoResponse cartao = cartaoService.criaCartao(idCliente, cartaoRequest);
		log.info("[finaliza] CartaoController - criaCartao");
		return cartao;
	}

	@Override
	public CartaoDetalhadoResponse getCartaoPorNumero(String numeroCartao) {
		log.info("[inicia] CartaoController - getCartaoPorNumero");
		log.info("[idCliente] {}", numeroCartao);
		CartaoDetalhadoResponse cartaoDetalhado = cartaoService.getCartaoPorNumero(numeroCartao);
		log.info("[inicia] CartaoController - getCartaoPorNumero");
		return cartaoDetalhado;
	}

	@Override
	public TransacaoResponse postTransacao(@Valid TransacaoRequest transacaoRequest, String numeroCartao) {
		log.info("[inicia] CartaoController - postTransacao");
		log.info("[numeroCartao]{}", numeroCartao);
		TransacaoResponse transacao = cartaoService.realizaTransacao(transacaoRequest, numeroCartao);
		log.info("[finaliza] CartaoController - postTransacao");
		return transacao;
	}

}
