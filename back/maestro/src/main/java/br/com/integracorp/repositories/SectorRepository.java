package br.com.integracorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.integracorp.entities.SectorEntity;

@Repository
public interface SectorRepository extends JpaRepository<SectorEntity, Long>{

}
