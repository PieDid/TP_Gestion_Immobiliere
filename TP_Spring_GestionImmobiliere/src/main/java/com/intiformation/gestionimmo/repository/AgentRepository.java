package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer>{

	/*___________ Les méthodes de bases de JpaRepository (opérations CRUD) ___________*/
	/**
	 * 				-> findAll()
	 * 				-> findById()
	 * 				-> save()
	 * 				-> delete() / deleteById()
	 * 				-> getOne() + save() => update
	 * 				-> count()
	 */
	
	
	
	/*___________________ Les méthodes de requêtes de spring data ___________________*/
	// (dans les cas où les méthodes de bases ne suffiraient pas)
	
	// Les requêtes avec @Query 
	@Query("SELECT a FROM agent a WHERE a.identifiant = ?1")
	public Agent getAgentById(int id);
	
	@Query("SELECT a FROM agent a WHERE a.nom = ?1")
	public List<Agent> getAgentByNom(String nom);
	
	@Query("SELECT a FROM agent a WHERE a.statut = ?1")
	public List<Agent> getAgentByStatut(boolean statut);
	
}
