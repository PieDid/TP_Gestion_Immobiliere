package com.intiformation.gestionimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intiformation.gestionimmo.domain.Bien;
import com.intiformation.gestionimmo.domain.Commerciaux;
import com.intiformation.gestionimmo.domain.Habitation;

public interface HabitationRepository extends JpaRepository<Habitation, Integer> {

	
	/**
	 *  > Les méthodes de base de JpaRepository (opérations CRUD)
	 *    --------------------------------------------------------
	 *    		-> findAll
	 *    		-> save
	 *    		-> findById
	 *    		-> delete
	 *    		-> getOne + save => update
	 *    		-> count
	 */
	
	@Query("SELECT h FROM habitation h WHERE h.id_bien = ?1")
	public Habitation getHabitationById(int idCommerciaux);
	
	@Query("SELECT h FROM habitation h WHERE h.statut = ?1")
	public Habitation getHabitationByStatut (boolean statut);
	
	@Query("SELECT h FROM habitation h WHERE h.offre = ?1")
	public List<Habitation> getHabitationByOffre (String offre);
	
	@Query("SELECT h FROM habitation h WHERE h.prix = ?1")
	public List<Habitation> getHabitationByPrixMax (double prix);
	
	@Query("SELECT h FROM habitation h WHERE h.standard = ?1")
	public List<Habitation> getHabitationByStandard(String standard);
	
//	@Query("SELECT h FROM habitation h WHERE h.adresseBien.idAdresse = ?1")
//	public List<Habitation> getHabitationByIdAdresseBien(int idAdresse);
	
	@Query("SELECT h FROM habitation h WHERE h.dateSoumission = ?1")
	public List<Habitation> getHabitationByDateSoumission(String dateSoumission);
	
	@Query("SELECT h FROM habitation h WHERE h.dateDisposition = ?1")
	public List<Habitation> getHabitationByDateDisposition(String dateDisposition);
	
	@Query("SELECT h FROM habitation h WHERE h.revenu = ?1")
	public List<Habitation> getHabitationByRevenu(int revenu);
	
//	@Query("SELECT h FROM habitation h WHERE h.visite.id_visite = ?1")
//	public List<Habitation> getHabitationByVisite(int id_visite);
//	
//	@Query("SELECT h FROM habitation h WHERE h.contrat.id_contrat = ?1")
//	public List<Habitation> getHabiationByIdContrat(int id_contrat);
	
//	@Query("SELECT h FROM habitation h WHERE h.proprietaires.identifiant = ?1")
//	public List<Habitation> getHabitationByIdProprietaire(int id_personne);
	
	@Query("SELECT h FROM habitation h WHERE h.superficie = ?1")
	public List<Habitation> getHabitationBySuperficie(int superficie);
	
}
