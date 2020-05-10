package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Commerce;

public interface CommerceRepository extends JpaRepository<Commerce, Integer> {

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
	
	@Query("SELECT c FROM commerce c WHERE c.id_bien = ?1")
	public Commerce getCommerceById (int idCommerce);
	
	@Query("SELECT c FROM commerce c WHERE c.statut = ?1")
	public Commerce getCommerceByStatut (boolean statut);
	
	@Query("SELECT c FROM commerce c WHERE c.prix <= ?1")
	public List<Commerce> getCommerceByPrixMax (double prix);
	
	@Query("SELECT c FROM commerce c WHERE c.offre = ?1")
	public List<Commerce> getCommerceByOffre (String offre);
	
	@Query("SELECT c FROM commerce c WHERE c.superficie >= ?1")
	public List<Commerce> getCommerceBySuperficie (int superficie);
	
	@Query("SELECT c FROM commerce c WHERE c.nombre_pieces = ?1")
	public List<Commerce> getCommerceByPieces (int nbPieces);
}
