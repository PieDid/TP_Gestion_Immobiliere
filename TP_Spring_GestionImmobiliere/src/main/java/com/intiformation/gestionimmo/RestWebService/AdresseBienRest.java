package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionimmo.domain.AdresseBien;
import com.intiformation.gestionimmo.repository.AdresseBienRepository;

public class AdresseBienRest {
	@Autowired
	private AdresseBienRepository adresseBienRepository;

	public void setAdresseBienRepository(AdresseBienRepository adresseBienRepository) {
		this.adresseBienRepository = adresseBienRepository;
	}
	
	@RequestMapping(value="/adresseBienList", method=RequestMethod.GET)
	public List<AdresseBien> listeAdresseBien(){
		return adresseBienRepository.findAll();
	} // end  listeAdresseBien()
	
	@RequestMapping(value="/adresseBien/{identifiant}", method=RequestMethod.GET)
	public AdresseBien getAdresseBien(@PathVariable("identifiant") int pIdAdresseBien) {
		return adresseBienRepository.getAdresseBienById(pIdAdresseBien);
	}//end getAdresseBien()
	
	@RequestMapping(value="/adresseBienAdd", method=RequestMethod.POST)
	public void saveAdresseBien(@RequestBody AdresseBien pAdresseBien) {
		adresseBienRepository.save(pAdresseBien);
	}//end saveAdresseBien()
	
	@RequestMapping(value="/adresseBienUpdate/{identifiant}", method=RequestMethod.PUT)
	public void updateVenteContrat (@PathVariable("identifiant") int pIdAdresseBien, @RequestBody AdresseBien pAdresseBien) {
		adresseBienRepository.saveAndFlush(pAdresseBien);
	}//end updateAdresseBien()
	
	
	@RequestMapping(value="/adresseBienDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAdresseBien(@PathVariable("identifiant") int pIdAdresseBien) {
		adresseBienRepository.deleteById(pIdAdresseBien);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
	}//end deleteAdresseBien()
	
	@RequestMapping(value = "/adresseBien/rue/{rue}", method = RequestMethod.GET)
	public AdresseBien getAdresseBienByRue(@PathVariable("rue") String pRue) {
		return adresseBienRepository.getAdresseBienByRue(pRue);
	}// end getAdresseBienByRue()
	
	@RequestMapping(value = "/adresseBien/codePostal/{codePostal}", method = RequestMethod.GET)
	public List<AdresseBien> getListeAdresseBienByCodePostal(@PathVariable("codePostal") String pCodePostal) {
		return adresseBienRepository.getListeAdresseBienByCodePostal(pCodePostal);
	}// end getListeAdresseBienByCodePostal()
	
	@RequestMapping(value = "/adresseBien/ville/{ville}", method = RequestMethod.GET)
	public List<AdresseBien> getListeAdresseBienByVille(@PathVariable("ville") String pVille) {
		return adresseBienRepository.getListeAdresseBienByVille(pVille);
	}// end getListeAdresseBienByVille()
	
}
