package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain.Cliente;

public interface ClienteInfraMongoRepository extends MongoRepository<Cliente, UUID>{

}
