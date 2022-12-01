package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.application.api.CartaoRequest;
import br.com.vrbeneficios.miniautorizadorvrbeneficios.handler.HandleException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "cartao")
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Cartao {

	@Id
	private UUID idCartao;
	@NotNull
	private UUID idCartaoCliente;
	@NotNull
	private String numeroCartao;
	@NotNull
	@Size(min = 4, max = 4, message = "senha deve ter 4 digitos")
	private String senha;
	private Double limiteCartao;
	private LocalDate validadeCartao;
	@Indexed(name = "data_criacao")
	private LocalDate dataHoraCriacaoCartao;

	public Cartao(UUID idCliente, @Valid CartaoRequest cartaoRequest) {
		this.idCartao = UUID.randomUUID();
		this.idCartaoCliente = idCliente;
		this.numeroCartao = gerarDigitosAleatorios(16);
		this.senha = cartaoRequest.getSenha();
		this.limiteCartao = 500.0;
		this.validadeCartao = LocalDate.now().plusYears(3).plusMonths(5);
		this.dataHoraCriacaoCartao = LocalDate.now();
	}

	public void validarAtribuirNovoSaldo(Double valor, HandleException handleException) {
		this.limiteCartao = this.limiteCartao >= valor ? this.limiteCartao - valor
				: (Double) handleException.throwExcecaoDeValidacao(Validacao.SALDO_INSUFICIENTE);

	}

	private String gerarDigitosAleatorios(int digitos) {
		StringBuilder text = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < digitos; i++) {
			text.append(random.nextInt(10));
		}
		return text.toString();
	}

}
