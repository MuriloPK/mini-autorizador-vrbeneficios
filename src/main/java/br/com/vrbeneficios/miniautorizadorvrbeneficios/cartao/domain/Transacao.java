package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.TransacaoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "transacao")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Transacao {

	@Id
	private UUID idTransacao;
	private StatusCompra statusCompra;
	private Double valorCompra;
	@Size(min = 4, max = 4, message = "senha deve ter 4 digitos")
	private String senha;

	public Transacao(@Valid TransacaoRequest transacaoRequest) {
		this.idTransacao = UUID.randomUUID();
		this.valorCompra = transacaoRequest.getValorCompra();
		this.senha = transacaoRequest.getSenha();
		this.statusCompra = StatusCompra.APROVADA;
	}

}
