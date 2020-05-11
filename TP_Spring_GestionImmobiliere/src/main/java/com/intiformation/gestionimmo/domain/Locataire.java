package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="locataire")
@DiscriminatorValue("ROLE_LOC")
public class Locataire extends Personne implements Serializable{

	@JsonIgnore
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "contratLocation_id", referencedColumnName = "id_contrat")
	private ContratLocation contratLocation;

	
	//ctor
	public Locataire() {
		super();
	}
	
	
	
	
	public Locataire(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP, ContratLocation contratLocation) {
		super(nom, email, motDePasse, statut, adresseP);
		this.contratLocation = contratLocation;
	}




	/* Méthodes */
	@Override
	public String toString() {
		return "Locataire [" + super.toString() + ", contratLocation=" + contratLocation + "]";
	}


	
	//getters|setters
	public ContratLocation getContratLocation() {
		return contratLocation;
	}

	public void setContratLocation(ContratLocation contratLocation) {
		this.contratLocation = contratLocation;
	}
	
	
	
	
}
