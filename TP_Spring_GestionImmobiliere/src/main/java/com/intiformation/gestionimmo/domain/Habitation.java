package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;

@Entity(name="habitation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "code_classe", discriminatorType = DiscriminatorType.STRING)
@Proxy(lazy = false)
public class Habitation extends Bien implements Serializable{

	/*_________________ props ________________*/
	
	@Column(name="superficie")
	private int superficie;
	
	@Column(name="nombre_pieces")
	private int nbPieces;

	/*_________________ ctors ________________*/
	
	public Habitation() {
		super();
	}

	public Habitation(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat, int superficie, int nbPieces) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat);
		this.superficie = superficie;
		this.nbPieces = nbPieces;
	}
	
	public Habitation(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<String> listePhoto, List<Visite> listeVisiteurs, Contrat contrat, int superficie, int nbPieces) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listePhoto, listeVisiteurs, contrat);
		this.superficie = superficie;
		this.nbPieces = nbPieces;
	}
	
	/*_________________ meths ________________*/

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "Habitation [" + super.toString() + ", superficie=" + superficie + "]";
	}
	

	
}