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
	
	@Column(name="tel_prive")
	private String tel_prive;
	
	@Column(name="tel_travail")
	private String tel_travail;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "adresseP_id", referencedColumnName = "adressePersonne") 
	private AdressePersonne adresseP;

	
	/*_________________ ctors ________________*/
	public Personne() {
		super();
	}


	public Personne(String nom, String tel_prive, String tel_travail) {
		super();
		this.nom = nom;
		this.tel_prive = tel_prive;
		this.tel_travail = tel_travail;
	}


	public Personne(int identifiant, String nom, String tel_prive, String tel_travail) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.tel_prive = tel_prive;
		this.tel_travail = tel_travail;
	}


	public Personne(int identifiant, String nom, String tel_prive, String tel_travail, AdressePersonne adresseP) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.tel_prive = tel_prive;
		this.tel_travail = tel_travail;
		this.adresseP = adresseP;
	}


	
	/*_______________ Méthodes _______________*/
	@Override
	public String toString() {
		return "Personne [identifiant=" + identifiant + ", nom=" + nom + ", tel_prive=" + tel_prive + ", tel_travail="
				+ tel_travail + ", adresseP=" + adresseP + "]";
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

	public String getTel_prive() {
		return tel_prive;
	}

	public void setTel_prive(String tel_prive) {
		this.tel_prive = tel_prive;
	}

	public String getTel_travail() {
		return tel_travail;
	}

	public void setTel_travail(String tel_travail) {
		this.tel_travail = tel_travail;
	}

	public AdressePersonne getAdresseP() {
		return adresseP;
	}

	public void setAdresseP(AdressePersonne adresseP) {
		this.adresseP = adresseP;
	}
	
	
}
