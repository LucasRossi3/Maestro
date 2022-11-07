package br.com.integracorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.integracorp.entities.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long>{

}
