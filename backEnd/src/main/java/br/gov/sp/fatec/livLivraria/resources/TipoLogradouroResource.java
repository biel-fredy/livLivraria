package br.gov.sp.fatec.livLivraria.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.livLivraria.dto.enums.TipoLogradouroDTO;
import br.gov.sp.fatec.livLivraria.entities.enums.TipoLogradouro;

@RestController
@RequestMapping(value = "/tiposLogradouro")
public class TipoLogradouroResource {

	@GetMapping
	public ResponseEntity<List<TipoLogradouroDTO>> findAll() {
		List<TipoLogradouroDTO> listaTipoLogradouro = new ArrayList<TipoLogradouroDTO>();
		for (TipoLogradouro tipoLogradouro : TipoLogradouro.values()) {
			listaTipoLogradouro.add(new TipoLogradouroDTO(tipoLogradouro));
		}

		return ResponseEntity.ok().body(listaTipoLogradouro);
	}

}
