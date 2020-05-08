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

	public Habitation(String statut, String standad, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Client> listeVisiteurs, Contrat contrat, int superficie) {
		super(statut, standad, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat);
		this.superficie = superficie;
	}
	
	/*_________________ meths ________________*/

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	

	
}
