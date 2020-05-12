package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="commerciaux")
@DiscriminatorValue("Commerciaux")
@Proxy(lazy = false)
public class Commerciaux extends Bien implements Serializable{

	/* Propriétés */
	
	@Column(name="superficie")
	private int superficie;
	
	
	/* Constructeurs */

	public Commerciaux() {
		super();
	}
	

	public Commerciaux(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat);
		this.superficie = superficie;
	}
	
//	public Commerciaux(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
//			String dateDisposition, int revenu, List<String> listePhoto, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
//		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listePhoto, listeVisiteurs, contrat);
//		this.superficie = superficie;
//	}


	/* Setters et Getters */


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	@Override
	public String toString() {
		return "Commerciaux [" + super.toString() + ", superficie=" + superficie + "]";
	}
	
	
	

	
	
	
	
}
