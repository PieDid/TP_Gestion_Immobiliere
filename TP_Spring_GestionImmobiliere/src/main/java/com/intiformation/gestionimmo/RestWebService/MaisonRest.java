package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.Maison;
import com.intiformation.gestionimmo.repository.MaisonRepository;



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
		
		return maisonRepo.getOne(pIdmaison);
		
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
	
	
	
	@RequestMapping(value="/maisonList/{offre}", method=RequestMethod.GET)
	public List<Maison> listemaisonByOffre(@PathVariable("offre") String pOffre) {
		return maisonRepo.getMaisonByOffre(pOffre);
	
	}//end getAllByOffre
}
