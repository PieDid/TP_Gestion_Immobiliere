package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="client")
@DiscriminatorValue("ROLE_CLIENT")
@Proxy(lazy = false)
public class Client extends Personne implements Serializable{

	//prop
	@JsonIgnore
	@OneToMany(mappedBy="client", cascade= CascadeType.ALL)
	private List<Visite> liste_visites;

	@JsonIgnore
	@OneToMany(mappedBy="client", cascade= CascadeType.ALL)
	private List<Contrat> liste_contrats;
	
	
	
	
	
	//ctor
	public Client() {
		super();
		
	}
	
	public Client(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP, List<Visite> liste_visites, List<Contrat> liste_contrats) {
		super(nom, email, motDePasse, statut, adresseP);
		this.liste_visites = liste_visites;
		this.liste_contrats = liste_contrats;
		
	}
	
	public Client(String nom, String email, String motDePasse, boolean statut, String photo, AdressePersonne adresseP, List<Visite> liste_visites, List<Contrat> liste_contrats) {
		super(nom, email, motDePasse, statut, photo, adresseP);
		this.liste_visites = liste_visites;
		this.liste_contrats = liste_contrats;
		
	}




	//méthodes
	@Override
	public String toString() {
		return "Client [" + super.toString() + ", liste_visites=" + liste_visites + ", liste_contrats=" + liste_contrats + "]";
	}




	//getters|setters
	public List<Visite> getListe_visites() {
		return liste_visites;
	}

	public void setListe_visites(List<Visite> liste_visites) {
		this.liste_visites = liste_visites;
	}

	public List<Contrat> getListe_contrats() {
		return liste_contrats;
	}

	public void setListe_contrats(List<Contrat> liste_contrats) {
		this.liste_contrats = liste_contrats;
	}
	
	
	
	
	
	
}
