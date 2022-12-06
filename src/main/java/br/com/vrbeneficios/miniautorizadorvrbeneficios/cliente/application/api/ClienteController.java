package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {

	private final ClienteService clienteService;

	@Override
	public ClienteResponse criaCliente(@Valid ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - criaCliente");
		ClienteResponse cliente = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - criaCliente");
		return cliente;
	}

	@Override
	public ClienteDetalhadoResponse getClientePorId(UUID idCliente) {
		log.info("[inicia] ClienteController - getClientePorId");
		ClienteDetalhadoResponse cliente = clienteService.getClientePorId(idCliente);
		log.info("[finaliza] ClienteController - getClientePorId");
		return cliente;
	}

	@Override
	public List<ClienteListResponse> getTodosClientes() {
		log.info("[inicia] ClienteController - getTodosClientes");
		List<ClienteListResponse> cliente = clienteService.getTodosClientes();
		log.info("[finaliza] ClienteController - getTodosClientes");
		return cliente;
	}

}
