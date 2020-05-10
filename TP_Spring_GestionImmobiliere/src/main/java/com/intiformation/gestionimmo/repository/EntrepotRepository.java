package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Entrepot;

public interface EntrepotRepository extends JpaRepository<Entrepot, Integer> {

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
	
	@Query("SELECT e FROM entrepot e WHERE e.id_bien = ?1")
	public Entrepot getEntrepotById (int idEntrepot);
	
	@Query("SELECT e FROM entrepot e WHERE e.statut = ?1")
	public Entrepot getEntrepotByStatut (boolean statut);
	
	@Query("SELECT e FROM entrepot e WHERE e.prix <= ?1")
	public List<Entrepot> getEntrepotByPrixMax (double prix);
	
	@Query("SELECT e FROM entrepot e WHERE e.offre = ?1")
	public List<Entrepot> getEntrepotByOffre (String offre);
	
	@Query("SELECT e FROM entrepot e WHERE e.superficie >= ?1")
	public List<Entrepot> getEntrepotBySuperficie (int superficie);
	
	@Query("SELECT e FROM entrepot e WHERE e.nbPieces = ?1")
	public List<Entrepot> getEntrepotByPieces (int nbPieces);
	
}
