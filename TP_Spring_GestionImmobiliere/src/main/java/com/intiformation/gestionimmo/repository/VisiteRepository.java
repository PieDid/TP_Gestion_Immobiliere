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
	
	@Query("SELECT v FROM visite v WHERE v.id_visite = ?1")
	public Visite getVisiteById(int idVisite);
	
	@Query("SELECT v FROM visite v WHERE v.date = ?1")
	public List<Visite> getVisiteByDate(String date);
	
	@Query("SELECT v FROM visite v WHERE v.bien.id_bien = ?1")
	public List<Visite> getVisiteByBien(int idBien);
	
	@Query("SELECT v FROM visite v WHERE v.agent.identifiant = ?1")
	public List<Visite> getVisiteByAgent(int idAgent);
	
	@Query("SELECT v FROM visite v WHERE v.client.identifiant = ?1")
	public List<Visite> getVisiteByClient(int idClient);
	
	@Query("SELECT v FROM visite v WHERE v.proprietaire. = ?1")
	public List<Visite> getVisiteByProprietaire(int idProprietaire);
	

}
