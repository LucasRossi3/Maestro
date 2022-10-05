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

import br.com.integracorp.entities.PersonEntity;
import br.com.integracorp.servicies.PersonService;

@RestController
@RequestMapping
public class PersonResource {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value="/people")
	public ResponseEntity<List<PersonEntity>> findAll(){
		List<PersonEntity> list = personService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/person/{id}")
	public ResponseEntity<PersonEntity> findById(@PathVariable Long id){
		PersonEntity person = personService.findById(id);
		return ResponseEntity.ok().body(person);
	}
	
	@PostMapping(value="/person")
	public ResponseEntity<PersonEntity> save(@RequestBody PersonEntity person)
	{
		person = personService.save(person);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(person.getId()).
				toUri();
		return ResponseEntity.created(uri).body(person);
	}
	
	@PutMapping(value="/person/{id}")
	public ResponseEntity<PersonEntity> update(@PathVariable Long id, @RequestBody PersonEntity person)
	{
		person = personService.update(id, person);
		return ResponseEntity.ok().body(person);
	}
	
	@DeleteMapping(value="/person/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id)
	{
		personService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
