package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.repository.AdministrateurRepository;
import com.intiformation.gestionimmo.domain.Administrateur;


@RestController
@RequestMapping("/administrateur-rest")
public class AdministrateurRest {
	
	@Autowired
	private AdministrateurRepository adminRepo;

	public void setAdminRepo(AdministrateurRepository adminRepo) {
		this.adminRepo = adminRepo;
	}
	
	
	@RequestMapping(value="/administrateurList", method=RequestMethod.GET)
	public List<Administrateur> listeAdmin() {
		return adminRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/administrateurAdd", method=RequestMethod.POST)
	public void saveAdmin(@RequestBody Administrateur admin) {
		
		adminRepo.save(admin);
		
	}//end save
	
	@RequestMapping(value="/administrateur/{identifiant}", method=RequestMethod.GET)
	public Administrateur getAdmin(@PathVariable("identifiant") int pIdAdmin) {
		
		return adminRepo.getAdministrateurById(pIdAdmin);
		
	}//end get
	
	
	@RequestMapping(value="/administrateurUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upAdmin (@PathVariable("identifiant") int pIdAdmin, @RequestBody Administrateur pAdmin) {
		
		adminRepo.saveAndFlush(pAdmin);
		
	}//end update
	
	
	@RequestMapping(value="/administrateurDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delAdmin(@PathVariable("identifiant") int pIdAdmin) {
		
		adminRepo.deleteById(pIdAdmin);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	

}//end class
