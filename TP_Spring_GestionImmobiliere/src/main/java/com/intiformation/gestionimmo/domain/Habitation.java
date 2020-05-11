package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="habitation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "code_classe", discriminatorType = DiscriminatorType.STRING)
public class Habitation extends Bien implements Serializable{

	/*_________________ props ________________*/
	
	@Column(name="superficie")
	private int superficie;

	/*_________________ ctors ________________*/
	
	public Habitation() {
		super();
	}

	public Habitation(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Visite> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, offre, prix, standard, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat);
		this.superficie = superficie;
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