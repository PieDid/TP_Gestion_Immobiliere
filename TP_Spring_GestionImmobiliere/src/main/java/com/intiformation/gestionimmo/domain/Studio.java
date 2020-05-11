package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="studio")
@DiscriminatorValue("Studio")
public class Studio extends Habitation implements Serializable{

	/*_________________ ctors ________________*/
	public Studio() {
		super();
	}

	public Studio(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien,
			String dateSoumission, String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat,
			int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat,
				superficie);
		// TODO Auto-generated constructor stub
	}

	
	
}
