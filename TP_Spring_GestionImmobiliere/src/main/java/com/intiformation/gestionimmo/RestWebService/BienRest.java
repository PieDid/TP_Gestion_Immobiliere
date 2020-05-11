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

import com.intiformation.gestionimmo.domain.Bien;
import com.intiformation.gestionimmo.domain.Commerciaux;
import com.intiformation.gestionimmo.repository.BienRepository;

@RestController
@RequestMapping("/bien-rest")
public class BienRest {
	
	@Autowired
	private BienRepository bienRepo;
	
	@RequestMapping(value="/bienList", method=RequestMethod.GET)
	public List<Bien> ListBien() {
		
		return bienRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/bienAdd", method=RequestMethod.POST)
	public void savebien(@RequestBody Bien bien) {
		
		bienRepo.save(bien);
		
	}//end save
	
	
	@RequestMapping(value="/bien/{id_bien}", method=RequestMethod.GET)
	public Bien getbien(@PathVariable("id_bien") int pIdbien) {
		
		return bienRepo.getOne(pIdbien);
		
	}//end get
	
	
	@RequestMapping(value="/bienUpdate/{id_bien}", method=RequestMethod.PUT)
	public void upbien (@PathVariable("id_bien") int pIdbien, @RequestBody Bien bien) {
		
		bienRepo.saveAndFlush(bien);
		
	}//end update
	
	
	@RequestMapping(value="/bienDelete/{id_bien}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deletebien(@PathVariable("id_bien") int pIdbien) {
		
		bienRepo.deleteById(pIdbien);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	
	@RequestMapping(value="/bienList/{offre}", method=RequestMethod.GET)
	public List<Bien> listebienByOffre(@PathVariable("offre") String pOffre) {
		return bienRepo.getBienByOffre(pOffre);
	
	}//end getAllByOffre
	
	
	

}
