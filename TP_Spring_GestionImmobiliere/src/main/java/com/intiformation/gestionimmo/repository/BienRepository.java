package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.AdresseBien;
import com.intiformation.gestionimmo.domain.Bien;

public interface BienRepository extends JpaRepository<Bien, Integer>{
	

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
	
	@Query("SELECT b FROM bien b WHERE b.id_bien = ?1")
	public Bien getBienById(int id_bien);
	
	@Query("SELECT b FROM bien b WHERE b.statut = ?1")
	public List<Bien> getBienByStatut(boolean statut);
	
	@Query("SELECT b FROM bien b WHERE b.offre = ?1")
	public List<Bien> getBienByOffre(String offre);
	
	@Query("SELECT b FROM bien b WHERE b.standard = ?1")
	public List<Bien> getBienByStandard(String standard);

	@Query("SELECT b FROM bien b WHERE b.adresseBien.idAdresse = ?1")
	public List<Bien> getBienByIdAdresseBien(int idAdresse);
	
	@Query("SELECT b FROM bien b WHERE b.dateSoumission = ?1")
	public List<Bien> getBienByDateSoumission(String dateSoumission);
	
	@Query("SELECT b FROM bien b WHERE b.dateDisposition = ?1")
	public List<Bien> getBienByDateDisposition(String dateDisposition);
	
	@Query("SELECT b FROM bien b WHERE b.revenu = ?1")
	public List<Bien> getBienByRevenu(int revenu);
	
//	@Query("SELECT b FROM bien b WHERE b.visite.id_visite = ?1")
//	public List<Bien> getBienByVisite(int id_visite);
//	
//	@Query("SELECT b FROM bien b WHERE b.contrat.idContrat = ?1")
//	public List<Bien> getBienByIdContrat(int id_contrat);
//	
//	@Query("SELECT b FROM bien b WHERE b.proprietaires.id_identifiant = ?1")
//	public List<Bien> getBienByIdProprietaire(int id_personne);
	

}
