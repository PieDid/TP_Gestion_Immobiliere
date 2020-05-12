package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe mère de ContratVente et de ContratLocation
 *
 */

@Entity(name = "contrat")
@Table(name="contrats")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_contrat", discriminatorType=DiscriminatorType.STRING)
@Proxy(lazy = false)
public class Contrat implements Serializable{

	/*_________________ props ________________*/
	
	/**
	 * pour arreter le warning ^^
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contrat")
	private int idContrat;
	
	@Column(name = "date")
	private String date;
	
	@JsonIgnore
	@OneToOne(mappedBy="contrat")
	private Bien bien;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="agent_id", referencedColumnName="id_personne")
	private Agent agent;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="proprietaire_id", referencedColumnName="id_personne")
	private Proprietaire proprietaire;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName="id_personne")
	private Client client;
	
	
	/*_________________ ctors ________________*/
	
	/**
	 * ctor vide 
	 */
	public Contrat() {}
	
	/**
	 * ctor sans id
	 * @param date
	 * @param bien
	 * @param agent
	 * @param proprietaire
	 */
	public Contrat(String date, Bien bien, Agent agent, Proprietaire proprietaire, Client client) {
		super();
		this.date = date;
		this.bien = bien;
		this.agent = agent;
		this.proprietaire = proprietaire;
		this.client = client;
	}

	/**
	 * ctor avec id
	 * @param idContrat
	 * @param date
	 * @param bien
	 * @param agent
	 * @param proprietaire
	 */
	public Contrat(int idContrat, String date, Bien bien, Agent agent, Proprietaire proprietaire, Client client) {
		super();
		this.idContrat = idContrat;
		this.date = date;
		this.bien = bien;
		this.agent = agent;
		this.proprietaire = proprietaire;
		this.client = client;
	}


	/*_________________ meths ________________*/
	

	/**
	 * sera appelé et complété dans les classes filles
	 */
	@Override
	public String toString() {
		return "Contrat [idContrat=" + idContrat + ", date=" + date + ", bien=" + bien + ", agent=" + agent
				+ ", proprietaire=" + proprietaire + ", client=" + client + "]";
	}

	/*__________________ G/S _________________*/
	
	
	public int getIdContrat() {
		return idContrat;
	}

	public void setIdContrat(int idContrat) {
		this.idContrat = idContrat;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
} // end class
