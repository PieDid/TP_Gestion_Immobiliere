package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.ContratVente;

public interface ContratVenteRepository extends JpaRepository<ContratVente, Integer> {

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
	
	@Query("SELECT c FROM contratVente c WHERE c.idContrat = ?1")
	public ContratVente getContratVenteById(int id);
	
	@Query("SELECT c FROM contratVente c WHERE c.date = ?1")
	public ContratVente getContratVenteByDate(String date);
		
	@Query("SELECT c FROM contratVente c WHERE c.agent_id = ?1")
	public List<ContratVente> getListeContratVenteByIdAgent(int id_agent);
	
	@Query("SELECT c FROM contratVente c WHERE c.proprietaire_id = ?1")
	public List<ContratVente> getListeContratVenteByIdProprietaire(int id_proprietaire);
	
	@Query("SELECT c FROM contratVente c WHERE c.prix = ?1")
	public List<ContratVente> getListeContratVenteByPrix(double prix);
	
	@Query("SELECT c FROM contratVente c WHERE c.etat = ?1")
	public List<ContratVente> getListeContratVenteByEtat(String etat);
	
} // end interface
