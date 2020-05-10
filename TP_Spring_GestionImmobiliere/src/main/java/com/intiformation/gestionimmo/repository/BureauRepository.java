package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Bureau;

public interface BureauRepository extends JpaRepository<Bureau, Integer> {
	
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

	@Query("SELECT b FROM bureau b WHERE b.id_bien = ?1")
	public Bureau getBureauById (int idBureau);
	
	@Query("SELECT b FROM bureau b WHERE b.statut = ?1")
	public Bureau getBureauByStatut (boolean statut);
	
	@Query("SELECT b FROM bureau b WHERE b.prix <= ?1")
	public List<Bureau> getBureauByPrixMax (double prix);
	
	@Query("SELECT b FROM bureau b WHERE b.offre = ?1")
	public List<Bureau> getBureauByOffre (String offre);
	
	@Query("SELECT b FROM bureau b WHERE b.superficie >= ?1")
	public List<Bureau> getBureauBySuperficie (int superficie);
	
	@Query("SELECT b FROM bureau b WHERE b.nombre_pieces = ?1")
	public List<Bureau> getBureauByPieces (int nbPieces);
	
}
