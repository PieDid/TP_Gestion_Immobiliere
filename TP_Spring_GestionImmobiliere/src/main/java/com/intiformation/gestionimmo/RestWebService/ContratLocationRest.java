package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.Contrat;
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
		return contratLocationRepository.getContratLocationById(pIdContratLocation);
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
	
	
	@RequestMapping(value="/contratLocation/date/{date}", method=RequestMethod.GET)
	public ContratLocation getContratLocationByDate(@PathVariable("date") String date) {
		return contratLocationRepository.getContratLocationByDate(date);
	} // end getContratLocationByDate()
	
	@RequestMapping(value="/contratLocation/agent/{idAgent}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByIdAgent(@PathVariable("idAgent") int pIdAgent) {
		return contratLocationRepository.getListeContratLocationByIdAgent(pIdAgent);
	}//end getContratLocationByIdAgent()
	
	@RequestMapping(value="/contratLocation/proprietaire/{idProprietaire}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByIdProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
		return contratLocationRepository.getListeContratLocationByIdProprietaire(pIdProprietaire);
	}//end getContratLocationByIdProprietaire()
	
	@RequestMapping(value="/contratLocation/caution/{caution}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByCaution(@PathVariable("caution") double pCaution){
		return contratLocationRepository.getListeContratLocationByCaution(pCaution);
	} // end getListeContratLocationByCaution()
	
	@RequestMapping(value="/contratLocation/loyer/{loyer}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByLoyer(@PathVariable("loyer") double pLoyer){
		return contratLocationRepository.getListeContratLocationByLoyer(pLoyer);
	} // end getListeContratLocationByLoyer()
	
	@RequestMapping(value="/contratLocation/charge/{charge}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByCharge(@PathVariable("charge") double pCharge){
		return contratLocationRepository.getListeContratLocationByCharge(pCharge);
	} // end getListeContratLocationByCharge()
	
	@RequestMapping(value="/contratLocation/typeBail/{typeBail}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByTypeBail(@PathVariable("typeBail") String pTypeBail){
		return contratLocationRepository.getListeContratLocationByTypeBail(pTypeBail);
	} // end getListeContratLocationByTypeBail()
	
	@RequestMapping(value="/contratLocation/garniture/{garniture}", method=RequestMethod.GET)
	public List<ContratLocation> getListeContratLocationByGarniture(@PathVariable("garniture") String pGarniture){
		return contratLocationRepository.getListeContratLocationByGarniture(pGarniture);
	} // end getListeContratLocationByGarniture()
	
}
