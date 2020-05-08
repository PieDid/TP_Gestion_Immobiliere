package com.intiformation.gestionimmo.repository;

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

	@Query("SELECT b FROM Bureau b WHERE b.id_bien = ?1")
	public Bureau getBureauById (int idBureau);
	
}
