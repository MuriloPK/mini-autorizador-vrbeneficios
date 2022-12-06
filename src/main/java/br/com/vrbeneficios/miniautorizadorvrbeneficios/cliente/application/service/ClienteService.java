package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api.ClienteDetalhadoResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api.ClienteListResponse;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api.ClienteRequest;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api.ClienteResponse;

public interface ClienteService {

	ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest);

	ClienteDetalhadoResponse getClientePorId(UUID idCliente);

	List<ClienteListResponse> getTodosClientes();

}
