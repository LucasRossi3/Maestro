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

import br.com.integracorp.entities.PartnerEntity;
import br.com.integracorp.servicies.PartnerService;

@RestController
@RequestMapping
public class PartnerResource {
	
	@Autowired
	private PartnerService partnerService;
	
	@GetMapping(value="/partners")
	public ResponseEntity<List<PartnerEntity>> findAll(){
		List<PartnerEntity> list = partnerService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/partner/{id}")
	public ResponseEntity<PartnerEntity> findById(@PathVariable Long id){
		PartnerEntity partner = partnerService.findById(id);
		return ResponseEntity.ok().body(partner);
	}
	
	@PostMapping(value="/partner")
	public ResponseEntity<PartnerEntity> save(@RequestBody PartnerEntity partner)
	{
		partner = partnerService.save(partner);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().
				path("/{id}").
				buildAndExpand(partner.getId()).
				toUri();
		return ResponseEntity.created(uri).body(partner);
	}
	
	@PutMapping(value="/partner/{id}")
	public ResponseEntity<PartnerEntity> update(@PathVariable Long id, @RequestBody PartnerEntity partner)
	{
		partner = partnerService.update(id, partner);
		return ResponseEntity.ok().body(partner);
	}
	
	@DeleteMapping(value="/partner/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id)
	{
		partnerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
