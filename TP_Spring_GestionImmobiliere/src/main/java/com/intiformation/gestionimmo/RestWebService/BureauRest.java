package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.Bureau;
import com.intiformation.gestionimmo.repository.BureauRepository;

@Repository
@RequestMapping("/bureau-rest")
public class BureauRest {
	
	
	@Autowired
	private BureauRepository bureauRepo;
	
	public void setBureauRepo(BureauRepository bureauRepo) {
		this.bureauRepo = bureauRepo;
	}


	@RequestMapping(value="/bureauList", method=RequestMethod.GET)
	public List<Bureau> ListBureau() {
		
		return bureauRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/bureauAdd", method=RequestMethod.POST)
	public void saveBureau(@RequestBody Bureau bureau) {
		
		bureauRepo.save(bureau);
		
	}//end save
	
	
	@RequestMapping(value="/bureau/{id_bien}", method=RequestMethod.GET)
	public Bureau getBureau(@PathVariable("id_bien") int pIdBureau) {
		
		return bureauRepo.getBureauById(pIdBureau);
		
	}//end get
	
	
	@RequestMapping(value="/bureauUpdate/{id_bien}", method=RequestMethod.PUT)
	public void upBureau (@PathVariable("id_bien") int pIdBureau, @RequestBody Bureau bureau) {
		
		bureauRepo.saveAndFlush(bureau);
		
	}//end update
	
	
	@RequestMapping(value="/bureauDelete/{id_bien}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteBureau(@PathVariable("id_bien") int pIdBureau) {
		
		bureauRepo.deleteById(pIdBureau);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	@RequestMapping(value="/bureauList/prix/{prixMax}", method=RequestMethod.GET)
	public List<Bureau> listeBureauByPrixMax(@PathVariable("prixMax") int pPrixMax) {
		return bureauRepo.getBureauByPrixMax(pPrixMax);
	
	}//end getAllByPrixMax
	
	
	@RequestMapping(value="/bureauList/offre/{offre}", method=RequestMethod.GET)
	public List<Bureau> listeBureauByOffre(@PathVariable("offre") String pOffre) {
		return bureauRepo.getBureauByOffre(pOffre);
	
	}//end getAllByOffre
	
	@RequestMapping(value="/bureauList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Bureau> listeBureauBySuperficie(@PathVariable("superficie") int superficie) {
		return bureauRepo.getBureauBySuperficie(superficie);
	
	}//end getAllBySuperficie
	

	
}//end class