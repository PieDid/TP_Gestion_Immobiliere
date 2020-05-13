package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Commerciaux;
import com.intiformation.gestionimmo.repository.CommerciauxRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/commerciaux-rest")
public class CommerciauxRest {

	@Autowired
	private CommerciauxRepository commerciauxRepo;

	public void setCommerciauxRepo(CommerciauxRepository commerciauxRepo) {
		this.commerciauxRepo = commerciauxRepo;
	}
	
	@RequestMapping(value="/commerciauxList", method=RequestMethod.GET)
	public List<Commerciaux> ListCommerciaux() {
		
		return commerciauxRepo.findAll();
		
	}//end find-all
	
	@PreAuthorize("hasAnyRole('ADMIN','AGENT','LOC','PROP')")
	@RequestMapping(value="/commerciauxAdd", method=RequestMethod.POST)
	public void saveCommerciaux(@RequestBody Commerciaux commerciaux) {
		
		commerciauxRepo.save(commerciaux);
		
	}//end save
	
	
	@RequestMapping(value="/commerciaux/{id_bien}", method=RequestMethod.GET)
	public Commerciaux getCommerciaux(@PathVariable("id_bien") int pIdCommerciaux) {
		
		return commerciauxRepo.getCommerciauxById(pIdCommerciaux);
		
	}//end get
	
	@PreAuthorize("hasAnyRole('ADMIN','AGENT','LOC','PROP')")
	@RequestMapping(value="/commerciauxUpdate/{id_bien}", method=RequestMethod.PUT)
	public void upCommerciaux (@PathVariable("id_bien") int pIdCommerciaux, @RequestBody Commerciaux commerciaux) {
		
		commerciauxRepo.saveAndFlush(commerciaux);
		
	}//end update
	
	@PreAuthorize("hasAnyRole('ADMIN','AGENT','LOC','PROP')")
	@RequestMapping(value="/commerciauxDelete/{id_bien}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteCommerciaux(@PathVariable("id_bien") int pIdCommerciaux) {
		
		commerciauxRepo.deleteById(pIdCommerciaux);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	@RequestMapping(value="/commerciauxList/prix/{prixMax}", method=RequestMethod.GET)
	public List<Commerciaux> listeCommerciauxByPrixMax(@PathVariable("prixMax") int pPrixMax) {
		return commerciauxRepo.getCommerciauxByPrixMax(pPrixMax);
	
	}//end getAllByPrixMax
	
	
	@RequestMapping(value="/commerciauxList/offre/{offre}", method=RequestMethod.GET)
	public List<Commerciaux> listeCommerciauxByOffre(@PathVariable("offre") String pOffre) {
		return commerciauxRepo.getCommerciauxByOffre(pOffre);
	
	}//end getAllByOffre
	
	@RequestMapping(value="/commerciauxList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Commerciaux> listeCommerciauxBySuperficie(@PathVariable("superficie") int superficie) {
		return commerciauxRepo.getCommerciauxBySuperficie(superficie);
	
	}//end getAllBySuperficie
	

	
}//end class
