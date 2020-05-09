package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.AdresseBien;

public interface AdresseBienRepository extends JpaRepository<AdresseBien, Integer> {

	

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
	
	@Query("SELECT c FROM adresseBien c WHERE c.idAdresse = ?1")
	public AdresseBien getAdresseBienById(int id);
	
	@Query("SELECT c FROM adresseBien c WHERE c.rue = ?1")
	public AdresseBien getAdresseBienByRue(String rue);
		
	@Query("SELECT c FROM adresseBien c WHERE c.codePostal = ?1")
	public List<AdresseBien> getListeAdresseBienByCodePostal(String codePostal);
	
	@Query("SELECT c FROM adresseBien c WHERE c.ville = ?1")
	public List<AdresseBien> getListeAdresseBienByVille(String ville);
	
	@Query("SELECT c FROM adresseBien c WHERE c.bien = ?1")
	public List<AdresseBien> getListeAdresseBienByBien(String bien);
	
	
}
