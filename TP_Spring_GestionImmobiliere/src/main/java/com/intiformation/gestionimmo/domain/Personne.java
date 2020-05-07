package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.intiformation.gestionimmo.domain.Adresse;

@Entity(name="personne")
@Table(name="personnes")
public class Personne implements Serializable{

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

	@OneToMany(mappedBy="proprietaire", cascade= CascadeType.ALL)
	private List<Bien> liste_biens = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "adresseP_id", referencedColumnName = "id_adresseP") 
	private AdressePersonne adresseP;
	
	
	
}
