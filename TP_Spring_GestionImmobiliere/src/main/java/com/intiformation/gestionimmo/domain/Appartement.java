package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="appartement")
@DiscriminatorValue("Appartement")
public class Appartement extends Habitation implements Serializable{

	/*    ctor     */
	public Appartement() {
		super();

	}

	public Appartement(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<Client> listeVisiteurs, Contrat contrat,
			int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat,
				superficie);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
