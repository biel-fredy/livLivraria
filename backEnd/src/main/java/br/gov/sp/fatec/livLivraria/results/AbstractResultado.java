package br.gov.sp.fatec.livLivraria.results;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractResultado {

	private List<String> mensagens = new ArrayList<String>();
	private Boolean successOrFailed;

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}
	
	public void addMensagem(String mensagem) {
		mensagens.add(mensagem);
	}

	
	public Boolean getSuccessOrFailed() {
		return successOrFailed;
	}

	public void setSuccessOrFailed(Boolean successOrFailed) {
		this.successOrFailed = successOrFailed;
	}

}
