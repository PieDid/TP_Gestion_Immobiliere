package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.ContratLocation;
import com.intiformation.gestionimmo.repository.ContratLocationRepository;

public class ContratLocationRest {

	@Autowired
	private ContratLocationRepository contratLocationRepository;

	public void setContratLocationRepository(ContratLocationRepository contratLocationRepository) {
		this.contratLocationRepository = contratLocationRepository;
	}
	
	@RequestMapping(value="/contratLocationList", method=RequestMethod.GET)
	public List<ContratLocation> listeContratLocation(){
		return contratLocationRepository.findAll();
	} // end  listeContratLocation()
	
	@RequestMapping(value="/contratLocation/{identifiant}", method=RequestMethod.GET)
	public ContratLocation getContratLocation(@PathVariable("identifiant") int pIdContratLocation) {
		return contratLocationRepository.getOne(pIdContratLocation);
	}//end getContratLocation()
	
	@RequestMapping(value="/contratLocationAdd", method=RequestMethod.POST)
	public void saveContratLocation(@RequestBody ContratLocation pContratLocation) {
		contratLocationRepository.save(pContratLocation);
	}//end saveContratLocation()
	
	@RequestMapping(value="/contratLocationUpdate/{identifiant}", method=RequestMethod.PUT)
	public void updateContratLocation (@PathVariable("identifiant") int pIdContratLocation, @RequestBody ContratLocation pContratLocation) {
		contratLocationRepository.saveAndFlush(pContratLocation);
	}//end updateContratLocation()
	
	
	@RequestMapping(value="/contratLocationDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContratLocation(@PathVariable("identifiant") int pIdContratLocation) {
		contratLocationRepository.deleteById(pIdContratLocation);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end deleteContratLocation()
	
}
