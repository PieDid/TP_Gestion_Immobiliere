package com.intiformation.gestionimmo.repository;

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
	
	@Query("SELECT e FROM Entrepot e WHERE e.id_bien = ?1")
	public Entrepot getEntrepotById (int idEntrepot);
	
}
