package br.gov.sp.fatec.livLivraria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyEndereco;
import br.gov.sp.fatec.livLivraria.daos.EnderecoDao;
import br.gov.sp.fatec.livLivraria.dto.EnderecoDTO;
import br.gov.sp.fatec.livLivraria.entities.Endereco;
import br.gov.sp.fatec.livLivraria.repositories.EnderecoRepository;
import br.gov.sp.fatec.livLivraria.results.ResultadoEndereco;
import br.gov.sp.fatec.livLivraria.services.EnderecoService;

@Service
@Transactional(readOnly = false)
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoDao daoEndereco;

	@Autowired
	private RegrasNegocioEndereco fachadaRegraNegocioEndereco;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public EnderecoServiceImpl() {
	}

	@Override
	public ResultadoEndereco salvar(Endereco endereco) {

		ResultadoEndereco resultado = new ResultadoEndereco();

		ResultadoStrategyEndereco resultadoStrategyEndereco = fachadaRegraNegocioEndereco.executarRegras(endereco,
				"SALVAR");

		endereco = resultadoStrategyEndereco.getEndereco();

		for (String mensagemErroEndereco : resultadoStrategyEndereco.getMensagens()) {
			resultado.addMensagem(mensagemErroEndereco);
		}

		System.out.println(resultado.getMensagens().size());

		for (String msg : resultado.getMensagens()) {
			System.out.println(msg);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoEndereco.save(endereco);
			resultado.addEnderecoDTO(new EnderecoDTO(endereco));
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	public ResultadoEndereco editar(Endereco endereco) {
		ResultadoEndereco resultado = new ResultadoEndereco();

		ResultadoStrategyEndereco resultadoStrategyEndereco = fachadaRegraNegocioEndereco.executarRegras(endereco,
				"ALTERAR");
		endereco = resultadoStrategyEndereco.getEndereco();

		for (String mensagemErroEndereco : resultadoStrategyEndereco.getMensagens()) {
			resultado.addMensagem(mensagemErroEndereco);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoEndereco.update(endereco);
			resultado.addEnderecoDTO(new EnderecoDTO(endereco));
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	public ResultadoEndereco excluir(Endereco endereco) {
		ResultadoEndereco resultado = new ResultadoEndereco();

		ResultadoStrategyEndereco resultadoStrategyEndereco = fachadaRegraNegocioEndereco.executarRegras(endereco,
				"EXCLUIR");
		endereco = resultadoStrategyEndereco.getEndereco();

		for (String mensagemErroEndereco : resultadoStrategyEndereco.getMensagens()) {
			resultado.addMensagem(mensagemErroEndereco);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoEndereco.delete(endereco.getId());
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoEndereco buscarPorId(Long id) {
		ResultadoEndereco resultado = new ResultadoEndereco();
		resultado.addEnderecoDTO(new EnderecoDTO(daoEndereco.findById(id)));
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoEndereco buscarTodos() {
		ResultadoEndereco resultado = new ResultadoEndereco();
		List<Endereco> listaEndereco = daoEndereco.findAll();

		List<EnderecoDTO> listaDTO = listaEndereco.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());

		resultado.setResultadoLista(listaDTO);

		return resultado;
	}

	@Override
	public ResultadoEndereco buscarPorCliente(Long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	@Transactional(readOnly = true)
	public ResultadoEndereco buscarPorCliente(Long idCliente) {
		List<Endereco> listaEndereco = enderecoRepository.findByCliente(idCliente.toString());
		ResultadoEndereco resultado = new ResultadoEndereco();
		List<EnderecoDTO> listaDTO = 
				listaEndereco.stream().map(x -> new EnderecoDTO(x)).collect(Collectors.toList());
		resultado.setResultadoLista(listaDTO);
		return resultado;
	}*/

}
