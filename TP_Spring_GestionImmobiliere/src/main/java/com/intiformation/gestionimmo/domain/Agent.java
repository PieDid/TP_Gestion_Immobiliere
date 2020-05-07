package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


/**
 * Entity Agent immobilier
 *
 */
@Entity(name="agent")
@DiscriminatorValue("ROLE_AGENT")
public class Agent extends Personne implements Serializable{

	
	/* Propriétés */
	@OneToMany(mappedBy="agent", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contrat> contrat;
	
	@OneToMany(mappedBy="agent", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Visite> liste_visites;

	

	
	/* Constructeurs */
	public Agent(int identifiant, String nom, String tel_prive, String tel_travail) {
		super(identifiant, nom, tel_prive, tel_travail);
	}


	public Agent(int identifiant, String nom, String tel_prive, String tel_travail, List<Contrat> contrat, List<Visite> liste_visites) {
		super(identifiant, nom, tel_prive, tel_travail);
		this.contrat = contrat;
		this.liste_visites = liste_visites;
	}


	/* Méthodes */
	@Override
	public String toString() {
		return "Agent [" + super.toString() + ", contrat=" + contrat + ", liste_visites=" + liste_visites + "]";
	}


	
	
	/* Getters|Setters */
	public List<Contrat> getContrat() {
		return contrat;
	}


	public void setContrat(List<Contrat> contrat) {
		this.contrat = contrat;
	}


	public List<Visite> getListe_visites() {
		return liste_visites;
	}


	public void setListe_visites(List<Visite> liste_visites) {
		this.liste_visites = liste_visites;
	}
	
	
	
	
	
	
	/* Setter/Getters */
	

	
}
