package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;


/**
 * table de jointure entre Agent (immobilier) et Biens
 *
 */
@Entity(name = "visite")
@Table(name = "visites")
@Proxy(lazy = false)
public class Visite implements Serializable{
	
	/* Propriétés */
	
	@Id
	@Column(name = "id_visite")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_visite;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "heure")
	private String heure;
	
	/* Associations */

	//manytoone avec Bien
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private Bien bien;
	
	//manytoOne avec Agent
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="agent_id", referencedColumnName="id_personne")
	private Agent agent;	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_personne")
	private Client client;
	
	//manytoone avec Propriétaire
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;



	/* Constructeur */
	
	public Visite() {
		super();
	}

	public Visite(String date, String heure) {
		super();
		this.date = date;
		this.heure = heure;
	}

	public Visite(Agent agent, Bien bien, Client client, String date, String heure, Proprietaire proprietaire) {
		super();
		this.date = date;
		this.heure = heure;
		this.bien = bien;
		this.agent = agent;
		this.client = client;
		this.proprietaire = proprietaire;
	}

	public Visite(int idVisite, Agent agent, Bien bien, Client client, String date, String heure, Proprietaire proprietaire) {
		super();
		this.id_visite = idVisite;
		this.date = date;
		this.heure = heure;
		this.bien = bien;
		this.agent = agent;
		this.client = client;
		this.proprietaire = proprietaire;
	}
	
	/* Getters et Setters */

	public int getIdVisite() {
		return id_visite;
	}

	public void setIdVisite(int idVisite) {
		this.id_visite = idVisite;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
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
		return "Visite [idVisite=" + id_visite + ", Date=" + date + ", Heure=" + heure + ", bien=" + bien + ", agent="
				+ agent + ", proprietaire=" + proprietaire + "]";
	}	
	
	
	
}
