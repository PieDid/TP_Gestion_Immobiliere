package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intiformation.gestionimmo.domain.Administrateur;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Integer>{

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
	@Query("SELECT a FROM Administrateur a WHERE a.identifiant = ?1")
	public Administrateur getAdministrateurById(int id);
	
	@Query("SELECT a FROM Administrateur a WHERE a.nom = ?1")
	public List<Administrateur> getAdministrateurByNom(String nom);
	
	@Query("SELECT a FROM Administrateur a WHERE a.statut = ?1")
	public List<Administrateur> getAdministrateurByStatut(boolean statut);
	
}
