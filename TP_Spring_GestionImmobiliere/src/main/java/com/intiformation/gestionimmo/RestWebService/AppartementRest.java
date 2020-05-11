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
		
		return appartementRepo.getOne(pIdappartement);
		
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
}
