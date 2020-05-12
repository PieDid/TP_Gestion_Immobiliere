package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Habitation;
import com.intiformation.gestionimmo.repository.HabitationRepository;



@RestController
@RequestMapping("/habitation-rest")
public class HabitationRest {

	@Autowired
	private HabitationRepository habitationRepo;
	
	
	public void setHabitationRepo(HabitationRepository habitationRepo) {
		this.habitationRepo = habitationRepo;
	}

	@RequestMapping(value="/habitationList", method=RequestMethod.GET)
	public List<Habitation> ListHabitation() {
		
		return habitationRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/habitationAdd", method=RequestMethod.POST)
	public void savebien(@RequestBody Habitation habitation) {
		
		habitationRepo.save(habitation);
		
	}//end save
	
	
	@RequestMapping(value="/habitation/{id_bien}", method=RequestMethod.GET)
	public Habitation getbien(@PathVariable("id_bien") int pIdbien) {
		
		return habitationRepo.getHabitationById(pIdbien);
		
	}//end get
	
	
	@RequestMapping(value="/habitationUpdate/{id_bien}", method=RequestMethod.PUT)
	public void uphabitation(@PathVariable("id_bien") int pIdbien, @RequestBody Habitation bien) {
		
		habitationRepo.saveAndFlush(bien);
		
	}//end update
	
	
	@RequestMapping(value="/habitationDelete/{id_bien}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deletebien(@PathVariable("id_bien") int pIdbien) {
		
		habitationRepo.deleteById(pIdbien);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	@RequestMapping(value="/habitationList/offre/{offre}", method=RequestMethod.GET)
	public List<Habitation> listehabitationByOffre(@PathVariable("offre") String pOffre) {
		return habitationRepo.getHabitationByOffre(pOffre);
	
	}//end listehabitationByOffre
	
	@RequestMapping(value="/habitationList/prix/{prix}", method=RequestMethod.GET)
	public List<Habitation> listehabitationByPrix(@PathVariable("prix ") double pPrix ) {
		return habitationRepo.getHabitationByPrixMax(pPrix);
	
	}//end listehabitationByPrix
	
	@RequestMapping(value="/habitationList/dateSoumission/{date}", method=RequestMethod.GET)
	public List<Habitation> listehabitationByDateSoumission(@PathVariable("date") String pDate) {
		return habitationRepo.getHabitationByDateSoumission(pDate);
	
	}//end listehabitationByDateSoumission
	
	@RequestMapping(value="/habitationList/dateDisposition/{date}", method=RequestMethod.GET)
	public List<Habitation> listehabitationByDateDisposition(@PathVariable("date") String pDate) {
		return habitationRepo.getHabitationByDateDisposition(pDate);
	
	}//end listehabitationByDateDisposition
	
	@RequestMapping(value="/habitationList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Habitation> listehabitationBySuperficie(@PathVariable("superficie") int pSuperficie) {
		return habitationRepo.getHabitationBySuperficie(pSuperficie);
	
	}//end listehabitationBySuperficie
	
	@RequestMapping(value="/habitationList/pieces/{nbPieces}", method=RequestMethod.GET)
	public List<Habitation> listeHabitationByPieces(@PathVariable("nbPieces") int nbPieces) {
		return habitationRepo.getHabitationByPieces(nbPieces);
	
	}//end getAllByPieces
	
	
//	@RequestMapping(value="/habitationList/visite/{idVisite}", method=RequestMethod.GET)
//	public List<Habitation> listehabitationByVisite(@PathVariable("idVisite") int pIdVisite) {
//		return habitationRepo.getHabitationByVisite(pIdVisite);
//	
//	}//end listehabitationByVisite
//	
//	@RequestMapping(value="/habitationList/contrat/{idContrat}", method=RequestMethod.GET)
//	public List<Habitation> listehabitationByContrat(@PathVariable("idContrat") int pIdContrat) {
//		return habitationRepo.getHabitationByIdContrat(pIdContrat);
//	
//	}//end listehabitationByContrat
//	
//	@RequestMapping(value="/habitationList/proprietaires/{idProprietaire}", method=RequestMethod.GET)
//	public List<Habitation> listehabitationByProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
//		return habitationRepo.getHabitationByIdProprietaire(pIdProprietaire);
//	
//	}//end listehabitationByContrat
}
