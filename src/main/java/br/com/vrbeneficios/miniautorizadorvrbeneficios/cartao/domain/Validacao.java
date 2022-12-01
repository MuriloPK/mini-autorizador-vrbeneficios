package br.com.vrbeneficios.miniautorizadorvrbeneficios.cartao.domain;

public enum Validacao {

	SALDO_INSUFICIENTE {
		@Override
		public String MensagemErro() {
			return "SALDO_INSUFICIENTE";
		}
	},
	SENHA_INVALIDA {
		@Override
		public String MensagemErro() {
			return "SENHA_INVALIDA";
		}
	},
	CARTAO_INEXISTENTE {
		@Override
		public String MensagemErro() {
			return "CARTAO_INEXISTENTE";
		}
	};

	public abstract String MensagemErro();

}
