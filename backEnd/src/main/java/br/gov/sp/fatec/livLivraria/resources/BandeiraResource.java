package br.gov.sp.fatec.livLivraria.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.sp.fatec.livLivraria.dto.BandeiraDTO;
import br.gov.sp.fatec.livLivraria.dto.ClienteDTO;
import br.gov.sp.fatec.livLivraria.entities.Bandeira;
import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.results.ResultadoBandeira;
import br.gov.sp.fatec.livLivraria.results.ResultadoCliente;
import br.gov.sp.fatec.livLivraria.services.BandeiraService;

@RestController
@RequestMapping(value = "/bandeiras")
public class BandeiraResource {

	@Autowired
	private BandeiraService service;

	@GetMapping
	public ResponseEntity<List<BandeiraDTO>> findAll() {
		ResultadoBandeira resultado = service.buscarTodos();
		return ResponseEntity.ok().body(resultado.getResultadoLista());
	}
	
	@PostMapping
	public ResponseEntity<BandeiraDTO> insert(@RequestBody BandeiraDTO dto) {
		Bandeira bandeira = new Bandeira(dto);

		ResultadoBandeira resultado = service.salvar(bandeira);

		if (resultado.getSuccessOrFailed()) {
			dto = resultado.getResultadoLista().get(0);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
					.toUri();
			return ResponseEntity.created(uri).body(dto);
		} else {
			for (String msg : resultado.getMensagens()) {
				System.out.println(msg);
			}
		}

		return ResponseEntity.noContent().build();
	}

}
