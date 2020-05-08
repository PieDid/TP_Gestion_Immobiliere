package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.intiformation.gestionimmo.domain.Adresse;

@Entity(name="personne")
@Table(name="personnes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ROLE", discriminatorType = DiscriminatorType.STRING)
public class Personne implements Serializable{

	/*_________________ props ________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private int identifiant;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mot_de_passe")
	private String motDePasse;
	
	@Column(name="statut")
	private boolean statut;
	
	//@OneToOne(cascade = CascadeType.PERSIST)
	//@JoinColumn(name = "adresseP_id", referencedColumnName = "adressePersonne") 
	private AdressePersonne adresseP;

	
	/*_________________ ctors ________________*/
	public Personne() {
		super();
	}

	public Personne(String nom, String email, String motDePasse, boolean statut) {
		super();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.statut = statut;
	}


	public Personne(int identifiant, String nom, String email, String motDePasse, boolean statut) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.statut = statut;
	}


	public Personne(int identifiant, String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.statut = statut;
		this.adresseP = adresseP;
	}


	
	@Override
	public String toString() {
		return "Personne [identifiant=" + identifiant + ", nom=" + nom + ", email=" + email + ", motDePasse="
				+ motDePasse + ", statut=" + statut + ", adresseP=" + adresseP + "]";
	}
	
	
	
	/*__________________ G/S _________________*/
	public int getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public AdressePersonne getAdresseP() {
		return adresseP;
	}

	public void setAdresseP(AdressePersonne adresseP) {
		this.adresseP = adresseP;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	
}
