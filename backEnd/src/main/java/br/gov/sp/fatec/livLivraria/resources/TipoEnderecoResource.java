package br.gov.sp.fatec.livLivraria.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.livLivraria.dto.enums.TipoEnderecoDTO;
import br.gov.sp.fatec.livLivraria.entities.enums.TipoEndereco;

@RestController
@RequestMapping(value = "/tiposEndereco")
public class TipoEnderecoResource {

	@GetMapping
	public ResponseEntity<List<TipoEnderecoDTO>> findAll() {
		List<TipoEnderecoDTO> listaTipoEndereco = new ArrayList<TipoEnderecoDTO>();
		for (TipoEndereco tipoEndereco : TipoEndereco.values()) {
			listaTipoEndereco.add(new TipoEnderecoDTO(tipoEndereco));
		}

		return ResponseEntity.ok().body(listaTipoEndereco);
	}
}
