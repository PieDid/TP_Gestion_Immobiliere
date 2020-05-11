package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Bien;
import com.intiformation.gestionimmo.domain.Commerciaux;
import com.intiformation.gestionimmo.domain.Maison;

public interface MaisonRepository extends JpaRepository<Maison, Integer> {


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
	
	@Query("SELECT h FROM maison h WHERE h.id_bien = ?1")
	public Maison getMaisonById(int idCommerciaux);
	
	@Query("SELECT h FROM maison h WHERE h.statut = ?1")
	public Maison getMaisonByStatut (boolean statut);
	
	@Query("SELECT h FROM maison h WHERE h.offre = ?1")
	public List<Maison> getMaisonByOffre (String offre);
	
	@Query("SELECT h FROM maison h WHERE h.prix <= ?1")
	public List<Maison> getMaisonByPrixMax (double prix);
	
	@Query("SELECT h FROM maison h WHERE h.standard = ?1")
	public List<Maison> getMaisonByStandard(String standard);
	
//	@Query("SELECT h FROM maison h WHERE h.adresseBien.idAdresse = ?1")
//	public List<Maison> getMaisonByIdAdresseBien(int idAdresse);
	
	@Query("SELECT h FROM maison h WHERE h.dateSoumission = ?1")
	public List<Maison> getMaisonByDateSoumission(String dateSoumission);
	
	@Query("SELECT h FROM maison h WHERE h.dateDisposition = ?1")
	public List<Maison> getMaisonByDateDisposition(String dateDisposition);
	
	@Query("SELECT h FROM maison h WHERE h.revenu = ?1")
	public List<Maison> getMaisonByRevenu(int revenu);
	
//	@Query("SELECT h FROM maison h WHERE h.visite.id_visite = ?1")
//	public List<Maison> getMaisonByVisite(int id_visite);
//	
//	@Query("SELECT h FROM maison h WHERE h.contrat.id_contrat = ?1")
//	public List<Maison> getMaisonByIdContrat(int id_contrat);
//	
//	@Query("SELECT h FROM maison h WHERE h.proprietaires.identifiant = ?1")
//	public List<Maison> getMaisonByIdProprietaire(int id_personne);
	
	@Query("SELECT h FROM maison h WHERE h.superficie >= ?1")
	public List<Maison> getMaisonBySuperficie(int superficie);
	
}
