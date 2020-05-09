package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="entrepot")
@DiscriminatorValue("Entrepot")
public class Entrepot extends Commerciaux implements Serializable{

	/* Constructeurs */
	
	public Entrepot() {
		super();

	}

	public Entrepot(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Client> listeVisiteurs, Contrat contrat, int nbPieces,
			int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat, nbPieces,
				superficie);
	}

	@Override
	public String toString() {
		return "Entrepot [" + super.toString() + "]";
	}
	
	


	
	
	
}
