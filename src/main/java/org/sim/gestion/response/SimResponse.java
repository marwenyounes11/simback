package org.sim.gestion.response;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sim.gestion.entity.RessourceHumaine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;



import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;


public class SimResponse  {
	
	private Long id;
	private String aff;
	private String numAppel;
	private String numAppelAbreg;
	private String modelAppareilGsm;
	private String imei1;
	private String imei2;
	private String numSerieBatterie;
	@Temporal(TemporalType.DATE) 
	private Date dateMiseEnService;
	@Temporal(TemporalType.DATE) 
	private Date dateExpiration;
	private String remarque;
	private RessourceHumaine ressourceHumaine;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAff() {
		return aff;
	}
	public void setAff(String aff) {
		this.aff = aff;
	}
	public String getNumAppel() {
		return numAppel;
	}
	public void setNumAppel(String numAppel) {
		this.numAppel = numAppel;
	}
	public String getNumAppelAbreg() {
		return numAppelAbreg;
	}
	public void setNumAppelAbreg(String numAppelAbreg) {
		this.numAppelAbreg = numAppelAbreg;
	}
	public String getModelAppareilGsm() {
		return modelAppareilGsm;
	}
	public void setModelAppareilGsm(String modelAppareilGsm) {
		this.modelAppareilGsm = modelAppareilGsm;
	}
	public String getImei1() {
		return imei1;
	}
	public void setImei1(String imei1) {
		this.imei1 = imei1;
	}
	public String getImei2() {
		return imei2;
	}
	public void setImei2(String imei2) {
		this.imei2 = imei2;
	}
	public String getNumSerieBatterie() {
		return numSerieBatterie;
	}
	public void setNumSerieBatterie(String numSerieBatterie) {
		this.numSerieBatterie = numSerieBatterie;
	}
	public Date getDateMiseEnService() {
		return dateMiseEnService;
	}
	public void setDateMiseEnService(Date dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public RessourceHumaine getRessourceHumaine() {
		return ressourceHumaine;
	}
	public void setRessourceHumaine(RessourceHumaine ressourceHumaine) {
		this.ressourceHumaine = ressourceHumaine;
	}
	public SimResponse(Long id, String aff, String numAppel, String numAppelAbreg, String modelAppareilGsm,
			String imei1, String imei2, String numSerieBatterie, Date dateMiseEnService, Date dateExpiration,
			String remarque, RessourceHumaine ressourceHumaine) {
		super();
		this.id = id;
		this.aff = aff;
		this.numAppel = numAppel;
		this.numAppelAbreg = numAppelAbreg;
		this.modelAppareilGsm = modelAppareilGsm;
		this.imei1 = imei1;
		this.imei2 = imei2;
		this.numSerieBatterie = numSerieBatterie;
		this.dateMiseEnService = dateMiseEnService;
		this.dateExpiration = dateExpiration;
		this.remarque = remarque;
		this.ressourceHumaine = ressourceHumaine;
	}
	public SimResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
