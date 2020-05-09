package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intiformation.gestionimmo.domain.Adresse;

@Entity(name="proprietaire")
@DiscriminatorValue("ROLE_PROP")
public class Proprietaire extends Personne implements Serializable{


	/* Propriétés */
	@Column(name="tel_prive")
	private String tel_prive;
	
	@Column(name="tel_travail")
	private String tel_travail;

	@JsonIgnore
	@OneToMany(mappedBy="proprietaire", cascade= CascadeType.ALL)
	private List<Bien> liste_biens = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="proprietaire", cascade= CascadeType.ALL)
	private List<ContratVente> liste_contratsVente = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="proprietaire", cascade= CascadeType.ALL)
	private List<ContratLocation> liste_contratsLocation = new ArrayList<>();

	
	
	
	/* Constructeurs */
	public Proprietaire() {
		super();
	}
	
	public Proprietaire(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP, List<Visite> liste_visites, String tel_prive, String tel_travail) {
		super(nom, email, motDePasse, statut, adresseP);
		this.tel_prive = tel_prive;
		this.tel_travail = tel_travail;
	}

	public Proprietaire(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP, List<Visite> liste_visites, String tel_prive, String tel_travail, List<Bien> liste_biens) {
		super(nom, email, motDePasse, statut, adresseP);
		this.tel_prive = tel_prive;
		this.tel_travail = tel_travail;
		this.liste_biens = liste_biens;
	}

	public Proprietaire(String nom, String email, String motDePasse, boolean statut, AdressePersonne adresseP, List<Visite> liste_visites, String tel_prive, String tel_travail, List<Bien> liste_biens,
			List<ContratVente> liste_contratsVente, List<ContratLocation> liste_contratsLocation) {
		super(nom, email, motDePasse, statut, adresseP);
		this.tel_prive = tel_prive;
		this.tel_travail = tel_travail;
		this.liste_biens = liste_biens;
		this.liste_contratsVente = liste_contratsVente;
		this.liste_contratsLocation = liste_contratsLocation;
	}


	
	/* Méthodes */
	@Override
	public String toString() {
		return "Proprietaire [" + super.toString() + ", tel_prive=" + tel_prive + ", tel_travail=" + tel_travail + ", liste_biens=" + liste_biens
				+ ", liste_contratsVente=" + liste_contratsVente + ", liste_contratsLocation=" + liste_contratsLocation
				+ "]";
	}


	
	/* Getters|Setters */
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


	public List<Bien> getListe_biens() {
		return liste_biens;
	}
	public void setListe_biens(List<Bien> liste_biens) {
		this.liste_biens = liste_biens;
	}


	public List<ContratVente> getListe_contratsVente() {
		return liste_contratsVente;
	}
	public void setListe_contratsVente(List<ContratVente> liste_contratsVente) {
		this.liste_contratsVente = liste_contratsVente;
	}


	public List<ContratLocation> getListe_contratsLocation() {
		return liste_contratsLocation;
	}
	public void setListe_contratsLocation(List<ContratLocation> liste_contratsLocation) {
		this.liste_contratsLocation = liste_contratsLocation;
	}
	
	
}
