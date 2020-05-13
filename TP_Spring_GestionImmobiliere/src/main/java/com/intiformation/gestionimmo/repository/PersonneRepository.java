package com.intiformation.gestionimmo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intiformation.gestionimmo.domain.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer>{

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
	@Query("SELECT p FROM personne p WHERE p.identifiant = ?1")
	public Personne getPersonneById(int id);
	
	@Query("SELECT p FROM personne p WHERE p.nom = ?1")
	public List<Personne> getPersonneByNom(String nom);
	
	@Query("SELECT p FROM personne p WHERE p.statut = ?1")
	public List<Personne> getPersonneByStatut(boolean statut);
	
	//Les requêtes pour l'authentification
	Optional<Personne> findByNom(String nom);

	Boolean existsByNom(String nom);

	Boolean existsByEmail(String email);
	
}
