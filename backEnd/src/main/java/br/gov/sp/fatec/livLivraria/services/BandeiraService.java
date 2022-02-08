package br.gov.sp.fatec.livLivraria.services;

import br.gov.sp.fatec.livLivraria.entities.Bandeira;
import br.gov.sp.fatec.livLivraria.results.ResultadoBandeira;

public interface BandeiraService {

	public ResultadoBandeira buscarPorId(Long id);

	public ResultadoBandeira buscarTodos();
	
	public ResultadoBandeira salvar(Bandeira bandeira);

}
