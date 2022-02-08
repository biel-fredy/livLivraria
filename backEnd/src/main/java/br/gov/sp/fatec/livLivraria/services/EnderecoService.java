package br.gov.sp.fatec.livLivraria.services;

import br.gov.sp.fatec.livLivraria.entities.Endereco;
import br.gov.sp.fatec.livLivraria.results.ResultadoEndereco;

public interface EnderecoService {
	
	public ResultadoEndereco salvar(Endereco endereco);

	public ResultadoEndereco editar(Endereco endereco);

	public ResultadoEndereco excluir(Endereco endereco);

	public ResultadoEndereco buscarPorId(Long id);

	public ResultadoEndereco buscarTodos();
	
	public ResultadoEndereco buscarPorCliente(Long idCliente);

}
