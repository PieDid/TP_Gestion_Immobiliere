package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Proprietaire;

public interface ProprietaireRepository extends JpaRepository<Proprietaire, Integer>{

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
	@Query("SELECT p FROM proprietaire p WHERE p.identifiant = ?1")
	public Proprietaire getProprietaireById(int id);
	
	@Query("SELECT p FROM proprietaire p WHERE p.nom = ?1")
	public List<Proprietaire> getProprietaireByNom(String nom);
	
	@Query("SELECT p FROM proprietaire p WHERE p.statut = ?1")
	public List<Proprietaire> getProprietaireByStatut(boolean statut);
	
}
