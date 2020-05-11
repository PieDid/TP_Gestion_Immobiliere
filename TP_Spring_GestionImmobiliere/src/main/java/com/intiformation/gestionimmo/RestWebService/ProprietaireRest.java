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

import com.intiformation.gestionimmo.domain.Proprietaire;
import com.intiformation.gestionimmo.repository.ProprietaireRepository;

@RestController
@RequestMapping("/proprietaire-rest")
public class ProprietaireRest {

	@Autowired
	private ProprietaireRepository proprioRepo;

	public void setProprioRepo(ProprietaireRepository proprioRepo) {
		this.proprioRepo = proprioRepo;
	}
	
	
	@RequestMapping(value="/proprietaireList", method=RequestMethod.GET)
	public List<Proprietaire> listeProprietaire() {
		return proprioRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/proprietaireAdd", method=RequestMethod.POST)
	public void saveProprietaire(@RequestBody Proprietaire proprietaire) {
		
		proprioRepo.save(proprietaire);
		
	}//end save
	
	@RequestMapping(value="/proprietaire/{identifiant}", method=RequestMethod.GET)
	public Proprietaire getProprietaire(@PathVariable("identifiant") int pIdProprietaire) {
		
		return proprioRepo.getProprietaireById(pIdProprietaire);
		
	}//end get
	
	
	@RequestMapping(value="/proprietaireUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upProprietaire (@PathVariable("identifiant") int pIdProprietaire, @RequestBody Proprietaire pProprietaire) {
		
		proprioRepo.saveAndFlush(pProprietaire);
		
	}//end update
	
	
	@RequestMapping(value="/proprietaireDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delProprietaire(@PathVariable("identifiant") int pIdProprietaire) {
		
		proprioRepo.deleteById(pIdProprietaire);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
