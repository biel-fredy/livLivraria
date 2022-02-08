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

import br.gov.sp.fatec.livLivraria.dto.EnderecoDTO;
import br.gov.sp.fatec.livLivraria.entities.Endereco;
import br.gov.sp.fatec.livLivraria.results.ResultadoEndereco;
import br.gov.sp.fatec.livLivraria.services.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;

	@GetMapping
	public ResponseEntity<List<EnderecoDTO>> findAll() {
		ResultadoEndereco resultado = service.buscarTodos();
		return ResponseEntity.ok().body(resultado.getResultadoLista());

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id) {
		ResultadoEndereco resultado = service.buscarPorId(id);
		return ResponseEntity.ok().body(resultado.getResultadoLista().get(0));

	}
	
	@GetMapping(value = "/cliente/{idCliente}")
	public ResponseEntity<List<EnderecoDTO>> findByCliente(@PathVariable Long idCliente){
		ResultadoEndereco resultado = service.buscarPorCliente(idCliente);
		return ResponseEntity.ok().body(resultado.getResultadoLista());
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> insert(@RequestBody EnderecoDTO dto) {

		Endereco endereco = new Endereco(dto);

		ResultadoEndereco resultado = service.salvar(endereco);

		if (resultado.getSuccessOrFailed()) {
			dto = resultado.getResultadoLista().get(0);

			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
					.toUri();
			return ResponseEntity.created(uri).body(dto);
		}
		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> update(@PathVariable Long id, @RequestBody EnderecoDTO dto) {
		Endereco endereco = new Endereco(dto);

		endereco.setId(id);

		ResultadoEndereco resultado = service.editar(endereco);

		dto = resultado.getResultadoLista().get(0);

		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EnderecoDTO> delete(@PathVariable Long id) {
		Endereco endereco = new Endereco(id);

		ResultadoEndereco resultado = service.excluir(endereco);

		return ResponseEntity.noContent().build();
	}

}
