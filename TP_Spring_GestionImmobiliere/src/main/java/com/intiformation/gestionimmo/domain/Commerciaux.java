package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="commerciaux")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name = "code_classe", discriminatorType = DiscriminatorType.STRING)
public class Commerciaux extends Bien implements Serializable{
	
	/*_________________ props ________________*/
	private int surface;

	/*_________________ ctors ________________*/
	
	
	
	public Commerciaux(String statut, String standad, AdresseBien adresseBien, String dateSoumission,
			String dateDisposition, int revenu, List<Client> listeVisiteurs, Contrat contrat, int surface) {
		super(statut, standad, adresseBien, dateSoumission, dateDisposition, revenu, listeVisiteurs, contrat);
		this.surface = surface;
	}

	public Commerciaux() {
		super();
	}

	/*_________________ meths ________________*/
	
	public int getSurface() {
		return surface;
	}

	
	public void setSurface(int surface) {
		this.surface = surface;
	}
	
	
	
	
	
	

}
