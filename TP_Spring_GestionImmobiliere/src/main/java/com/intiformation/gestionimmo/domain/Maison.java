package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="maison")
@DiscriminatorValue("Maison")
@Proxy(lazy = false)
public class Maison extends Habitation implements Serializable{

	public Maison() {
		super();
	}

	public Maison(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat,
			int superficie, int nbPieces) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat,
				superficie, nbPieces);
	}
	
	public Maison(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<String> listePhoto, List<Visite> listeVisiteurs, Contrat contrat,
			int superficie, int nbPieces) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listePhoto, listeVisiteurs, contrat,
				superficie, nbPieces);
	}
	
	
}
