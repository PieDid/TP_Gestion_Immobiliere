package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="contratLocation")
@DiscriminatorValue("Location")
public class ContratLocation extends Contrat implements Serializable{

	/*_________________ props ________________*/
	
	@Column(name = "caution")
	private double caution;
	
	@Column(name = "loyer")
	private double loyer;
	
	@Column(name = "charge")
	private double charge;
	
	@Column(name = "type_bail")
	private String typeBail;
	
	@Column(name = "garniture")
	private String garniture;

	/*_________________ ctors ________________*/
	
	/**
	 * ctor par défaut
	 */
	public ContratLocation() {
		super();
	}
	
	/**
	 * ctor sans Id
	 * @param date
	 * @param bien
	 * @param agent
	 * @param caution
	 * @param loyer
	 * @param charge
	 * @param typeBail
	 * @param garniture
	 */
	public ContratLocation(String date, Bien bien, Agent agent, double caution, double loyer, double charge,
			String typeBail, String garniture) {
		super(date, bien, agent);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}
	
	/**
	 * ctor avec id
	 * @param idContrat
	 * @param date
	 * @param bien
	 * @param agent
	 * @param caution
	 * @param loyer
	 * @param charge
	 * @param typeBail
	 * @param garniture
	 */
	public ContratLocation(int idContrat, String date, Bien bien, Agent agent, double caution, double loyer,
			double charge, String typeBail, String garniture) {
		super(idContrat, date, bien, agent);
		this.caution = caution;
		this.loyer = loyer;
		this.charge = charge;
		this.typeBail = typeBail;
		this.garniture = garniture;
	}


	/*_________________ meths ________________*/
	
	@Override
	public String toString() {
		return "ContratLocation " + super.toString() + ", caution=" + caution + ", loyer=" + loyer + ", charge=" + charge + ", typeBail="
				+ typeBail + ", garniture=" + garniture + " ]";
	}

	/*__________________ G/S _________________*/
	

	public double getCaution() {
		return caution;
	}

	public void setCaution(double caution) {
		this.caution = caution;
	}

	public double getLoyer() {
		return loyer;
	}

	public void setLoyer(double loyer) {
		this.loyer = loyer;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(String typeBail) {
		this.typeBail = typeBail;
	}

	public String getGarniture() {
		return garniture;
	}

	public void setGarniture(String garniture) {
		this.garniture = garniture;
	}
	
} // end class
