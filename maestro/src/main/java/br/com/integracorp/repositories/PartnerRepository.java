package br.com.integracorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.integracorp.entities.CompanyEntity;
import br.com.integracorp.entities.PartnerEntity;

@Repository
public interface PartnerRepository extends JpaRepository<PartnerEntity, Long>{

}
