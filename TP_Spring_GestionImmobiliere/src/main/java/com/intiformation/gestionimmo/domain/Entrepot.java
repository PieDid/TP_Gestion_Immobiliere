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

	public Entrepot(String statut, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Client> listeVisiteurs, Contrat contrat, int nbPieces,
			int superficie) {
		super(statut, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat, nbPieces,
				superficie);
	}

	@Override
	public String toString() {
		return "Entrepot [" + super.toString() + "]";
	}
	
	


	
	
	
}
