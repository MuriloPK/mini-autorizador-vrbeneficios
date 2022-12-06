package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.repository;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Cartao;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Transacao;

public interface CartaoRepository {

	Cartao salvaCartao(Cartao cartao);

	Cartao buscaCartaoPorNumero(String numeroCartao);

	Transacao salvaTransacao(Transacao transacao);

}
