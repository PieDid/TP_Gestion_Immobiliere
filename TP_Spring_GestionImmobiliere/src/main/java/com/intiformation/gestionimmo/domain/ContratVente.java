package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;

@Entity(name="contratVente")
@DiscriminatorValue("Vente")
@Proxy(lazy = false)
public class ContratVente extends Contrat implements Serializable{

	/*_________________ props ________________*/
	
	/**
	 * pour arreter le warning ^^
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="prix")
	private double prix;
	
	@Column(name="etat")
	private String etat;

	/*_________________ ctors ________________*/
	
	/**
	 * ctor par défaut
	 */
	public ContratVente() {
		super();
	}
	
	/**
	 * ctor sans id
	 * @param date
	 * @param bien
	 * @param agent
	 * @param proprietaire
	 * @param prix
	 * @param etat
	 */
	public ContratVente(String date, Bien bien, Agent agent, Proprietaire proprietaire, Client client, double prix, String etat) {
		super(date, bien, agent, proprietaire, client);
		this.prix = prix;
		this.etat = etat;
	}

	/**
	 * ctor avec id
	 * @param idContrat
	 * @param date
	 * @param bien
	 * @param agent
	 * @param proprietaire
	 * @param prix
	 * @param etat
	 */
	public ContratVente(int idContrat, String date, Bien bien, Agent agent, Proprietaire proprietaire, Client client, double prix,
			String etat) {
		super(idContrat, date, bien, agent, proprietaire, client);
		this.prix = prix;
		this.etat = etat;
	}


	/*_________________ meths ________________*/
	
	@Override
	public String toString() {
		return "ContratVente " + super.toString() + ", prix=" + prix + ", etat=" + etat + " ]";
	}
	
	/*__________________ G/S _________________*/
	
	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
} // end class
