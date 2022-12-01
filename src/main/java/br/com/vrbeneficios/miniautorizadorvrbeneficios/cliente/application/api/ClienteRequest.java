package br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.application.api;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.mongodb.core.index.Indexed;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cliente.domain.Sexo;
import lombok.Value;

@Value
public class ClienteRequest {

	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	@Indexed(unique = true)
	private String email;
	@Indexed
	private Sexo sexo;
}
