package org.sim.gestion.form;


import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sim.gestion.entity.RessourceHumaine;

import com.fasterxml.jackson.annotation.JsonFormat;



public class SimForm {
	private Long id;
	private String aff;
	private String numAppel;
	private String numAppelAbreg;
	private String modelAppareilGsm;
	private String imei1;
	private String imei2;
	private String numSerieBatterie;
	private String dateMiseEnService;
	private String dateExpiration;
	private String remarque;
	private Long idressourceHumaine;
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
	public String getDateMiseEnService() {
		return dateMiseEnService;
	}
	public void setDateMiseEnService(String dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}
	public String getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	public Long getIdressourceHumaine() {
		return idressourceHumaine;
	}
	public void setIdressourceHumaine(Long idressourceHumaine) {
		this.idressourceHumaine = idressourceHumaine;
	}
	
			
	public SimForm(Long id, String aff, String numAppel, String numAppelAbreg, String modelAppareilGsm, String imei1,
			String imei2, String numSerieBatterie, String dateMiseEnService, String dateExpiration, String remarque,
			Long idressourceHumaine) {
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
		this.idressourceHumaine = idressourceHumaine;
	}
	public SimForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
