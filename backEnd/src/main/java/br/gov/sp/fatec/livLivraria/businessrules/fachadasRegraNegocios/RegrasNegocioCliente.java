package br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.gov.sp.fatec.livLivraria.businessrules.RegraNegocioCliente;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyCliente;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cliente.DefineStatusCadastro;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cliente.PreencherDataCliente;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cliente.ValidarCPF;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cliente.ValidarExistenciaCPF;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cliente.VerificarCamposObrigatoriosCliente;
import br.gov.sp.fatec.livLivraria.businessrules.rules.cliente.VerificarObjetosCliente;
import br.gov.sp.fatec.livLivraria.entities.Cliente;

@Service
public class RegrasNegocioCliente {

	private Map<String, Map<String, List<RegraNegocioCliente>>> regrasDeNegocio = 
			new HashMap<String, Map<String, List<RegraNegocioCliente>>>();

	public RegrasNegocioCliente() {

		PreencherDataCliente preencherDataCliente = new PreencherDataCliente();
		VerificarCamposObrigatoriosCliente verificaObrigatoriosCliente = new VerificarCamposObrigatoriosCliente();
		VerificarObjetosCliente verificarObjetosCliente = new VerificarObjetosCliente();
		ValidarCPF validarCPF = new ValidarCPF();
		ValidarExistenciaCPF validarExistenciaCPF = new ValidarExistenciaCPF();
		DefineStatusCadastro defineStatusCadastro = new DefineStatusCadastro();

		List<RegraNegocioCliente> rnsSalvarCliente = new ArrayList<RegraNegocioCliente>();
		rnsSalvarCliente.add(preencherDataCliente);
		rnsSalvarCliente.add(verificaObrigatoriosCliente);
		rnsSalvarCliente.add(verificarObjetosCliente);
		rnsSalvarCliente.add(validarCPF);
		rnsSalvarCliente.add(validarExistenciaCPF);
		rnsSalvarCliente.add(defineStatusCadastro);

		List<RegraNegocioCliente> rnsAlterarCliente = new ArrayList<RegraNegocioCliente>();
		rnsAlterarCliente.add(verificaObrigatoriosCliente);

		Map<String, List<RegraNegocioCliente>> rnsCliente = new HashMap<String, List<RegraNegocioCliente>>();
		rnsCliente.put("SALVAR", rnsSalvarCliente);
		rnsCliente.put("ALTERAR", rnsAlterarCliente);

		regrasDeNegocio.put(Cliente.class.getName(), rnsCliente);
	}

	public ResultadoStrategyCliente executarRegras(Cliente cliente, String operacao) {
		ResultadoStrategyCliente resultado = new ResultadoStrategyCliente();
		resultado.setCliente(cliente);
		String nmClasse = cliente.getClass().getName();

		Map<String, List<RegraNegocioCliente>> regrasClasse = regrasDeNegocio.get(nmClasse);

		if (regrasClasse != null) {
			List<RegraNegocioCliente> regrasOperacao = regrasClasse.get(operacao);

			if (regrasOperacao != null) {
				for (RegraNegocioCliente strategies : regrasOperacao) {
					ResultadoStrategyCliente resultadoStrategy = strategies.processar(resultado.getCliente());
					
					if (resultadoStrategy.getMensagens() != null) {
						for (String mensagemErro : resultadoStrategy.getMensagens()) {
							resultado.addMensagem(mensagemErro);
						}
					}
					resultado.setCliente(resultadoStrategy.getCliente());

				}
			}
		}
		return resultado;
	}

}
