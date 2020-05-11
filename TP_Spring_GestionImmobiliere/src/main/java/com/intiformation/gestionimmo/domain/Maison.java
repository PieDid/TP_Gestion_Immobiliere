package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="maison")
@DiscriminatorValue("Maison")
public class Maison extends Habitation implements Serializable{

	public Maison() {
		super();
	}

	public Maison(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat,
			int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat,
				superficie);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
