package br.gov.sp.fatec.livLivraria.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.livLivraria.businessrules.fachadasRegraNegocios.RegrasNegocioBandeira;
import br.gov.sp.fatec.livLivraria.businessrules.results.ResultadoStrategyBandeira;
import br.gov.sp.fatec.livLivraria.entities.Bandeira;
import br.gov.sp.fatec.livLivraria.repositories.BandeiraRepository;
import br.gov.sp.fatec.livLivraria.results.ResultadoBandeira;
import br.gov.sp.fatec.livLivraria.services.BandeiraService;

@Service
@Transactional(readOnly = false)
public class BandeiraServiceImpl implements BandeiraService {

	private BandeiraRepository bandeiraRepository;

	private RegrasNegocioBandeira fachadaRegraNegocioBandeira;

	@Autowired
	public BandeiraServiceImpl(BandeiraRepository bandeiraRepository,
			RegrasNegocioBandeira fachadaRegraNegocioBandeira) {
		super();
		this.bandeiraRepository = bandeiraRepository;
		this.fachadaRegraNegocioBandeira = fachadaRegraNegocioBandeira;
	}

	@Override
	public ResultadoBandeira buscarPorId(Long id) {
		Bandeira bandeira = bandeiraRepository.getOne(id);
		return new ResultadoBandeira(bandeira);
	}

	public ResultadoBandeira buscarTodos() {
		List<Bandeira> listaBandeiras = bandeiraRepository.findAll();
		return new ResultadoBandeira(listaBandeiras);
	}

	@Override
	public ResultadoBandeira salvar(Bandeira bandeira) {
		ResultadoBandeira resultado = new ResultadoBandeira();
		ResultadoStrategyBandeira resultadoStrategyBandeira = fachadaRegraNegocioBandeira.executarRegras(bandeira,
				"SALVAR");

		for (String mensagemErroCliente : resultadoStrategyBandeira.getMensagens()) {
			resultado.addMensagem(mensagemErroCliente);
		}

		if (resultado.getMensagens().size() <= 0) {
			bandeiraRepository.save(resultadoStrategyBandeira.getBandeira());
			resultado.addBandeiraDTO(resultadoStrategyBandeira.getBandeira());
			resultado.setSuccessOrFailed(true);
		} else {
			resultado.setSuccessOrFailed(false);
		}
		return resultado;
	}

}
