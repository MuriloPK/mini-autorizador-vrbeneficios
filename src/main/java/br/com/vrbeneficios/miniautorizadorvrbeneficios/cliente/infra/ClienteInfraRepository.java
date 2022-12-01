package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.repository.ClienteRepository;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain.Cliente;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteInfraMongoRepository clienteInfraMongoRepository;

	@Override
	public Cliente salvaCliente(Cliente cliente) {
		log.info("[inicia] ClienteInfraRepository - salvaCliente");
		clienteInfraMongoRepository.save(cliente);
		log.info("[finaliza] ClienteInfraRepository- salvaCliente");
		return cliente;
	}

	@Override
	public Cliente buscaClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteInfraRepository - buscaClientePorId");
		Cliente cliente = clienteInfraMongoRepository.findById(idCliente)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente Nao encontrado:" + idCliente));
		log.info("[finaliza] ClienteInfraRepository- buscaClientePorId");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
		List<Cliente> cliente = clienteInfraMongoRepository.findAll();
		log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
		return cliente;
	}

}
