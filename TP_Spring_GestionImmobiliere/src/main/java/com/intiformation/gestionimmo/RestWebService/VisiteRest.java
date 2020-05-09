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

import com.intiformation.gestionimmo.domain.Visite;
import com.intiformation.gestionimmo.repository.VisiteRepository;

@RestController
@RequestMapping("/visite-rest")
public class VisiteRest {
	
	@Autowired
	private VisiteRepository visiteRepo;

	public void setVisiteRepo(VisiteRepository visiteRepo) {
		this.visiteRepo = visiteRepo;
	}
	

	@RequestMapping(value="/visiteList", method=RequestMethod.GET)
	public List<Visite> ListVisite() {
		
		return visiteRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/visiteAdd", method=RequestMethod.POST)
	public void saveVisite(@RequestBody Visite visite) {
		
		visiteRepo.save(visite);
		
	}//end save
	
	
	@RequestMapping(value="/visite/{id_visite}", method=RequestMethod.GET)
	public Visite getVisite(@PathVariable("id_visite") int pIdVisite) {
		
		return visiteRepo.getOne(pIdVisite);
		
	}//end get
	
	
	@RequestMapping(value="/visiteUpdate/{id_visite}", method=RequestMethod.PUT)
	public void upVisite (@PathVariable("id_visite") int pIdVisite, @RequestBody Visite pVisite) {
		
		visiteRepo.saveAndFlush(pVisite);
		
	}//end update
	
	
	@RequestMapping(value="/visiteDelete/{id_visite}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteVisite(@PathVariable("id_visite") int pIdVisite) {
		
		visiteRepo.deleteById(pIdVisite);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	

}
