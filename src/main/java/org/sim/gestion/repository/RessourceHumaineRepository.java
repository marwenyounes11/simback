package org.sim.gestion.repository;



import org.sim.gestion.entity.RessourceHumaine;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;



@Repository
@CrossOrigin("*")
@Transactional
public interface RessourceHumaineRepository extends JpaRepository<RessourceHumaine, Long> {
	
}
