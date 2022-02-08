package br.gov.sp.fatec.livLivraria.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioCartao;
import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioCliente;
import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioEndereco;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCartao;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyDocumento;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyEndereco;
import br.gov.sp.fatec.livLivraria.daos.ClienteDao;
import br.gov.sp.fatec.livLivraria.daos.DocumentoDao;
import br.gov.sp.fatec.livLivraria.dto.ClienteDTO;
import br.gov.sp.fatec.livLivraria.entities.Bandeira;
import br.gov.sp.fatec.livLivraria.entities.Cartao;
import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.entities.Documento;
import br.gov.sp.fatec.livLivraria.entities.Endereco;
import br.gov.sp.fatec.livLivraria.repositories.BandeiraRepository;
import br.gov.sp.fatec.livLivraria.repositories.ClienteRepository;
import br.gov.sp.fatec.livLivraria.results.ResultadoCliente;
import br.gov.sp.fatec.livLivraria.services.ClienteService;

@Service
@Transactional(readOnly = false)
public class ClienteServiceImpl implements ClienteService {

	private ClienteDao daoCliente;

	private DocumentoDao daoDocumento;

	private ClienteRepository clienteRepository;

	private BandeiraRepository bandeiraRepository;

	private RegrasNegocioCliente fachadaRegraNegocioCliente;

	private RegrasNegocioDocumento fachadaRegraNegocioDocumento;

	private RegrasNegocioEndereco fachadaRegraNegocioEndereco;

	private RegrasNegocioCartao fachadaRegraNegocioCartao;

	public ClienteServiceImpl() {
	}

	@Autowired
	public ClienteServiceImpl(ClienteDao daoCliente, DocumentoDao daoDocumento, ClienteRepository clienteRepository,
			BandeiraRepository bandeiraRepository, RegrasNegocioCliente fachadaRegraNegocioCliente,
			RegrasNegocioDocumento fachadaRegraNegocioDocumento, RegrasNegocioEndereco fachadaRegraNegocioEndereco,
			RegrasNegocioCartao fachadaRegraNegocioCartao) {
		super();
		this.daoCliente = daoCliente;
		this.daoDocumento = daoDocumento;
		this.clienteRepository = clienteRepository;
		this.bandeiraRepository = bandeiraRepository;
		this.fachadaRegraNegocioCliente = fachadaRegraNegocioCliente;
		this.fachadaRegraNegocioDocumento = fachadaRegraNegocioDocumento;
		this.fachadaRegraNegocioEndereco = fachadaRegraNegocioEndereco;
		this.fachadaRegraNegocioCartao = fachadaRegraNegocioCartao;
	}

