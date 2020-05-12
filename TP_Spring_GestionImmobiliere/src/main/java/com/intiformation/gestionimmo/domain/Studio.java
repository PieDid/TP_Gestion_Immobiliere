package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity(name="studio")
@DiscriminatorValue("Studio")
@Proxy(lazy = false)
public class Studio extends Habitation implements Serializable{

	/*_________________ ctors ________________*/
	public Studio() {
		super();
	}

	public Studio(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat,
			int superficie, int nbPieces) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat,
				superficie, nbPieces);
	}
	
	public Studio(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<String> listePhoto, List<Visite> listeVisiteurs, Contrat contrat,
			int superficie, int nbPieces) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listePhoto, listeVisiteurs, contrat,
				superficie, nbPieces);
	}

	
	
}
