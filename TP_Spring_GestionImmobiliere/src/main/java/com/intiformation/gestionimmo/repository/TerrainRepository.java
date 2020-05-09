package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Terrain;

public interface TerrainRepository extends JpaRepository<Terrain, Integer> {

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

	@Query("SELECT t FROM terrain t WHERE t.id_bien = ?1")
	public Terrain getTerrainById (int id);
	
	@Query("SELECT t FROM terrain t WHERE t.statut = ?1")
	public Terrain getTerrainByStatut (boolean statut);
	
	@Query("SELECT t FROM terrain t WHERE t.prix <= ?1")
	public List<Terrain> getTerrainByPrixMax (double prix);
	
	@Query("SELECT t FROM terrain t WHERE t.offre = ?1")
	public List<Terrain> getTerrainByOffre (String offre);
	
}
