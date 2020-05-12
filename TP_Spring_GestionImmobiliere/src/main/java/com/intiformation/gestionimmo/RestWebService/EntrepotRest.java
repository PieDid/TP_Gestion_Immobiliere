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

import com.intiformation.gestionimmo.domain.Entrepot;
import com.intiformation.gestionimmo.repository.EntrepotRepository;

@RestController
@RequestMapping("/entrepot-rest")
public class EntrepotRest {
	
	
	@Autowired
	private EntrepotRepository entrepotRepo;
	
	public void setEntrepotRepo(EntrepotRepository entrepotRepo) {
		this.entrepotRepo = entrepotRepo;
	}


	@RequestMapping(value="/entrepotList", method=RequestMethod.GET)
	public List<Entrepot> ListEntrepot() {
		
		return entrepotRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/entrepotAdd", method=RequestMethod.POST)
	public void saveEntrepot(@RequestBody Entrepot entrepot) {
		
		entrepotRepo.save(entrepot);
		
	}//end save
	
	
	@RequestMapping(value="/entrepot/{id_bien}", method=RequestMethod.GET)
	public Entrepot getEntrepot(@PathVariable("id_bien") int pIdEntrepot) {
		
		return entrepotRepo.getEntrepotById(pIdEntrepot);
		
	}//end get
	
	
	@RequestMapping(value="/entrepotUpdate/{id_bien}", method=RequestMethod.PUT)
	public void upEntrepot (@PathVariable("id_bien") int pIdEntrepot, @RequestBody Entrepot entrepot) {
		
		entrepotRepo.saveAndFlush(entrepot);
		
	}//end update
	
	
	@RequestMapping(value="/entrepotDelete/{id_bien}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteEntrepot(@PathVariable("id_bien") int pIdEntrepot) {
		
		entrepotRepo.deleteById(pIdEntrepot);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	@RequestMapping(value="/entrepotList/prix/{prixMax}", method=RequestMethod.GET)
	public List<Entrepot> listeEntrepotByPrixMax(@PathVariable("prixMax") int pPrixMax) {
		return entrepotRepo.getEntrepotByPrixMax(pPrixMax);
	
	}//end getAllByPrixMax
	
	
	@RequestMapping(value="/entrepotList/offre/{offre}", method=RequestMethod.GET)
	public List<Entrepot> listeEntrepotByOffre(@PathVariable("offre") String pOffre) {
		return entrepotRepo.getEntrepotByOffre(pOffre);
	
	}//end getAllByOffre
	
	@RequestMapping(value="/entrepotList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Entrepot> listeEntrepotBySuperficie(@PathVariable("superficie") int superficie) {
		return entrepotRepo.getEntrepotBySuperficie(superficie);
	
	}//end getAllByPrixMax
	

	
}//end class