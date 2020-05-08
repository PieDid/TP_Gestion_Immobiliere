package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Contrat;


public interface ContratRepository extends JpaRepository<Contrat, Integer>{

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
	
	@Query("SELECT c FROM contrat c WHERE c.idContrat = ?1")
	public Contrat getContratById(int id);
	
	@Query("SELECT c FROM contrat c WHERE c.date = ?1")
	public Contrat getContratByDate(String date);
		
	@Query("SELECT c FROM contrat c WHERE c.agent_id = ?1")
	public List<Contrat> getListeContratByIdAgent(int id_agent);
	
	@Query("SELECT c FROM contrat c WHERE c.proprietaire_id = ?1")
	public List<Contrat> getListeContratByIdProprietaire(int id_proprietaire);
	
	
	
	
} // end interface
