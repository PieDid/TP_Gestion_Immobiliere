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

import com.intiformation.gestionimmo.domain.Commerce;
import com.intiformation.gestionimmo.repository.CommerceRepository;


@RestController
@RequestMapping("/commerce-rest")
public class CommerceRest {
	
	@Autowired
	private CommerceRepository commerceRepo;
	
	public void setCommerceRepo(CommerceRepository commerceRepo) {
		this.commerceRepo = commerceRepo;
	}


	@RequestMapping(value="/commerceList", method=RequestMethod.GET)
	public List<Commerce> ListCommerce() {
		
		return commerceRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/commerceAdd", method=RequestMethod.POST)
	public void saveCommerce(@RequestBody Commerce commerce) {
		
		commerceRepo.save(commerce);
		
	}//end save
	
	
	@RequestMapping(value="/commerce/{id_bien}", method=RequestMethod.GET)
	public Commerce getCommerce(@PathVariable("id_bien") int pIdCommerce) {
		
		return commerceRepo.getCommerceById(pIdCommerce);
		
	}//end get
	
	
	@RequestMapping(value="/commerceUpdate/{id_bien}", method=RequestMethod.PUT)
	public void upCommerce (@PathVariable("id_bien") int pIdCommerce, @RequestBody Commerce commerce) {
		
		commerceRepo.saveAndFlush(commerce);
		
	}//end update
	
	
	@RequestMapping(value="/commerceDelete/{id_bien}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteCommerce(@PathVariable("id_bien") int pIdCommerce) {
		
		commerceRepo.deleteById(pIdCommerce);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	@RequestMapping(value="/commerceList/prix/{prixMax}", method=RequestMethod.GET)
	public List<Commerce> listeCommerceByPrixMax(@PathVariable("prixMax") int pPrixMax) {
		return commerceRepo.getCommerceByPrixMax(pPrixMax);
	
	}//end getAllByPrixMax
	
	
	@RequestMapping(value="/commerceList/offre/{offre}", method=RequestMethod.GET)
	public List<Commerce> listeCommerceByOffre(@PathVariable("offre") String pOffre) {
		return commerceRepo.getCommerceByOffre(pOffre);
	
	}//end getAllByOffre
	
	
	@RequestMapping(value="/commerceList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Commerce> listeCommerceBySuperficie(@PathVariable("superficie") int superficie) {
		return commerceRepo.getCommerceBySuperficie (superficie);
	
	}//end getAllBySuperficie
	

	
}//end class