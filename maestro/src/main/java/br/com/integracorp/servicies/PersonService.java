package br.com.integracorp.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integracorp.entities.PersonEntity;
import br.com.integracorp.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<PersonEntity> findAll(){
		return personRepository.findAll();
	}
	
	public PersonEntity findById(Long id)
	{
		Optional<PersonEntity> person =  personRepository.findById(id);
		return person.orElse(null);
	}
	
	public PersonEntity save(PersonEntity person)
	{
		return personRepository.save(person);
	}
	
	public void delete (Long id)
	{
		personRepository.deleteById(id);
	}
	
	public PersonEntity update(Long id, PersonEntity person)
	{
		PersonEntity personMonitored = personRepository.getReferenceById(id);
		updateData(personMonitored, person);
		return personRepository.save(personMonitored);
	}

	private void updateData(PersonEntity personMonitored, PersonEntity person) {
		personMonitored.setName(person.getName());
		personMonitored.setDoc_rg(person.getDoc_rg());
		personMonitored.setDoc_cpf(person.getDoc_cpf());
		personMonitored.setBirthday(person.getBirthday());
		personMonitored.setEmail(person.getEmail());
	}
	
	
}
