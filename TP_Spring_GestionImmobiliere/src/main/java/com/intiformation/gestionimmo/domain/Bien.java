package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity(name="bien")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Bien implements Serializable{
	/*_________________ props ________________*/
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment
	@Column(name="id_bien")
	private int id_bien;
	
	//boolean disponible ? true ou false
	@Column(name="statut")
	private boolean statut;
	
	//type d'offre (location ou vente)
	@Column(name="offre")
	private String offre;
	
	//Le prix proposé du bien (négociable plus tard avec les potentiels clients)
	@Column(name="prix")
	private double prix;
	
	@Column(name="standard")
	private String standard;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "adresse_id", referencedColumnName = "id_adresse")
	private AdresseBien adresseBien;
	
	@Column(name="dateSoumission")
	private String dateSoumission;
	
	@Column(name="dateDisposition")
	private String dateDisposition;
	
	@Column(name="revenu")
	private int revenu;
	
	@OneToMany(mappedBy = "biens", cascade = CascadeType.ALL)
	private List<Visite > listeVisite;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "contrat_id", referencedColumnName = "id_contrat")
	private Contrat contrat;
	
	/*_________________ ctors ________________*/
	

	public Bien() {
		super();
	}

	public Bien(boolean statut, String offre, double prix, String standard, AdresseBien adresseBien, String dateSoumission, String dateDisposition,
			int revenu, List<Client> listeVisiteurs, Contrat contrat) {
		super();
		this.statut = statut;
		this.offre = offre;
		this.prix = prix;
		this.standard = standard;
		this.adresseBien = adresseBien;
		this.dateSoumission = dateSoumission;
		this.dateDisposition = dateDisposition;
		this.revenu = revenu;
		this.listeVisite = listeVisite;
		this.contrat = contrat;
	}

	/*_________________ meths ________________*/
	
	public int getId_bien() {
		return id_bien;
	}

	public void setId_bien(int id_bien) {
		this.id_bien = id_bien;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getOffre() {
		return offre;
	}

	public void setOffre(String offre) {
		this.offre = offre;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standad) {
		this.standard = standad;
	}

	public AdresseBien getAdresseBien() {
		return adresseBien;
	}

	public void setAdresseBien(AdresseBien adresseBien) {
		this.adresseBien = adresseBien;
	}

	public String getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(String dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public String getDateDisposition() {
		return dateDisposition;
	}

	public void setDateDisposition(String dateDisposition) {
		this.dateDisposition = dateDisposition;
	}

	public int getRevenu() {
		return revenu;
	}

	public void setRevenu(int revenu) {
		this.revenu = revenu;
	}


	public List<Visite> getListeVisite() {
		return listeVisite;
	}

	public void setListeVisite(List<Visite> listeVisite) {
		this.listeVisite = listeVisite;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

	@Override
	public String toString() {
		return "Bien [id_bien=" + id_bien + ", statut=" + statut + ", offre=" + offre + ", prix=" + prix + ", standard="
				+ standard + ", adresseBien=" + adresseBien + ", dateSoumission=" + dateSoumission
				+ ", dateDisposition=" + dateDisposition + ", revenu=" + revenu + ", listeVisite=" + listeVisite
				+ ", contrat=" + contrat + "]";
	}
	
	
}
