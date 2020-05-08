package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


/**
 * table de jointure entre Agent (immobilier) et Biens
 *
 */
@Entity(name = "visite")
@Table(name = "visites")
public class Visite implements Serializable{
	
	/* Propriétés */
	
	@Id
	@Column(name = "id_visite")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_visite;
	
	@Column(name = "date")
	private String Date;
	
	@Column(name = "heure")
	private String Heure;
	
	/* Associations */

	//manytoone avec Bien
	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private Bien bien;
	
	//manytoOne avec Agent
	@ManyToOne
	@JoinColumn(name="agent_id", referencedColumnName="id_personne")
	private Agent agent;	
	
	//manytoone avec Propriétaire
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;



	/* Constructeur */
	
	public Visite() {
		super();
	}

	public Visite(String date, String heure) {
		super();
		Date = date;
		Heure = heure;
	}

	public Visite(String date, String heure, Bien bien, Agent agent, Proprietaire proprietaire) {
		super();
		Date = date;
		Heure = heure;
		this.bien = bien;
		this.agent = agent;
		this.proprietaire = proprietaire;
	}

	public Visite(int idVisite, String date, String heure, Bien bien, Agent agent, Proprietaire proprietaire) {
		super();
		this.idVisite = idVisite;
		Date = date;
		Heure = heure;
		this.bien = bien;
		this.agent = agent;
		this.proprietaire = proprietaire;
	}
	
	/* Getters et Setters */

	public int getIdVisite() {
		return idVisite;
	}

	public void setIdVisite(int idVisite) {
		this.idVisite = idVisite;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getHeure() {
		return Heure;
	}

	public void setHeure(String heure) {
		Heure = heure;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	@Override
	public String toString() {
		return "Visite [idVisite=" + idVisite + ", Date=" + Date + ", Heure=" + Heure + ", bien=" + bien + ", agent="
				+ agent + ", proprietaire=" + proprietaire + "]";
	}	
	
	
	
}
