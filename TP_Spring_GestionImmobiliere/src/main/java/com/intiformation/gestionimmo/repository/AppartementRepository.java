package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Appartement;

public interface AppartementRepository extends JpaRepository<Appartement, Integer>{

	/**
	 *  > Les méthodes de base de JpaRepository (opérations CRUD)
	 *    --------------------------------------------------------
	 *    		-> findAll
	 *    		-> save
	 *    		-> findById
	 *    		-> delete
	 *    		-> getOne + save => update
	 *    		-> count
	 */
	
	@Query("SELECT h FROM appartement h WHERE h.id_bien = ?1")
	public Appartement getAppartementById(int idCommerciaux);
	
	@Query("SELECT h FROM appartement h WHERE h.statut = ?1")
	public Appartement getAppartementByStatut (boolean statut);
	
	@Query("SELECT h FROM appartement h WHERE h.offre = ?1")
	public List<Appartement> getAppartementByOffre (String offre);
	
	@Query("SELECT h FROM appartement h WHERE h.prix <= ?1")
	public List<Appartement> getAppartementByPrixMax (double prix);
	
	@Query("SELECT h FROM appartement h WHERE h.standard = ?1")
	public List<Appartement> getAppartementByStandard(String standard);
	
//	@Query("SELECT h FROM appartement h WHERE h.adresseBien.idAdresse = ?1")
//	public List<Appartement> getAppartementByIdAdresseBien(int idAdresse);
	
	@Query("SELECT h FROM appartement h WHERE h.dateSoumission = ?1")
	public List<Appartement> getAppartementByDateSoumission(String dateSoumission);
	
	@Query("SELECT h FROM appartement h WHERE h.dateDisposition = ?1")
	public List<Appartement> getAppartementByDateDisposition(String dateDisposition);
	
	@Query("SELECT h FROM appartement h WHERE h.revenu = ?1")
	public List<Appartement> getAppartementByRevenu(int revenu);
	
//	@Query("SELECT h FROM appartement h WHERE h.visite.id_visite = ?1")
//	public List<Appartement> getAppartementByVisite(int id_visite);
//	
//	@Query("SELECT h FROM appartement h WHERE h.contrat.id_contrat = ?1")
//	public List<Appartement> getAppartementByIdContrat(int id_contrat);
//	
//	@Query("SELECT h FROM appartement h WHERE h.proprietaires.identifiant = ?1")
//	public List<Appartement> getAppartementByIdProprietaire(int id_personne);
	
	@Query("SELECT h FROM appartement h WHERE h.superficie >= ?1")
	public List<Appartement> getAppartementBySuperficie(int superficie);
	
	@Query("SELECT h FROM appartement h WHERE h.nbPieces = ?1")
	public List<Appartement> getAppartementByPieces (int nbPieces);
}
