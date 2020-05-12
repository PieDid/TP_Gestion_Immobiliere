package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="entrepot")
@DiscriminatorValue("Entrepot")
@Proxy(lazy = false)
public class Entrepot extends Commerciaux implements Serializable{

	/* Constructeurs */
	
	public Entrepot() {
		super();

	}

	public Entrepot(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat, superficie);
	}
	
	
	public Entrepot(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<String> listePhoto, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listePhoto, listeVisiteurs, contrat, superficie);
	}
	

	@Override
	public String toString() {
		return "Entrepot [" + super.toString() + "]";
	}
	
	


	
	
	
}
