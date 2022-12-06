package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.service;

import java.util.UUID;

import javax.validation.Valid;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoDetalhadoResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoRequest;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.TransacaoRequest;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.TransacaoResponse;

public interface CartaoService {

	CartaoResponse criaCartao(UUID idCliente, CartaoRequest cartaoRequest);

	CartaoDetalhadoResponse getCartaoPorNumero(String numeroCartao);

	TransacaoResponse realizaTransacao(@Valid TransacaoRequest transacaoRequest, String numeroCartao);

}
