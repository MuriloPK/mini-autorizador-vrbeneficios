package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.infra;

import org.springframework.stereotype.Repository;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.repository.CartaoRepository;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Cartao;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Transacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class CartaoInfraRepository implements CartaoRepository {

	private final CartaoInfraMongoRepository cartaoInfraMongoRepository;
	private final TransacaoInfraMongoRepository transacaoInfraMongoRepository;

	@Override
	public Cartao salvaCartao(Cartao cartao) {
		log.info("[inicia] CartaoInfraRepository - salvaCartao");
		cartaoInfraMongoRepository.save(cartao);
		log.info("[finaliza] CartaoInfraRepository - salvaCartao");
		return cartao;
	}

	@Override
	public Cartao buscaCartaoPorNumero(String numeroCartao) {
		log.info("[inicia] CartaoInfraRepository - buscaCartaoPorNumero");
		Cartao cartao = cartaoInfraMongoRepository.findByNumeroCartao(numeroCartao);
		log.info("[finaliza] CartaoInfraRepository - buscaCartaoPorNumero");
		return cartao;
	}

	@Override
	public Transacao salvaTransacao(Transacao transacao) {
		log.info("[inicia] CartaoInfraRepository - salvaTransacao");
		transacaoInfraMongoRepository.save(transacao);
		log.info("[finaliza] CartaoInfraRepository - salvaTransacao");
		return transacao;
	}

}
