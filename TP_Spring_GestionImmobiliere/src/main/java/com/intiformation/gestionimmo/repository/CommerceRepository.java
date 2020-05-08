package com.intiformation.gestionimmo.repository;

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
	
	@Query("SELECT c FROM Commerce c WHERE c.id_bien = ?1")
	public Commerce getCommerceById (int idCommerce);
}
