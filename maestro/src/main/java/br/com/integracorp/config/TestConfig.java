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
		
	}

}
