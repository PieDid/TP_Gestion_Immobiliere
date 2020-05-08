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

import com.intiformation.gestionimmo.domain.Personne;
import com.intiformation.gestionimmo.repository.PersonneRepository;

@RestController
@RequestMapping("/personne-rest")
public class PersonneRest {

	@Autowired
	private PersonneRepository personneRepo;

	public void setPersonneRepo(PersonneRepository personneRepo) {
		this.personneRepo = personneRepo;
	}
	
	
	@RequestMapping(value="/personneList", method=RequestMethod.GET)
	public List<Personne> listePersonne() {
		return personneRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/personneAdd", method=RequestMethod.POST)
	public void savePersonne(@RequestBody Personne personne) {
		
		personneRepo.save(personne);
		
	}//end save
	
	@RequestMapping(value="/personne/{identifiant}", method=RequestMethod.GET)
	public Personne getPersonne(@PathVariable("identifiant") int pIdPersonne) {
		
		return personneRepo.getOne(pIdPersonne);
		
	}//end get
	
	
	@RequestMapping(value="/personneUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upPersonne (@PathVariable("identifiant") int pIdPersonne, @RequestBody Personne pPersonne) {
		
		personneRepo.saveAndFlush(pPersonne);
		
	}//end update
	
	
	@RequestMapping(value="/personneDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delPersonne(@PathVariable("identifiant") int pIdPersonne) {
		
		personneRepo.deleteById(pIdPersonne);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
