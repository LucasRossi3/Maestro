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

import br.com.integracorp.entities.CompanyEntity;
import br.com.integracorp.servicies.CompanyService;

@RestController
@RequestMapping
public class CompanyResource {
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping(value="/companies")
	public ResponseEntity<List<CompanyEntity>> findAll(){
		List<CompanyEntity> list = companyService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/company/{id}")
	public ResponseEntity<CompanyEntity> findById(@PathVariable Long id){
		CompanyEntity company = companyService.findById(id);
		return ResponseEntity.ok().body(company);
	}
	
	@PostMapping(value="/company")
	public ResponseEntity<CompanyEntity> save(@RequestBody CompanyEntity company)
	{
		company = companyService.save(company);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(company.getId()).
				toUri();
		return ResponseEntity.created(uri).body(company);
	}
	
	@PutMapping(value="/company/{id}")
	public ResponseEntity<CompanyEntity> update(@PathVariable Long id, @RequestBody CompanyEntity company)
	{
		company = companyService.update(id, company);
		return ResponseEntity.ok().body(company);
	}
	
	@DeleteMapping(value="/company/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id)
	{
		companyService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
