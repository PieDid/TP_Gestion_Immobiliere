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

import com.intiformation.gestionimmo.domain.Locataire;
import com.intiformation.gestionimmo.repository.LocataireRepository;

@RestController
@RequestMapping("/locataire-rest")
public class LocataireRest {

	@Autowired
	private LocataireRepository locataireRepo;

	public void setLocataireRepo(LocataireRepository locataireRepo) {
		this.locataireRepo = locataireRepo;
	}
	
	
	@RequestMapping(value="/locataireList", method=RequestMethod.GET)
	public List<Locataire> listeLocataire() {
		return locataireRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/locataireAdd", method=RequestMethod.POST)
	public void saveLocataire(@RequestBody Locataire locataire) {
		
		locataireRepo.save(locataire);
		
	}//end save
	
	@RequestMapping(value="/locataire/{identifiant}", method=RequestMethod.GET)
	public Locataire getLocataire(@PathVariable("identifiant") int pIdLocataire) {
		
		return locataireRepo.getLocataireById(pIdLocataire);
		
	}//end get
	
	
	@RequestMapping(value="/locataireUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upLocataire (@PathVariable("identifiant") int pIdLocataire, @RequestBody Locataire pLocataire) {
		
		locataireRepo.saveAndFlush(pLocataire);
		
	}//end update
	
	
	@RequestMapping(value="/locataireDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delLocataire(@PathVariable("identifiant") int pIdLocataire) {
		
		locataireRepo.deleteById(pIdLocataire);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