	@Override
	public ResultadoCliente salvar(Cliente cliente) {

		ResultadoCliente resultado = new ResultadoCliente();

		for (Documento documento : cliente.getDocumentos()) {
			ResultadoStrategyDocumento resultadoStrategyDocumento = fachadaRegraNegocioDocumento
					.executarRegras(documento, "SALVAR");
			documento.setCliente(cliente);
			for (String mensagemErroDocumento : resultadoStrategyDocumento.getMensagens()) {
				resultado.addMensagem(mensagemErroDocumento);
			}
		}

		for (Endereco endereco : cliente.getEnderecos()) {
			ResultadoStrategyEndereco resultadoStrategyEndereco = fachadaRegraNegocioEndereco.executarRegras(endereco,
					"SALVAR");
			for (String mensagemErroEndereco : resultadoStrategyEndereco.getMensagens()) {
				resultado.addMensagem(mensagemErroEndereco);
			}
		}

		for (Cartao cartao : cliente.getCartoes()) {
			Bandeira bandeira = bandeiraRepository.getOne(cartao.getBandeira().getId());
			cartao.setBandeira(bandeira);
			ResultadoStrategyCartao resultadoStrategyCartao = fachadaRegraNegocioCartao.executarRegras(cartao,
					"SALVAR");
			for (String mensagemErroCartao : resultadoStrategyCartao.getMensagens()) {
				resultado.addMensagem(mensagemErroCartao);
			}
		}

		ResultadoStrategyCliente resultadoStrategyCliente = fachadaRegraNegocioCliente.executarRegras(cliente,
				"SALVAR");

		cliente = resultadoStrategyCliente.getCliente();

		for (String mensagemErroCliente : resultadoStrategyCliente.getMensagens()) {
			resultado.addMensagem(mensagemErroCliente);
		}
		
		if (resultado.getMensagens().size() <= 0) {
			clienteRepository.save(cliente);
			resultado.addClienteDTO(cliente);
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	public ResultadoCliente editar(Cliente cliente) {
		ResultadoCliente resultado = new ResultadoCliente();

		for (Documento documento : cliente.getDocumentos()) {
			ResultadoStrategyDocumento resultadoStrategyDocumento = fachadaRegraNegocioDocumento
					.executarRegras(documento, "ALTERAR");
			for (String mensagemErroDocumento : resultadoStrategyDocumento.getMensagens()) {
				resultado.addMensagem(mensagemErroDocumento);
			}
		}

		for (Endereco endereco : cliente.getEnderecos()) {
			ResultadoStrategyEndereco resultadoStrategyEndereco = fachadaRegraNegocioEndereco.executarRegras(endereco,
					"ALTERAR");
			for (String mensagemErroEndereco : resultadoStrategyEndereco.getMensagens()) {
				resultado.addMensagem(mensagemErroEndereco);
			}
		}

		for (Cartao cartao : cliente.getCartoes()) {
			Bandeira bandeira = bandeiraRepository.getOne(cartao.getBandeira().getId());
			cartao.setBandeira(bandeira);
			ResultadoStrategyCartao resultadoStrategyCartao = fachadaRegraNegocioCartao.executarRegras(cartao,
					"ALTERAR");
			for (String mensagemErroCartao : resultadoStrategyCartao.getMensagens()) {
				resultado.addMensagem(mensagemErroCartao);
			}
		}

		ResultadoStrategyCliente resultadoStrategyCliente = fachadaRegraNegocioCliente.executarRegras(cliente,
				"ALTERAR");
		cliente = resultadoStrategyCliente.getCliente();

		for (String mensagemErroCliente : resultadoStrategyCliente.getMensagens()) {
			resultado.addMensagem(mensagemErroCliente);
		}

		for (String mensagem : resultado.getMensagens()) {
			System.out.println(mensagem);
		}

		if (resultado.getMensagens().size() <= 0) {
			clienteRepository.save(cliente);
			resultado.addClienteDTO(new ClienteDTO(cliente));
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	public ResultadoCliente excluir(Cliente cliente) {
		ResultadoCliente resultado = new ResultadoCliente();

		for (Documento documento : cliente.getDocumentos()) {
			ResultadoStrategyDocumento resultadoStrategyDocumento = fachadaRegraNegocioDocumento
					.executarRegras(documento, "EXCLUIR");
			for (String mensagemErroDocumento : resultadoStrategyDocumento.getMensagens()) {
				resultado.addMensagem(mensagemErroDocumento);
			}
		}

		ResultadoStrategyCliente resultadoStrategyCliente = fachadaRegraNegocioCliente.executarRegras(cliente,
				"EXCLUIR");
		cliente = resultadoStrategyCliente.getCliente();

		for (String mensagemErroCliente : resultadoStrategyCliente.getMensagens()) {
			resultado.addMensagem(mensagemErroCliente);
		}

		if (resultado.getMensagens().size() <= 0) {
			daoCliente.delete(cliente.getId());
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoCliente buscarPorId(Long id) {
		ResultadoCliente resultado = new ResultadoCliente();
		resultado.addClienteDTO(new ClienteDTO(daoCliente.findById(id)));
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoCliente buscarPorCpf(String cpf) {
		Documento documento = daoDocumento.findByCodigo(cpf);
		Cliente cliente = daoCliente.getReference(documento.getCliente().getId());
		ResultadoCliente resultado = new ResultadoCliente();
		resultado.addClienteDTO(new ClienteDTO(cliente));
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoCliente buscarTodos(Long idCliente, String nome, Boolean status, String email, String genero,
			LocalDate dataNascimento) {
		ResultadoCliente resultado = new ResultadoCliente();

		List<Cliente> listaCliente = daoCliente.find(idCliente, nome, status, email, genero, dataNascimento);

		List<ClienteDTO> listaDTO = listaCliente.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

		resultado.setResultadoLista(listaDTO);

		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResultadoCliente buscarTodos() {
		ResultadoCliente resultado = new ResultadoCliente();

		List<Cliente> listaCliente = clienteRepository.findAll();

		List<ClienteDTO> listaDTO = listaCliente.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());

		resultado.setResultadoLista(listaDTO);

		return resultado;
	}

}
