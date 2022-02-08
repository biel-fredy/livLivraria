package br.gov.sp.fatec.livLivraria.services;

import java.time.LocalDate;

import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.results.ResultadoCliente;

public interface ClienteService {

	public ResultadoCliente salvar(Cliente cliente);

	public ResultadoCliente editar(Cliente cliente);

	public ResultadoCliente excluir(Cliente cliente);

	public ResultadoCliente buscarPorId(Long id);
	
	public ResultadoCliente buscarPorCpf(String cpf);

	ResultadoCliente buscarTodos(Long idCliente, String nome, Boolean status, String email, String genero,
			LocalDate dataNascimento);

	ResultadoCliente buscarTodos();

}
