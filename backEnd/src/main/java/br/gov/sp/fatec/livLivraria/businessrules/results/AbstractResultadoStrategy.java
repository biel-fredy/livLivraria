package br.gov.sp.fatec.livLivraria.businessrules.results;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractResultadoStrategy {
	
	private List<String> mensagens = new ArrayList<String>();

	public AbstractResultadoStrategy() {
	}
	
	public AbstractResultadoStrategy(List<String> mensagens) {
		this.mensagens = mensagens;
	}
		
	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}
	
	public void addMensagem(String mensagem) {
		this.mensagens.add(mensagem);
	}

}
