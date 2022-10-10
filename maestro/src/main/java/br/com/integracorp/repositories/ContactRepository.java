package br.com.integracorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.integracorp.entities.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long>{

}
