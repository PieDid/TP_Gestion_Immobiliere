package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="bureau")
@DiscriminatorValue("Bureau")
public class Bureau extends Commerciaux implements Serializable{
	
	/* Constructeurs */

	public Bureau() {
		super();
	}

	public Bureau(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission, String dateDisposition,
			int revenu, List<Visite> listeVisiteurs, Contrat contrat, int nbPieces, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat, nbPieces,
				superficie);
	}

	@Override
	public String toString() {
		return "Bureau ["+ super.toString() +"]";
	}
	
	
	
	
	

}
