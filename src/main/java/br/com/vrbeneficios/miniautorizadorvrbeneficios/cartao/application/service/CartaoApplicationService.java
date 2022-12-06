package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoDetalhadoResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoRequest;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.TransacaoRequest;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.TransacaoResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.repository.CartaoRepository;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Cartao;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.StatusCompra;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Transacao;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.service.ClienteService;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.handler.APIException;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.handler.HandleException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class CartaoApplicationService implements CartaoService {

	private final ClienteService clienteService;
	private final CartaoRepository cartaoRepository;
	private final HandleException handleException;

	@Override
	public CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest) {
		log.info("[inicia] CartaoApplicationService - criaCartao");
		clienteService.getClientePorId(idCliente);
		Cartao cartao = cartaoRepository.salvaCartao(new Cartao(idCliente, cartaoRequest));
		log.info("[finaliza] CartaoApplicationService - criaCartao");
		return new CartaoResponse(cartao.getIdCartao(), cartao.getValidadeCartao(), cartao.getNumeroCartao());
	}

	@Override
	public CartaoDetalhadoResponse getCartaoPorNumero(String numeroCartao) {
		log.info("[inicia] CartaoApplicationService - getCartaoPorNumero");
		Cartao cartao = cartaoRepository.buscaCartaoPorNumero(numeroCartao);
		if (cartao == null) {
			throw APIException.build(HttpStatus.NOT_FOUND, "Cartao Nao Encontrado, Verifique o Numero do Cartao");
		}
		log.info("[finaliza] CartaoApplicationService - getCartaoPorNumero");
		return new CartaoDetalhadoResponse(cartao);
	}

	@Override
	@Transactional
	public TransacaoResponse realizaTransacao(@Valid TransacaoRequest transacaoRequest, String numeroCartao) {
		log.info("[inicia] CartaoApplicationService - realizaTransacao");
		Cartao cartao = cartaoRepository.buscaCartaoPorNumero(numeroCartao);
		if (cartao == null) {
			throw APIException.build(HttpStatus.UNAUTHORIZED,
					"Imposivel Realizar a Transacao Numero do cartao Inexistente");
		}
		Transacao transacao = cartaoRepository.salvaTransacao(new Transacao(transacaoRequest));
		if (cartao.getLimiteCartao() < transacao.getValorCompra()) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Voce nao tem limite Para realizar a transacao");
		}
		cartao.validarAtribuirNovoSaldo(transacao.getValorCompra(), handleException);
		cartaoRepository.salvaCartao(cartao);
		log.info("[finaliza] CartaoApplicationService - realizaTransacao");
		return TransacaoResponse.builder().statusCompra(StatusCompra.APROVADA).valor(transacao.getValorCompra())
				.numeroCartao(cartao.getNumeroCartao()).idTransacao(transacao.getIdTransacao())
				.limiteCartao(cartao.getLimiteCartao()).build();
	}

}
