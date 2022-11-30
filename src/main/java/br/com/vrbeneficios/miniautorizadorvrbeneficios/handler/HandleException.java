package br.com.vrbeneficios.miniautorizadorvrbeneficios.handler;

import org.springframework.stereotype.Component;

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