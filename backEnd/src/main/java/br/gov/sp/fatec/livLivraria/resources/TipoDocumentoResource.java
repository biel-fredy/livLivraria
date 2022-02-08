package br.gov.sp.fatec.livLivraria.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.sp.fatec.livLivraria.dto.TipoDocumentoDTO;
import br.gov.sp.fatec.livLivraria.entities.TipoDocumento;
import br.gov.sp.fatec.livLivraria.results.ResultadoTipoDocumento;
import br.gov.sp.fatec.livLivraria.services.TipoDocumentoService;

@RestController
@RequestMapping(value = "/tipo-documento")
public class TipoDocumentoResource {

	@Autowired
	private TipoDocumentoService service;

	@GetMapping
	public ResponseEntity<List<TipoDocumentoDTO>> findAll() {
		ResultadoTipoDocumento resultado = service.buscarTodos();
		return ResponseEntity.ok().body(resultado.getResultadoLista());

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoDocumentoDTO> findById(@PathVariable Long id) {
		ResultadoTipoDocumento resultado = service.buscarPorId(id);
		return ResponseEntity.ok().body(resultado.getResultadoLista().get(0));

	}

	@PostMapping
	public ResponseEntity<TipoDocumentoDTO> insert(@RequestBody TipoDocumentoDTO dto) {
		TipoDocumento tipoDocumento = new TipoDocumento(dto);

		ResultadoTipoDocumento resultado = service.salvar(tipoDocumento);

		if (resultado.getSuccessOrFailed()) {
			dto = resultado.getResultadoLista().get(0);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
					.toUri();
			return ResponseEntity.created(uri).body(dto);
		}
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TipoDocumentoDTO> update(@PathVariable Long id, @RequestBody TipoDocumentoDTO dto) {
		TipoDocumento tipoDocumento = new TipoDocumento(dto);

		tipoDocumento.setId(id);

		ResultadoTipoDocumento resultado = service.editar(tipoDocumento);

		dto = resultado.getResultadoLista().get(0);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TipoDocumentoDTO> delete(@PathVariable Long id) {
		TipoDocumento tipoDocumento = new TipoDocumento(id);

		ResultadoTipoDocumento resultado = service.excluir(tipoDocumento);

		return ResponseEntity.noContent().build();
	}

}
