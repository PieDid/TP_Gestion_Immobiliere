package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.Appartement;
import com.intiformation.gestionimmo.repository.AppartementRepository;



public class AppartementRest {


	@Autowired
	private AppartementRepository appartementRepo;
	
	@RequestMapping(value="/appartementList", method=RequestMethod.GET)
	public List<Appartement> Listappartement() {
		
		return appartementRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/appartementAdd", method=RequestMethod.POST)
	public void saveappartement(@RequestBody Appartement appartement) {
		
		appartementRepo.save(appartement);
		
	}//end save
	
	
	@RequestMapping(value="/appartement/{id_appartement}", method=RequestMethod.GET)
	public Appartement getappartement(@PathVariable("id_appartement") int pIdappartement) {
		
		return appartementRepo.getAppartementById(pIdappartement);
		
	}//end get
	
	
	@RequestMapping(value="/appartementUpdate/{id_appartement}", method=RequestMethod.PUT)
	public void upappartement(@PathVariable("id_appartement") int pIdappartement, @RequestBody Appartement appartement) {
		
		appartementRepo.saveAndFlush(appartement);
		
	}//end update
	
	
	@RequestMapping(value="/appartementDelete/{id_appartement}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteappartement(@PathVariable("id_appartement") int pIdappartement) {
		
		appartementRepo.deleteById(pIdappartement);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	@RequestMapping(value="/appartementList/{offre}", method=RequestMethod.GET)
	public List<Appartement> listeappartementByOffre(@PathVariable("offre") String pOffre) {
		return appartementRepo.getAppartementByOffre(pOffre);
	
	}//end getAllByOffre
	
	@RequestMapping(value="/appartementList/prix /{prix }", method=RequestMethod.GET)
	public List<Appartement> listeappartementByPrix(@PathVariable("prix ") double pPrix ) {
		return appartementRepo.getAppartementByPrixMax(pPrix);
	
	}//end listeappartementByPrix
	
	@RequestMapping(value="/AppartementList/dateSoumission/{date}", method=RequestMethod.GET)
	public List<Appartement> listeappartementByDateSoumission(@PathVariable("date") String pDate) {
		return appartementRepo.getAppartementByDateSoumission(pDate);
	
	}//end listeappartementByDateSoumission
	
	@RequestMapping(value="/appartementList/dateDisposition/{date}", method=RequestMethod.GET)
	public List<Appartement> listeappartementByDateDisposition(@PathVariable("date") String pDate) {
		return appartementRepo.getAppartementByDateDisposition(pDate);
	
	}//end listeappartementByDateDisposition
	
	@RequestMapping(value="/appartementList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Appartement> listeappartementBySuperficie(@PathVariable("superficie") int pSuperficie) {
		return appartementRepo.getAppartementBySuperficie(pSuperficie);
	
	}//end listeappartementBySuperficie
	
	@RequestMapping(value="/appartementList/pieces/{nbPieces}", method=RequestMethod.GET)
	public List<Appartement> listeAppartementByPieces(@PathVariable("nbPieces") int nbPieces) {
		return appartementRepo.getAppartementByPieces(nbPieces);
	
	}//end getAllByPieces
	
	
//	@RequestMapping(value="/appartementList/visite/{idVisite}", method=RequestMethod.GET)
//	public List<Appartement> listeappartementByVisite(@PathVariable("idVisite") int pIdVisite) {
//		return appartementRepo.getAppartementByVisite(pIdVisite);
//	
//	}//end listeappartementByVisite
//	
//	@RequestMapping(value="/appartementList/contrat/{idContrat}", method=RequestMethod.GET)
//	public List<appartement> listeappartementByContrat(@PathVariable("idContrat") int pIdContrat) {
//		return appartementRepo.getappartementByIdContrat(pIdContrat);
//	
//	}//end listeappartementByContrat
//	
//	@RequestMapping(value="/appartementList/proprietaires/{idProprietaire}", method=RequestMethod.GET)
//	public List<Appartement> listeappartementByProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
//		return appartementRepo.getAppartementByIdProprietaire(pIdProprietaire);
//	
//	}//end listeappartementByContrat
	
}
