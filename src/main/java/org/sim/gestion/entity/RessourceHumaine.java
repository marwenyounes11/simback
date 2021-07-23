package org.sim.gestion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class RessourceHumaine implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String division;
	private String service;
	private String matricule;
	private String ref;
	@OneToMany(mappedBy = "ressourceHumaine",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch=FetchType.EAGER)
	Set<Sim> sims;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public Set<Sim> getSims() {
		return sims;
	}
	public void setSims(Set<Sim> sims) {
		this.sims = sims;
	}
	
	public RessourceHumaine(Long id, String nom, String prenom, String division, String service, String matricule,
			String ref, Set<Sim> sims) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.division = division;
		this.service = service;
		this.matricule = matricule;
		this.ref = ref;
		this.sims = sims;
	}
	public RessourceHumaine() {
		super();
		// TODO Auto-generated constructor stub
	}	 
	
	
}
