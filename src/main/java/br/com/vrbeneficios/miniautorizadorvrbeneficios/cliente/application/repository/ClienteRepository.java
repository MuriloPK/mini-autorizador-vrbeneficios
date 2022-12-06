package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain.Cliente;

public interface ClienteRepository {

	Cliente salvaCliente(Cliente cliente);

	Cliente buscaClientePorId(UUID idCliente);

	List<Cliente> buscaTodosClientes();

}
