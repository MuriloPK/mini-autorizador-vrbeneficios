package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain.Cliente;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain.Sexo;
import lombok.Getter;

@Getter
public class ClienteListResponse {

	private UUID idCliente;
	private String nomeCompleto;
	private String email;
	private Sexo sexo;

	public static List<ClienteListResponse> converte(List<Cliente> cliente) {
		return cliente.stream().map(ClienteListResponse::new)
				.collect(Collectors.toList());
	}

	public ClienteListResponse(Cliente cliente) {
		this.idCliente = cliente.getIdCliente();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.email = cliente.getEmail();
		this.sexo = cliente.getSexo();
	}

}
