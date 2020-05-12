package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="administrateur")
@DiscriminatorValue("ROLE_ADMIN")
@Proxy(lazy = false)
public class Administrateur extends Personne implements Serializable{

	//ctor
	public Administrateur() {
		super();
	}
	
	public Administrateur(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP) {
		super(nom, email, motDePasse, statut, adresseP);
	}
	
	
	
	public Administrateur(int identifiant, String nom, String email, String motDePasse, boolean statut, String photo,
			AdressePersonne adresseP) {
		super(identifiant, nom, email, motDePasse, statut, photo, adresseP);

	}

	//methode
	@Override
	public String toString() {
		return "Administrateur [" + super.toString() + "]";
	}
	
}
