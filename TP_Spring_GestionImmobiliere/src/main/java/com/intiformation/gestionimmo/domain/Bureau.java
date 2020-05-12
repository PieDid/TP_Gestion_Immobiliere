package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="bureau")
@DiscriminatorValue("Bureau")
@Proxy(lazy = false)
public class Bureau extends Commerciaux implements Serializable{
	
	/* Constructeurs */

	public Bureau() {
		super();
	}

	public Bureau(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission, String dateDisposition,
			int revenu, List<String> listePhoto, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listePhoto, listeVisiteurs, contrat, superficie);
	}

	@Override
	public String toString() {
		return "Bureau ["+ super.toString() +"]";
	}
	
	
	
	
	

}
