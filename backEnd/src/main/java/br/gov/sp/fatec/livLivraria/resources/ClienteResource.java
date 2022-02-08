package br.gov.sp.fatec.livLivraria.resources;

import java.net.URI;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.sp.fatec.livLivraria.dto.ClienteDTO;
import br.gov.sp.fatec.livLivraria.entities.Cliente;
import br.gov.sp.fatec.livLivraria.results.ResultadoCliente;
import br.gov.sp.fatec.livLivraria.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		ResultadoCliente resultado = service.buscarTodos();
		return ResponseEntity.ok().body(resultado.getResultadoLista());
	}

	@PostMapping(value = "/buscarClientes")
	public ResponseEntity<List<ClienteDTO>> findAll(@RequestBody ClienteDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dataNascimento = null;
		if(dto.getDataNascimento() != null && dto.getDataNascimento() != "") {
			dataNascimento = LocalDate.parse(dto.getDataNascimento(), formatter);
		}
		ResultadoCliente resultado = service.buscarTodos(dto.getId(), dto.getNome(), dto.getStatus(), dto.getEmail(),
				dto.getGenero(), dataNascimento);
		return ResponseEntity.ok().body(resultado.getResultadoLista());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Long id) {
		ResultadoCliente resultado = service.buscarPorId(id);
		return ResponseEntity.ok().body(resultado.getResultadoLista().get(0));

	}

	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@RequestBody ClienteDTO dto) {
		Cliente cliente = new Cliente(dto, dto.getDocumentos(), dto.getEnderecos(), dto.getTelefones(), dto.getCartoes());

		ResultadoCliente resultado = service.salvar(cliente);

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

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO dto) {
		Cliente cliente = new Cliente(dto);
		cliente.setId(id);

		ResultadoCliente resultado = service.editar(cliente);

		if(resultado.getSuccessOrFailed()) {
			dto = resultado.getResultadoLista().get(0);
			return ResponseEntity.ok().body(dto);
		}
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> delete(@PathVariable Long id) {
		Cliente cliente = new Cliente(id);

		ResultadoCliente resultado = service.excluir(cliente);

		return ResponseEntity.noContent().build();
	}

}
