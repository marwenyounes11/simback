package org.sim.gestion.repository;


import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sim.gestion.entity.RessourceHumaine;
import org.sim.gestion.entity.Sim;
import org.sim.gestion.response.SimResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;





@Repository
@CrossOrigin("*")
@Transactional
public interface SimRepository extends JpaRepository<Sim, Long> {
	
	
	@Query("SELECT new org.sim.gestion.response.SimResponse(s.id,s.aff,s.numAppel,s.numAppelAbreg,s.modelAppareilGsm,s.imei1,s.imei2,s.numSerieBatterie,s.dateMiseEnService,s.dateExpiration,s.remarque,s.ressourceHumaine ) "
			  +
			  "FROM Sim s "
			  ) List<SimResponse> listSim();
}
