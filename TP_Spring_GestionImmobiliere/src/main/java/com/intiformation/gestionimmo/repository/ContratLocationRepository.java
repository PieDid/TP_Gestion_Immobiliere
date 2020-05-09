package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.ContratLocation;

public interface ContratLocationRepository extends JpaRepository<ContratLocation, Integer> {

	

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
	
	@Query("SELECT c FROM contratLocation c WHERE c.idContrat = ?1")
	public ContratLocation getContratLocationById(int id);
	
	@Query("SELECT c FROM contratLocation c WHERE c.date = ?1")
	public ContratLocation getContratLocationByDate(String date);
		
	@Query("SELECT c FROM contratLocation c WHERE c.agent.identifiant = ?1")
	public List<ContratLocation> getListeContratLocationByIdAgent(int id_agent);
	
	@Query("SELECT c FROM contratLocation c WHERE c.proprietaire.identifiant = ?1")
	public List<ContratLocation> getListeContratLocationByIdProprietaire(int id_proprietaire);
	
	@Query("SELECT c FROM contratLocation c WHERE c.caution = ?1")
	public List<ContratLocation> getListeContratLocationByCaution(double caution);
	
	@Query("SELECT c FROM contratLocation c WHERE c.loyer = ?1")
	public List<ContratLocation> getListeContratLocationByLoyer(double loyer);
	
	@Query("SELECT c FROM contratLocation c WHERE c.charge = ?1")
	public List<ContratLocation> getListeContratLocationByCharge(double charge);
	
	@Query("SELECT c FROM contratLocation c WHERE c.typeBail = ?1")
	public List<ContratLocation> getListeContratLocationByTypeBail(String typeBail);
	
	@Query("SELECT c FROM contratLocation c WHERE c.garniture = ?1")
	public List<ContratLocation> getListeContratLocationByGarniture(String garniture);

} // end interface
