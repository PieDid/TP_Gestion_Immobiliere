package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="terrain")
public class Terrain extends Bien implements Serializable{

	/*_________________ props ________________*/
	@Column(name="superficie")
	private int superficie;
	
	/*_________________ ctors ________________*/
	public Terrain() {
		super();
	}

	/*_______________ ctor _______________*/
	public Terrain(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, listeVisiteurs, contrat);
		this.superficie = superficie;
	}

	
	/*_______________ getters|setters _______________*/
	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	
	/*_______________ Méthodes _______________*/
	@Override
	public String toString() {
		return "Terrain [" + super.toString() + ", superficie=" + superficie + "]";
	}
	
	
}
