package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Entity Agent immobilier
 *
 */
@Entity(name="agent")
@DiscriminatorValue("ROLE_AGENT")
@Proxy(lazy = false)
public class Agent extends Personne implements Serializable{

	
	/* Propriétés */
	@JsonIgnore
	@OneToMany(mappedBy="agent", cascade= CascadeType.ALL)
	private List<Visite> liste_visites;

	@JsonIgnore
	@OneToMany(mappedBy="agent", cascade= CascadeType.ALL)
	private List<Contrat> liste_contrats;
	

	
	/* Constructeurs */
	
	public Agent(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP) {
		super(nom, email, motDePasse, statut, adresseP);
	}

	public Agent() {
		super();
	}

	public Agent(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP, List<Contrat> liste_contrats, List<Visite> liste_visites) {
		super(nom, email, motDePasse, statut, adresseP);
		this.liste_contrats = liste_contrats;
		this.liste_visites = liste_visites;
	}

	public Agent(String nom, String email, String motDePasse, boolean statut, String photo, AdressePersonne adresseP, List<Contrat> liste_contrats, List<Visite> liste_visites) {
		super(nom, email, motDePasse, statut, adresseP);
		this.liste_contrats = liste_contrats;
		this.liste_visites = liste_visites;
	}
	
	

	/* Méthodes */
	@Override
	public String toString() {
		return "Agent [" + super.toString() + ", liste_contrats=" + liste_contrats + ", liste_visites=" + liste_visites + "]";
	}


	
	
	/* Getters|Setters */
	public List<Contrat> getListe_contrats() {
		return liste_contrats;
	}
	public void setListe_contrats(List<Contrat> liste_contrats) {
		this.liste_contrats = liste_contrats;
	}


	public List<Visite> getListe_visites() {
		return liste_visites;
	}
	public void setListe_visites(List<Visite> liste_visites) {
		this.liste_visites = liste_visites;
	}
	
	
}
