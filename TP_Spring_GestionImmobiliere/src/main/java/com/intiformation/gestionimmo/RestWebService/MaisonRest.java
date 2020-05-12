package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Maison;
import com.intiformation.gestionimmo.repository.MaisonRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/maison-rest")
public class MaisonRest {


	@Autowired
	private MaisonRepository maisonRepo;
	
	@RequestMapping(value="/maisonList", method=RequestMethod.GET)
	public List<Maison> Listmaison() {
		
		return maisonRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/maisonAdd", method=RequestMethod.POST)
	public void savemaison(@RequestBody Maison maison) {
		
		maisonRepo.save(maison);
		
	}//end save
	
	
	@RequestMapping(value="/maison/{id_maison}", method=RequestMethod.GET)
	public Maison getmaison(@PathVariable("id_maison") int pIdmaison) {
		
		return maisonRepo.getMaisonById(pIdmaison);
		
	}//end get
	
	
	@RequestMapping(value="/maisonUpdate/{id_maison}", method=RequestMethod.PUT)
	public void upmaison(@PathVariable("id_maison") int pIdmaison, @RequestBody Maison maison) {
		
		maisonRepo.saveAndFlush(maison);
		
	}//end update
	
	
	@RequestMapping(value="/maisonDelete/{id_maison}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deletemaison(@PathVariable("id_maison") int pIdmaison) {
		
		maisonRepo.deleteById(pIdmaison);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	
	@RequestMapping(value="/maisonList/offre/{offre}", method=RequestMethod.GET)
	public List<Maison> listemaisonByOffre(@PathVariable("offre") String pOffre) {
		return maisonRepo.getMaisonByOffre(pOffre);
	
	}//end getAllByOffre
	
	@RequestMapping(value="/maisonList/prix/{prix}", method=RequestMethod.GET)
	public List<Maison> listemaisonByPrix(@PathVariable("prix") double pPrix ) {
		return maisonRepo.getMaisonByPrixMax(pPrix);
	
	}//end listemaisonByPrix
	
	@RequestMapping(value="/maisonList/dateSoumission/{date}", method=RequestMethod.GET)
	public List<Maison> listemaisonByDateSoumission(@PathVariable("date") String pDate) {
		return maisonRepo.getMaisonByDateSoumission(pDate);
	
	}//end listemaisonByDateSoumission
	
	@RequestMapping(value="/maisonList/dateDisposition/{date}", method=RequestMethod.GET)
	public List<Maison> listemaisonByDateDisposition(@PathVariable("date") String pDate) {
		return maisonRepo.getMaisonByDateDisposition(pDate);
	
	}//end listemaisonByDateDisposition
	
	@RequestMapping(value="/maisonList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Maison> listemaisonBySuperficie(@PathVariable("superficie") int pSuperficie) {
		return maisonRepo.getMaisonBySuperficie(pSuperficie);
	
	}//end listemaisonBySuperficie
	
	
	@RequestMapping(value="/maisonList/pieces/{nbPieces}", method=RequestMethod.GET)
	public List<Maison> listeMaisonByPieces(@PathVariable("nbPieces") int nbPieces) {
		return maisonRepo.getMaisonByPieces(nbPieces);
	
	}//end getAllByPieces
	
	
	
//	@RequestMapping(value="/maisonList/visite/{idVisite}", method=RequestMethod.GET)
//	public List<Maison> listemaisonByVisite(@PathVariable("idVisite") int pIdVisite) {
//		return maisonRepo.getMaisonByVisite(pIdVisite);
//	
//	}//end listemaisonByVisite
//	
//	@RequestMapping(value="/maisonList/contrat/{idContrat}", method=RequestMethod.GET)
//	public List<Maison> listemaisonByContrat(@PathVariable("idContrat") int pIdContrat) {
//		return maisonRepo.getMaisonByIdContrat(pIdContrat);
//	
//	}//end listemaisonByContrat
//	
//	@RequestMapping(value="/maisonList/proprietaires/{idProprietaire}", method=RequestMethod.GET)
//	public List<Maison> listemaisonByProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
//		return maisonRepo.getMaisonByIdProprietaire(pIdProprietaire);
//	
//	}//end listemaisonByContrat
}
