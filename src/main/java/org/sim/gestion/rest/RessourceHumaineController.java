package org.sim.gestion.rest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.sim.gestion.entity.RessourceHumaine;
import org.sim.gestion.repository.RessourceHumaineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class RessourceHumaineController {
	@Autowired
	RessourceHumaineRepository repository;
	
	
	 @GetMapping("/listressourcehumaines")
	  public List<RessourceHumaine> getAllRessourceHumaines() {
	    System.out.println("Get all ressourcehumaines...");
	 
	    List<RessourceHumaine> ressourcehumaines = new ArrayList<>();
	    repository.findAll().forEach(ressourcehumaines::add);
	 
	    return ressourcehumaines;
	  }
	@GetMapping("/ressourcehumaines/{id}")
	public ResponseEntity<RessourceHumaine> getRessourceHumaineById(@PathVariable(value = "id") Long ressourcehumaineId)
			throws ResourceNotFoundException {
		RessourceHumaine ressourcehumaine = repository.findById(ressourcehumaineId)
				.orElseThrow(() -> new ResourceNotFoundException("RessourceHumaine not found for this id :: " + ressourcehumaineId));
		return ResponseEntity.ok().body(ressourcehumaine);
	}
	@PostMapping("/addressourcehumaines" )
	public RessourceHumaine createRessourceHumaine( @RequestBody RessourceHumaine ressourcehumaine) {
		return repository.save(ressourcehumaine);
	}
	
	@DeleteMapping("/deleteressourcehumaines/{id}")
	public Map<String, Boolean> deleteRessourceHumaine(@PathVariable(value = "id") Long ressourcehumaineId)
			throws ResourceNotFoundException {
		RessourceHumaine ressourcehumaine = repository.findById(ressourcehumaineId)
				.orElseThrow(() -> new ResourceNotFoundException("RessourceHumaine not found  id :: " + ressourcehumaineId));

		repository.delete(ressourcehumaine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	  @DeleteMapping("/ressourcehumaines/delete")
	  public ResponseEntity<String> deleteAllRessourceHumaines() {
	    System.out.println("Delete All RessourceHumaines...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All RessourceHumaines have been deleted!", HttpStatus.OK);
	  }
	 
	
	  @PutMapping("/editressourcehumaines/{id}")
	  public ResponseEntity<RessourceHumaine> updateRessourceHumaine(@PathVariable("id") long id, @RequestBody RessourceHumaine ressourcehumaine) {
	    System.out.println("Update RessourceHumaine with ID = " + id + "...");
	 
	    Optional<RessourceHumaine> ressourcehumaineInfo = repository.findById(id);
	 
	    if (ressourcehumaineInfo.isPresent()) {
	    	RessourceHumaine ressourcehumainee = ressourcehumaineInfo.get();
	          
	           ressourcehumainee.setNom(ressourcehumaine.getNom());
	           ressourcehumainee.setPrenom(ressourcehumaine.getPrenom());
	           ressourcehumainee.setDivision(ressourcehumaine.getDivision());
	           ressourcehumainee.setService(ressourcehumaine.getService());
	           ressourcehumainee.setMatricule(ressourcehumaine.getMatricule());
	           ressourcehumainee.setRef(ressourcehumaine.getRef());
	          
	      return new ResponseEntity<>(repository.save(ressourcehumainee), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
