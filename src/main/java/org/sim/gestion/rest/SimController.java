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
import org.sim.gestion.entity.Sim;
import org.sim.gestion.form.SimForm;
import org.sim.gestion.repository.RessourceHumaineRepository;
import org.sim.gestion.repository.SimRepository;
import org.sim.gestion.response.SimResponse;
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
public class SimController {
	@Autowired
	SimRepository repository;
	@Autowired
	RessourceHumaineRepository rrepository;
	
	
	 @GetMapping("/listsims")
	  public List<SimResponse> getAllSims() {
	   return repository.listSim();
	  }
	@GetMapping("/sims/{id}")
	public ResponseEntity<Sim> getSimById(@PathVariable(value = "id") Long simId)
			throws ResourceNotFoundException {
		Sim sim = repository.findById(simId)
				.orElseThrow(() -> new ResourceNotFoundException("Sim not found for this id :: " + simId));
		return ResponseEntity.ok().body(sim);
	}
	@PostMapping("/addsims" )
	public Sim createSim( @RequestBody SimForm simForm) throws ParseException {
		DateFormat df1= new SimpleDateFormat("yyyy-MM-dd");
		  Long idressourceHumaine =simForm.getIdressourceHumaine(); 
		    RessourceHumaine ressourceHumaine = rrepository.findById(idressourceHumaine).orElse(null); 
		Sim sim = new Sim();
		sim.setAff(simForm.getAff());
        sim.setNumAppel(simForm.getNumAppel());
        sim.setNumAppelAbreg(simForm.getNumAppelAbreg());
        sim.setModelAppareilGsm(simForm.getModelAppareilGsm());
        sim.setImei1(simForm.getImei1());
        sim.setImei2(simForm.getImei2());
        sim.setNumSerieBatterie(simForm.getNumSerieBatterie());
        if(simForm.getDateMiseEnService()!=null) {
        sim.setDateMiseEnService(df1.parse(simForm.getDateMiseEnService()));
        }
        if(simForm.getDateExpiration()!=null) {
		sim.setDateExpiration(df1.parse(simForm.getDateExpiration()));
        }
        sim.setRemarque(simForm.getRemarque());
        sim.setRessourceHumaine(ressourceHumaine);
		return repository.save(sim);
	}
	
	@DeleteMapping("/deletesims/{id}")
	public Map<String, Boolean> deleteSim(@PathVariable(value = "id") Long simId)
			throws ResourceNotFoundException {
		Sim sim = repository.findById(simId)
				.orElseThrow(() -> new ResourceNotFoundException("Sim not found  id :: " + simId));

		repository.delete(sim);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	  
	  @DeleteMapping("/sims/delete")
	  public ResponseEntity<String> deleteAllSims() {
	    System.out.println("Delete All Sims...");
	 
	    repository.deleteAll();
	 
	    return new ResponseEntity<>("All Sims have been deleted!", HttpStatus.OK);
	  }
	 
	
	  @PutMapping("/editsims/{id}")
	  public ResponseEntity<Sim> updateSim(@PathVariable("id") long id,@RequestBody SimForm simForm) throws ParseException {
	    System.out.println("Update Sim with ID = " + id + "...");
	    Long idressourceHumaine =simForm.getIdressourceHumaine(); 
	    RessourceHumaine ressourceHumaine = rrepository.findById(idressourceHumaine).orElse(null); 
	    Optional<Sim> simInfo = repository.findById(id);
	    DateFormat df1= new SimpleDateFormat("yyyy-MM-dd");
	    if (simInfo.isPresent()) {
	    	Sim sim = simInfo.get();
	    	sim.setAff(simForm.getAff());
	        sim.setNumAppel(simForm.getNumAppel());
	        sim.setNumAppelAbreg(simForm.getNumAppelAbreg());
	        sim.setModelAppareilGsm(simForm.getModelAppareilGsm());
	        sim.setImei1(simForm.getImei1());
	        sim.setImei2(simForm.getImei2());
	        sim.setNumSerieBatterie(simForm.getNumSerieBatterie());
	        if(simForm.getDateMiseEnService()!=null) {
	            sim.setDateMiseEnService(df1.parse(simForm.getDateMiseEnService()));
	            }
	       if(simForm.getDateExpiration()!=null) {
	    		sim.setDateExpiration(df1.parse(simForm.getDateExpiration()));
	            }
	        sim.setRemarque(simForm.getRemarque());
	        sim.setRessourceHumaine(ressourceHumaine);
	      return new ResponseEntity<>(repository.save(sim), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
