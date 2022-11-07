package br.com.integracorp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.integracorp.entities.UnitEntity;

@Repository
public interface UnitRepository extends JpaRepository<UnitEntity, Long>{

}
