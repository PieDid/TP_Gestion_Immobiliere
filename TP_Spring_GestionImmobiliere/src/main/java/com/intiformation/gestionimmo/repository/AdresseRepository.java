package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Adresse;


public interface AdresseRepository extends JpaRepository<Adresse, Integer>{

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
	
	@Query("SELECT c FROM adresse c WHERE c.idAdresse = ?1")
	public Adresse getAdresseById(int id);
	
	@Query("SELECT c FROM adresse c WHERE c.rue = ?1")
	public Adresse getAdresseByRue(String rue);
		
	@Query("SELECT c FROM adresse c WHERE c.codePostal = ?1")
	public List<Adresse> getListeAdresseByCodePostal(String codePostal);
	
	@Query("SELECT c FROM adresse c WHERE c.ville = ?1")
	public List<Adresse> getListeAdresseByVille(String ville);
	
}
