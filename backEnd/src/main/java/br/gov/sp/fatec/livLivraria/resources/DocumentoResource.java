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

import br.gov.sp.fatec.livLivraria.dto.DocumentoDTO;
import br.gov.sp.fatec.livLivraria.entities.Documento;
import br.gov.sp.fatec.livLivraria.results.ResultadoDocumento;
import br.gov.sp.fatec.livLivraria.services.DocumentoService;

@RestController
@RequestMapping(value = "/documentos")
public class DocumentoResource {

	@Autowired
	private DocumentoService service;

	@GetMapping
	public ResponseEntity<List<DocumentoDTO>> findAll() {
		ResultadoDocumento resultado = service.buscarTodos();
		return ResponseEntity.ok().body(resultado.getResultadoLista());

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<DocumentoDTO> findById(@PathVariable Long id) {
		ResultadoDocumento resultado = service.buscarPorId(id);
		return ResponseEntity.ok().body(resultado.getResultadoLista().get(0));

	}

	@PostMapping
	public ResponseEntity<DocumentoDTO> insert(@RequestBody DocumentoDTO dto) {
		Documento documento = new Documento(dto);

		ResultadoDocumento resultado = service.salvar(documento);

		if (resultado.getSuccessOrFailed()) {
			dto = resultado.getResultadoLista().get(0);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
					.toUri();
			return ResponseEntity.created(uri).body(dto);
		}

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<DocumentoDTO> update(@PathVariable Long id, @RequestBody DocumentoDTO dto) {
		Documento documento = new Documento(dto);

		documento.setId(id);

		ResultadoDocumento resultado = service.editar(documento);

		dto = resultado.getResultadoLista().get(0);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<DocumentoDTO> delete(@PathVariable Long id) {
		Documento documento = new Documento(id);

		ResultadoDocumento resultado = service.excluir(documento);

		return ResponseEntity.noContent().build();
	}

}
