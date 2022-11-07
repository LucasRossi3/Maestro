package br.com.integracorp.resources;

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

import br.com.integracorp.entities.ClientEntity;
import br.com.integracorp.servicies.ClientService;

@RestController
@RequestMapping
public class ClientResource {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping(value="/customers")
	public ResponseEntity<List<ClientEntity>> findAll(){
		List<ClientEntity> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/client/{id}")
	public ResponseEntity<ClientEntity> findById(@PathVariable Long id){
		ClientEntity client = clientService.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping(value="/client")
	public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity client)
	{
		client = clientService.save(client);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(client.getId()).
				toUri();
		return ResponseEntity.created(uri).body(client);
	}
	
	@PutMapping(value="/client/{id}")
	public ResponseEntity<ClientEntity> update(@PathVariable Long id, @RequestBody ClientEntity client)
	{
		client = clientService.update(id, client);
		return ResponseEntity.ok().body(client);
	}
	
	@DeleteMapping(value="/client/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id)
	{
		clientService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
