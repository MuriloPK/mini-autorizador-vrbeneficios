package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Transacao;

public interface TransacaoInfraMongoRepository extends MongoRepository<Transacao, UUID>{

}
