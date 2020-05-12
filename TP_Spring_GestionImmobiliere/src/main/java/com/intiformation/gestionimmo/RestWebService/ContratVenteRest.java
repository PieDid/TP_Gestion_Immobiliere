package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Contrat;
import com.intiformation.gestionimmo.domain.ContratVente;
import com.intiformation.gestionimmo.repository.ContratVenteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/contratVente-rest")
public class ContratVenteRest {

	@Autowired
	private ContratVenteRepository contratVenteRepository;

	public void setContratVenteRepository(ContratVenteRepository contratVenteRepository) {
		this.contratVenteRepository = contratVenteRepository;
	}
	
	@RequestMapping(value="/contratVenteList", method=RequestMethod.GET)
	public List<ContratVente> listeContratVente(){
		return contratVenteRepository.findAll();
	} // end  listeContratVente()
	
	@RequestMapping(value="/contratVente/{identifiant}", method=RequestMethod.GET)
	public ContratVente getContratVente(@PathVariable("identifiant") int pIdContratVente) {
		return contratVenteRepository.getContratVenteById(pIdContratVente);
	}//end getContratVente()
	
	@RequestMapping(value="/contratVenteAdd", method=RequestMethod.POST)
	public void saveContratVente(@RequestBody ContratVente pContratVente) {
		contratVenteRepository.save(pContratVente);
	}//end saveContratVente()
	
	@RequestMapping(value="/contratVenteUpdate/{identifiant}", method=RequestMethod.PUT)
	public void updateVenteContrat (@PathVariable("identifiant") int pIdContratVente, @RequestBody ContratVente pContratVente) {
		contratVenteRepository.saveAndFlush(pContratVente);
	}//end updateContratVente()
	
	
	@RequestMapping(value="/contratVenteDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteContratVente(@PathVariable("identifiant") int pIdContratVente) {
		contratVenteRepository.deleteById(pIdContratVente);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end deleteContratVente()
	
	@RequestMapping(value="/contratVente/date/{date}", method=RequestMethod.GET)
	public ContratVente getContratByDate(@PathVariable("date") String date) {
		return contratVenteRepository.getContratVenteByDate(date);
	} // end getContratVenteByDate()
	
	@RequestMapping(value="/contratVente/agent/{idAgent}", method=RequestMethod.GET)
	public List<ContratVente> getListeContratVenteByIdAgent(@PathVariable("idAgent") int pIdAgent) {
		return contratVenteRepository.getListeContratVenteByIdAgent(pIdAgent);
	}//end getContratVenteByIdAgent()
	
	@RequestMapping(value="/contratVente/proprietaire/{idProprietaire}", method=RequestMethod.GET)
	public List<ContratVente> getListeContratVenteByIdProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
		return contratVenteRepository.getListeContratVenteByIdProprietaire(pIdProprietaire);
	}//end getContratVenteByIdProprietaire()
	
	@RequestMapping(value="/contratVente/prix/{prix}", method=RequestMethod.GET)
	public List<ContratVente> getListeContratVenteByPrix(@PathVariable("prix") double pPrix) {
		return contratVenteRepository.getListeContratVenteByPrix(pPrix);
	}//end getContratVenteByPrix()
	
	@RequestMapping(value="/contratVente/etat/{etat}", method=RequestMethod.GET)
	public List<ContratVente> getListeContratVenteByEtat(@PathVariable("etat") String pEtat){
		return contratVenteRepository.getListeContratVenteByEtat(pEtat);
	}//end getContratVenteByEtat()
	
	
}
