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

import com.intiformation.gestionimmo.domain.Adresse;
import com.intiformation.gestionimmo.repository.AdresseRepository;

@RestController
@RequestMapping("/adresse-rest")
public class AdresseRest {
	@Autowired
	private AdresseRepository adresseRepository;

	public void setAdresseRepository(AdresseRepository adresseRepository) {
		this.adresseRepository = adresseRepository;
	}

	@RequestMapping(value = "/adresseList", method = RequestMethod.GET)
	public List<Adresse> listeAdresse() {
		return adresseRepository.findAll();
	} // end listeAdresse()

	@RequestMapping(value = "/adresse/{identifiant}", method = RequestMethod.GET)
	public Adresse getAdresse(@PathVariable("identifiant") int pIdAdresse) {
		return adresseRepository.getAdresseById(pIdAdresse);
	}// end getAdresse()

	@RequestMapping(value = "/adresseAdd", method = RequestMethod.POST)
	public void saveAdresse(@RequestBody Adresse pAdresse) {
		adresseRepository.save(pAdresse);
	}// end saveAdresse()

	@RequestMapping(value = "/adresseUpdate/{identifiant}", method = RequestMethod.PUT)
	public void updateAdresse(@PathVariable("identifiant") int pIdAdresse, @RequestBody Adresse pAdresse) {
		adresseRepository.saveAndFlush(pAdresse);
	}// end updateAdresse()

	@RequestMapping(value = "/adresseDelete/{identifiant}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAdresse(@PathVariable("identifiant") int pIdAdresse) {
		adresseRepository.deleteById(pIdAdresse);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}// end deleteAdresse()
	
	@RequestMapping(value = "/adresse/rue/{rue}", method = RequestMethod.GET)
	public Adresse getAdresseByRue(@PathVariable("rue") String pRue) {
		return adresseRepository.getAdresseByRue(pRue);
	}// end getAdresseByRue()
	
	@RequestMapping(value = "/adresse/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<Adresse> getListeAdresseByCodePostal(@PathVariable("codePostal") String pCodePostal) {
		return adresseRepository.getListeAdresseByCodePostal(pCodePostal);
	}// end getListeAdresseByCodePostal()
	
	@RequestMapping(value = "/adresse/ville/{ville}", method = RequestMethod.GET)
	public List<Adresse> getListeAdresseByVille(@PathVariable("ville") String pVille) {
		return adresseRepository.getListeAdresseByVille(pVille);
	}// end getListeAdresseByVille()
	
}
