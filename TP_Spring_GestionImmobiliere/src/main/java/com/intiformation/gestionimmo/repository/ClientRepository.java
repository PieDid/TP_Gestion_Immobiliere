package com.intiformation.gestionimmo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.intiformation.gestionimmo.domain.Client;
import com.intiformation.gestionimmo.domain.Personne;

//@Component("clientRepository")
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	

	/*___________ Les méthodes de bases de JpaRepository (opérations CRUD) ___________*/
	/**
	 * 				-> findAll()
	 * 				-> findById()
	 * 				-> save()
	 * 				-> delete() / deleteById()
	 * 				-> getOne() + save() => update
	 * 				-> count()
	 */
//	public List<Client> findAll();
//	
//	@SuppressWarnings({ "unchecked", "hiding" })
//	public <Client extends Personne> Client save(Client client);
//	
//	public void delete(Client client);
	
	
	/*___________________ Les méthodes de requêtes de spring data ___________________*/
	// (dans les cas où les méthodes de bases ne suffiraient pas)
	
	// Les requêtes avec @Query 
	@Query("SELECT c FROM client c WHERE c.identifiant = ?1")
	public Client getClientById(int id);
	
	@Query("SELECT c FROM client c WHERE c.nom = ?1")
	public List<Client> getClientByNom(String nom);
	
	@Query("SELECT c FROM client c WHERE c.statut = ?1")
	public List<Client> getClientByStatut(boolean statut);
}
