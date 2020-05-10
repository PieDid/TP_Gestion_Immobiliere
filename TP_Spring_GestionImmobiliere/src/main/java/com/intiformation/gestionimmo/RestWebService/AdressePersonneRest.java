package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.AdressePersonne;
import com.intiformation.gestionimmo.repository.AdressePersonneRepository;

public class AdressePersonneRest {
	@Autowired
	private AdressePersonneRepository adressePersonneRepository;

	public void setAdressePersonneRepository(AdressePersonneRepository adressePersonneRepository) {
		this.adressePersonneRepository = adressePersonneRepository;
	}
	
	@RequestMapping(value="/adressePersonneList", method=RequestMethod.GET)
	public List<AdressePersonne> listeAdressePersonne(){
		return adressePersonneRepository.findAll();
	} // end  listeAdressePersonne()
	
	@RequestMapping(value="/adressePersonne/{identifiant}", method=RequestMethod.GET)
	public AdressePersonne getAdressePersonne(@PathVariable("identifiant") int pIdAdressePersonne) {
		return adressePersonneRepository.getOne(pIdAdressePersonne);
	}//end getAdressePersonne()
	
	@RequestMapping(value="/adressePersonneAdd", method=RequestMethod.POST)
	public void saveAdressePersonne(@RequestBody AdressePersonne pAdressePersonne) {
		adressePersonneRepository.save(pAdressePersonne);
	}//end saveAdressePersonne()
	
	@RequestMapping(value="/adressePersonneUpdate/{identifiant}", method=RequestMethod.PUT)
	public void updateVenteContrat (@PathVariable("identifiant") int pIdAdressePersonne, @RequestBody AdressePersonne pAdressePersonne) {
		adressePersonneRepository.saveAndFlush(pAdressePersonne);
	}//end updateAdressePersonne()
	
	
	@RequestMapping(value="/adressePersonneDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAdressePersonne(@PathVariable("identifiant") int pIdAdressePersonne) {
		adressePersonneRepository.deleteById(pIdAdressePersonne);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end deleteAdressePersonne()
	
	@RequestMapping(value = "/adressePersonne/rue/{rue}", method = RequestMethod.GET)
	public AdressePersonne getAdressePersonneByRue(@PathVariable("rue") String pRue) {
		return adressePersonneRepository.getAdressePersonneByRue(pRue);
	}// end getAdressePersonneByRue()
	
	@RequestMapping(value = "/adressePersonne/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<AdressePersonne> getListeAdressePersonneByCodePostal(@PathVariable("codePostal") String pCodePostal) {
		return adressePersonneRepository.getListeAdressePersonneByCodePostal(pCodePostal);
	}// end getListeAdressePersonneByCodePostal()
	
	@RequestMapping(value = "/adressePersonne/ville/{ville}", method = RequestMethod.GET)
	public List<AdressePersonne> getListeAdressePersonneByVille(@PathVariable("ville") String pVille) {
		return adressePersonneRepository.getListeAdressePersonneByVille(pVille);
	}// end getListeAdressePersonneByVille()
	
	
}
