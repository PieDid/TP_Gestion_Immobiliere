package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Studio;

public interface StudioRepository extends JpaRepository<Studio, Integer> {

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
	
	@Query("SELECT h FROM studio h WHERE h.id_bien = ?1")
	public Studio getStudioById(int idBien);
	
	@Query("SELECT h FROM studio h WHERE h.statut = ?1")
	public Studio getStudioByStatut (boolean statut);
	
	@Query("SELECT h FROM studio h WHERE h.offre = ?1")
	public List<Studio> getStudioByOffre (String offre);
	
	@Query("SELECT h FROM studio h WHERE h.prix <= ?1")
	public List<Studio> getStudioByPrixMax (double prix);
	
	@Query("SELECT h FROM studio h WHERE h.standard = ?1")
	public List<Studio> getStudioByStandard(String standard);
	
//	@Query("SELECT h FROM studio h WHERE h.adresseBien.idAdresse = ?1")
//	public List<Studio> geStudioByIdAdresseBien(int idAdresse);
	
	@Query("SELECT h FROM studio h WHERE h.dateSoumission = ?1")
	public List<Studio> getStudioByDateSoumission(String dateSoumission);
	
	@Query("SELECT h FROM studio h WHERE h.dateDisposition = ?1")
	public List<Studio> getStudioByDateDisposition(String dateDisposition);
	
	@Query("SELECT h FROM studio h WHERE h.revenu = ?1")
	public List<Studio> getStudioByRevenu(int revenu);
	
//	@Query("SELECT h FROM studio h WHERE h.visite.id_visite = ?1")
//	public List<Studio> getStudioByVisite(int id_visite);
//	
//	@Query("SELECT h FROM studio h WHERE h.contrat.id_contrat = ?1")
//	public List<Studio> getStudioByIdContrat(int id_contrat);
//	
//	@Query("SELECT h FROM studio h WHERE h.proprietaires.identifiant = ?1")
//	public List<Studio> getStudioByIdProprietaire(int id_personne);
	
	@Query("SELECT h FROM studio h WHERE h.superficie >= ?1")
	public List<Studio> getStudioBySuperficie(int superficie);
	
	@Query("SELECT h FROM studio h WHERE h.nbPieces = ?1")
	public List<Studio> getStudioByPieces (int nbPieces);
	
}
