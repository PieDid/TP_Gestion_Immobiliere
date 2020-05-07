package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity(name="client")
@DiscriminatorValue("ROLE_CLIENT")
public class Client extends Personne implements Serializable{

	@OneToMany(mappedBy="client", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Visite> liste_visites;

	
	/* Méthodes */
	@Override
	public String toString() {
		return "Client [" + super.toString() + ", liste_visites=" + liste_visites + "]";
	}
	
	
	
}
