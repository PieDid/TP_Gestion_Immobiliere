package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.AdressePersonne;

public interface AdressePersonneRepository extends JpaRepository<AdressePersonne, Integer> {

	

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
	
	@Query("SELECT c FROM adressePersonne c WHERE c.idAdresse = ?1")
	public AdressePersonne getAdressePersonneById(int id);
	
	@Query("SELECT c FROM adressePersonne c WHERE c.rue = ?1")
	public AdressePersonne getAdressePersonneByRue(String rue);
		
	@Query("SELECT c FROM adressePersonne c WHERE c.codePostal = ?1")
	public List<AdressePersonne> getListeAdressePersonneByCodePostal(String codePostal);
	
	@Query("SELECT c FROM adressePersonne c WHERE c.ville = ?1")
	public List<AdressePersonne> getListeAdressePersonneByVille(String ville);
	
	@Query("SELECT c FROM adressePersonne c WHERE c.personne = ?1")
	public List<AdressePersonne> getListeAdressePersonneByPersonne(String personne);
	
	
}
