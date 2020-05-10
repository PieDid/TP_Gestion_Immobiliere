package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Commerciaux;

public interface CommerciauxRepository extends JpaRepository<Commerciaux, Integer> {
	
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
	
	@Query("SELECT c FROM commerciaux c WHERE c.id_bien = ?1")
	public Commerciaux getCommerciauxById(int idCommerciaux);
	
	@Query("SELECT c FROM commerciaux c WHERE c.statut = ?1")
	public Commerciaux getCommerciauxByStatut (boolean statut);
	
	@Query("SELECT c FROM commerciaux c WHERE c.prix <= ?1")
	public List<Commerciaux> getCommerciauxByPrixMax (double prix);
	
	@Query("SELECT c FROM commerciaux c WHERE c.offre = ?1")
	public List<Commerciaux> getCommerciauxByOffre (String offre);
	
	@Query("SELECT c FROM commerciaux c WHERE c.superficie >= ?1")
	public List<Commerciaux> getCommerciauxBySuperficie (int superficie);
	
	@Query("SELECT c FROM commerciaux c WHERE c.nombre_pieces = ?1")
	public List<Commerciaux> getCommerciauxByPieces (int nbPieces);

}
