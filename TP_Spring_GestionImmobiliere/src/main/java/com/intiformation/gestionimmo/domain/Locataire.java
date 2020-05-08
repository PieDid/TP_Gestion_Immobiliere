package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="locataire")
@DiscriminatorValue("ROLE_LOC")
public class Locataire extends Personne implements Serializable{

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "contratLocation_id", referencedColumnName = "id_contratLocation")
	private ContratLocation contratLocation;

	
	
	/* Méthodes */
	@Override
	public String toString() {
		return "Locataire [contratLocation=" + contratLocation + "]";
	}
	
	
	
}
