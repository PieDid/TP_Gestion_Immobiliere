package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Contrat;
import com.intiformation.gestionimmo.repository.ContratRepository;

@CrossOrigin(origins = "http://localhost:4200")
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
		return contratRepository.getContratById(pIdContrat);
	}//end getContrat()
	
	@PreAuthorize("hasAnyRole('DMIN','AGENT')")
	@RequestMapping(value="/contratAdd", method=RequestMethod.POST)
	public void saveContrat(@RequestBody Contrat pContrat) {
		contratRepository.save(pContrat);
	}//end saveContrat()
	
	@RequestMapping(value="/contratUpdate/{identifiant}", method=RequestMethod.PUT)
	public void updateContrat (@PathVariable("identifiant") int pIdContrat, @RequestBody Contrat pContrat) {
		contratRepository.saveAndFlush(pContrat);
	}//end updateContrat()
	
	@PreAuthorize("hasAnyRole('ADMIN','AGENT')")
	@RequestMapping(value="/contratDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContrat(@PathVariable("identifiant") int pIdContrat) {
		contratRepository.deleteById(pIdContrat);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end deleteContrat()
	
	@RequestMapping(value="/contrat/date/{date}", method=RequestMethod.GET)
	public Contrat getContratByDate(@PathVariable("date") String date) {
		return contratRepository.getContratByDate(date);
	} // end getContratByDate()
	
	@RequestMapping(value="/contrat/agent/{idAgent}", method=RequestMethod.GET)
	public List<Contrat> getListeContratByIdAgent(@PathVariable("idAgent") int pIdAgent) {
		return contratRepository.getListeContratByIdAgent(pIdAgent);
	}//end getContratByIdAgent()
	
	@RequestMapping(value="/contrat/proprietaire/{idProprietaire}", method=RequestMethod.GET)
	public List<Contrat> getListeContratByIdProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
		return contratRepository.getListeContratByProprietaireId(pIdProprietaire);
	}//end getContratByIdProprietaire()

} // end class
