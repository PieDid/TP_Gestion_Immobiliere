package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Visite;
import com.intiformation.gestionimmo.repository.VisiteRepository;

@CrossOrigin(origins = "http://localhost:4200")
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
		
		return visiteRepo.getVisiteById(pIdVisite);
		
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
	
	
	@RequestMapping(value="/visiteList/date/{date}", method=RequestMethod.GET)
	public List<Visite> getVisiteByDate(@PathVariable("date") String date) {
		
		return visiteRepo.getVisiteByDate(date);
		
	}
	
	
	@RequestMapping(value="/visiteList/bien/{idBien}", method=RequestMethod.GET)
	public List<Visite> getVisiteByBien(@PathVariable("idBien") int idBien) {
		
		return visiteRepo.getVisiteByBien(idBien);
		
	}
	
	@RequestMapping(value="/visiteList/agent/{idAgent}", method=RequestMethod.GET)
	public List<Visite> getVisiteByAgent(@PathVariable("idAgent") int idAgent) {
		
		return visiteRepo.getVisiteByAgent(idAgent);
		
	}
	
	@RequestMapping(value="/visiteList/client/{idClient}", method=RequestMethod.GET)
	public List<Visite> getVisiteByClient(@PathVariable("idClient") int idClient) {
		
		return visiteRepo.getVisiteByClient(idClient);
		
	}
	
	@RequestMapping(value="/visiteList/proprietaire/{idProprietaire}", method=RequestMethod.GET)
	public List<Visite> getVisiteByProprietaire(@PathVariable("idProprietaire") int idProprietaire) {
		
		return visiteRepo.getVisiteByProprietaire(idProprietaire);
		
	}

}
