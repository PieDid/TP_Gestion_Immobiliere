package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.ContratVente;
import com.intiformation.gestionimmo.repository.ContratVenteRepository;

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
		return contratVenteRepository.getOne(pIdContratVente);
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
	
}
