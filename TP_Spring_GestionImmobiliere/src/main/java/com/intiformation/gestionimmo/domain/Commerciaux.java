package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="commerciaux")
@DiscriminatorValue("Commerciaux")
public class Commerciaux extends Bien implements Serializable{

	/* Propriétés */
	
	@Column(name="nombre_pieces")
	private int nbPieces;
	
	@Column(name="superficie")
	private int superficie;
	
	
	/* Constructeurs */

	public Commerciaux() {
		super();
	}
	

	public Commerciaux(String statut, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Client> listeVisiteurs, Contrat contrat, int nbPieces,
			int superficie) {
		super(statut, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat);
		this.nbPieces = nbPieces;
		this.superficie = superficie;
	}


	/* Setters et Getters */

	public int getNbPieces() {
		return nbPieces;
	}


	public void setNbPieces(int nbPieces) {
		this.nbPieces = nbPieces;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	@Override
	public String toString() {
		return "Commerciaux [nbPieces=" + nbPieces + ", superficie=" + superficie + "]";
	}
	
	
	

	
	
	
	
}
