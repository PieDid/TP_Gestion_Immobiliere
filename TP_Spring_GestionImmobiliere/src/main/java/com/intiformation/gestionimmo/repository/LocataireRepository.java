package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Locataire;

public interface LocataireRepository extends JpaRepository<Locataire, Integer>{

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
	@Query("SELECT l FROM locataire l WHERE l.identifiant = ?1")
	public Locataire getLocataireById(int id);
	
	@Query("SELECT l FROM locataire l WHERE l.nom = ?1")
	public List<Locataire> getLocataireByNom(String nom);
	
	@Query("SELECT l FROM locataire l WHERE l.statut = ?1")
	public List<Locataire> getLocataireByStatut(boolean statut);
	
}
