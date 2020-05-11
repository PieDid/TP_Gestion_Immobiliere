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
	
	
	public void setBienRepo(BienRepository bienRepo) {
		this.bienRepo = bienRepo;
	}


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
	
	
	@RequestMapping(value="/bienList/offre/{offre}", method=RequestMethod.GET)
	public List<Bien> listebienByOffre(@PathVariable("offre") String pOffre) {
		return bienRepo.getBienByOffre(pOffre);
	
	}//end getAllByOffre
	
//	@RequestMapping(value="/bienList/visite/{idVisite}", method=RequestMethod.GET)
//	public List<Bien> listebienByVisite(@PathVariable("idVisite") int pIdVisite) {
//		return bienRepo.getBienByVisite(pIdVisite);
//	
//	}//end listebienByVisite
//	
//	@RequestMapping(value="/bienList/contrat/{idContrat}", method=RequestMethod.GET)
//	public List<Bien> listebienByContrat(@PathVariable("idContrat") int pIdContrat) {
//		return bienRepo.getBienByIdContrat(pIdContrat);
//	
//	}//end listebienByContrat
//	
//	@RequestMapping(value="/bienList/proprietaires/{idProprietaire}", method=RequestMethod.GET)
//	public List<Bien> listebienByProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
//		return bienRepo.getBienByIdProprietaire(pIdProprietaire);
//	
//	}//end listebienByContrat

}
