package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="adresseBien")
@DiscriminatorValue("adresseBien")
public class AdresseBien extends Adresse implements Serializable{

	@JsonIgnore
	@OneToOne(mappedBy = "adresseBien")
	private Bien bien;

	public AdresseBien() {
		super();
	}
	
	public AdresseBien(String rue, String codePostal, String ville) {
		super(rue, codePostal, ville);
	}

	public AdresseBien(String rue, String codePostal, String ville, Bien bien) {
		super(rue, codePostal, ville);
		this.bien = bien;
	}

	public AdresseBien(int idAdresse, String rue, String codePostal, String ville, Bien bien) {
		super(idAdresse, rue, codePostal, ville);
		this.bien = bien;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	@Override
	public String toString() {
		return "AdresseBien [bien=" + bien + ", toString()=" + super.toString() + "]";
	}
	
		
}
