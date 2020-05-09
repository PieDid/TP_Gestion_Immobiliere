package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="administrateur")
@DiscriminatorValue("ROLE_ADMIN")
public class Administrateur extends Personne implements Serializable{

	//ctor
	public Administrateur() {
		super();
	}
	
	public Administrateur(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP) {
		super(nom, email, motDePasse, statut, adresseP);
	}
	
	
	//methode
	@Override
	public String toString() {
		return "Administrateur [" + super.toString() + "]";
	}
	
}
