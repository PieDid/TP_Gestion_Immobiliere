package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="commerce")
@DiscriminatorValue("Commerce")
@Proxy(lazy = false)
public class Commerce extends Commerciaux implements Serializable {

	/* Constructeurs */
	
	public Commerce() {
		super();
		
	}

	public Commerce(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat, superficie);
		
	}

	@Override
	public String toString() {
		return "Commerce ["+ super.toString() +"]";
	}
	
	
	
	

}
