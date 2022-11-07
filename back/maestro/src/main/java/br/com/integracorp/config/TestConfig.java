package br.com.integracorp.config;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.integracorp.entities.PersonEntity;
import br.com.integracorp.repositories.PersonRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	PersonRepository personRepository;

	@Override
	public void run(String... args) throws Exception {
		String name="Evandro Rodrigues Tiburcio";
		String doc_rg="470587003";
		String doc_cpf="35458436881";
		Date birthday=Date.valueOf("03-03-1990");
				
		PersonEntity p1 = new PersonEntity();
		
		p1.setEmail("evandro@gmail.com");
		//p1.email="15988420001";
		
		
		/*p1.setName(name);
		p1.setDoc_rg(doc_rg);
		p1.setDoc_cpf(doc_cpf);
		p1.setBirthday(birthday);
		
		personRepository.saveAll(Arrays.asList(p1));
		*/
	}

}
