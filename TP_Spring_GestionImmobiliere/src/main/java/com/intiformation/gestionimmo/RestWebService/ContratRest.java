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

import com.intiformation.gestionimmo.domain.Contrat;
import com.intiformation.gestionimmo.repository.ContratRepository;

@RestController
@RequestMapping("/contrat-rest")
public class ContratRest {
	
	@Autowired
	private ContratRepository contratRepository;

	public void setContratRepository(ContratRepository contratRepository) {
		this.contratRepository = contratRepository;
	}
	
	@RequestMapping(value="/contratList", method=RequestMethod.GET)
	public List<Contrat> listeContrat(){
		return contratRepository.findAll();
	} // end  listeContrat()
	
	@RequestMapping(value="/contrat/{identifiant}", method=RequestMethod.GET)
	public Contrat getContrat(@PathVariable("identifiant") int pIdContrat) {
		return contratRepository.getOne(pIdContrat);
	}//end getContrat()
	
	@RequestMapping(value="/contratAdd", method=RequestMethod.POST)
	public void saveContrat(@RequestBody Contrat pContrat) {
		contratRepository.save(pContrat);
	}//end saveContrat()
	
	@RequestMapping(value="/contratUpdate/{identifiant}", method=RequestMethod.PUT)
	public void updateContrat (@PathVariable("identifiant") int pIdContrat, @RequestBody Contrat pContrat) {
		contratRepository.saveAndFlush(pContrat);
	}//end updateContrat()
	
	
	@RequestMapping(value="/contratDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContrat(@PathVariable("identifiant") int pIdContrat) {
		contratRepository.deleteById(pIdContrat);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end deleteContrat()

} // end class
