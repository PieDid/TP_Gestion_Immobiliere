package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="adressePersonne")
@DiscriminatorValue("adressePersonne")
public class AdressePersonne extends Adresse implements Serializable{

	@JsonIgnore
	@OneToOne(mappedBy = "adresseP")
	private Personne personne;

	public AdressePersonne() {
		super();
	}
	
	public AdressePersonne(String rue, String codePostal, String ville) {
		super(rue, codePostal, ville);
	}

	public AdressePersonne(String rue, String codePostal, String ville, Personne personne) {
		super(rue, codePostal, ville);
		this.personne = personne;
	}

	public AdressePersonne(int idAdresse, String rue, String codePostal, String ville, Personne personne) {
		super(idAdresse, rue, codePostal, ville);
		this.personne = personne;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "AdressePersonne [personne=" + personne + ", toString()=" + super.toString() + "]";
	}

}
