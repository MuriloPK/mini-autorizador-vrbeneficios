package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api.ClienteRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "cliente")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cliente {

	@Id
	private UUID idCliente;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	@Indexed(unique = true)
	private String email;
	private Sexo sexo;

	public Cliente(@Valid ClienteRequest clienteRequest) {
		this.idCliente = UUID.randomUUID();
		this.nomeCompleto = clienteRequest.getNomeCompleto();
		this.email = clienteRequest.getEmail();
		this.sexo = clienteRequest.getSexo();
	}

}