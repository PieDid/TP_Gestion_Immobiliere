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
	
	@Column(name="statut")
	private String statut;
	
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

	public Bien(String statut, String standad, AdresseBien adresseBien, String dateSoumission, String dateDisposition,
			int revenu, List<Client> listeVisiteurs, Contrat contrat) {
		super();
		this.statut = statut;
		this.standad = standad;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getStandad() {
		return standad;
	}

	public void setStandad(String standad) {
		this.standad = standad;
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
		return "Biens [id_bien=" + id_bien + ", statut=" + statut + ", standad=" + standad + ", adresseBien="
				+ adresseBien + ", dateSoumission=" + dateSoumission + ", dateDisposition=" + dateDisposition
				+ ", revenu=" + revenu + ", listeVisiteurs=" + listeVisite + ", contrat=" + contrat + "]";
	}
	
	
}
