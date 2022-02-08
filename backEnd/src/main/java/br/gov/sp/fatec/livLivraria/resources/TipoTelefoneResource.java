package br.gov.sp.fatec.livLivraria.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.livLivraria.dto.enums.TipoTelefoneDTO;
import br.gov.sp.fatec.livLivraria.entities.enums.TipoTelefone;

@RestController
@RequestMapping(value = "/tiposTelefone")
public class TipoTelefoneResource {

	@GetMapping
	public ResponseEntity<List<TipoTelefoneDTO>> findAll() {
		List<TipoTelefoneDTO> listaTipoTelefone = new ArrayList<TipoTelefoneDTO>();
		for (TipoTelefone tipoTelefone : TipoTelefone.values()) {
			listaTipoTelefone.add(new TipoTelefoneDTO(tipoTelefone));
		}

		return ResponseEntity.ok().body(listaTipoTelefone);
	}

}
