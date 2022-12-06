package br.com.vrbeneficios.miniautorizadorvrbeneficios.handler;

import org.springframework.stereotype.Component;

import br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain.Validacao;

@Component
public class HandleException {

	public Object throwExcecaoDeValidacao(Validacao erro) {
		switch (erro) {
		case SALDO_INSUFICIENTE:
			throw new InsuficienteException();
		default:
			return null;
		}
	}
}