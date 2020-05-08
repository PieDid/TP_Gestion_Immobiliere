package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Visite;

public interface VisiteRepository extends JpaRepository<Visite, Integer> {
	
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
	
	@Query("SELECT v FROM Visite v WHERE v.id_visite = ?1")
	public Visite getVisiteById(int idVisite);
	
	@Query("SELECT v FROM Visite v WHERE v.date = ?1")
	public List<Visite> getVisiteByDate(String date);

}