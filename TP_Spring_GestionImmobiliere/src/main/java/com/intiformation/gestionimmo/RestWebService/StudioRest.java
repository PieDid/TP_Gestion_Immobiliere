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

import com.intiformation.gestionimmo.domain.Studio;
import com.intiformation.gestionimmo.repository.StudioRepository;


@RestController
@RequestMapping("/studio-rest")
public class StudioRest {

	@Autowired
	private StudioRepository studioRepo;
	
	
	public void setStudioRepo(StudioRepository studioRepo) {
		this.studioRepo = studioRepo;
	}

	@RequestMapping(value="/studioList", method=RequestMethod.GET)
	public List<Studio> Liststudio() {
		
		return studioRepo.findAll();
		
	}//end find-all
	
	
	@RequestMapping(value="/studioAdd", method=RequestMethod.POST)
	public void savestudio(@RequestBody Studio studio) {
		
		studioRepo.save(studio);
		
	}//end save
	
	
	@RequestMapping(value="/studio/{id_studio}", method=RequestMethod.GET)
	public Studio getstudio(@PathVariable("id_studio") int pIdstudio) {
		
		return studioRepo.getStudioById(pIdstudio);
		
	}//end get
	
	
	@RequestMapping(value="/studioUpdate/{id_studio}", method=RequestMethod.PUT)
	public void upstudio(@PathVariable("id_studio") int pIdstudio, @RequestBody Studio studio) {
		
		studioRepo.saveAndFlush(studio);
		
	}//end update
	
	
	@RequestMapping(value="/studioDelete/{id_studio}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deletestudio(@PathVariable("id_studio") int pIdstudio) {
		
		studioRepo.deleteById(pIdstudio);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
	@RequestMapping(value="/studioList/offre/{offre}", method=RequestMethod.GET)
	public List<Studio> listestudioByOffre(@PathVariable("offre") String pOffre) {
		return studioRepo.getStudioByOffre(pOffre);
	
	}//end getAllByOffre
	
	@RequestMapping(value="/studioList/prix/{prix}", method=RequestMethod.GET)
	public List<Studio> listestudioByPrix(@PathVariable("prix") double pPrix ) {
		return studioRepo.getStudioByPrixMax(pPrix);
	
	}//end listestudioByPrix
	
	@RequestMapping(value="/studioList/dateSoumission/{date}", method=RequestMethod.GET)
	public List<Studio> listestudioByDateSoumission(@PathVariable("date") String pDate) {
		return studioRepo.getStudioByDateSoumission(pDate);
	
	}//end listestudioByDateSoumission
	
	@RequestMapping(value="/studioList/dateDisposition/{date}", method=RequestMethod.GET)
	public List<Studio> listestudioByDateDisposition(@PathVariable("date") String pDate) {
		return studioRepo.getStudioByDateDisposition(pDate);
	
	}//end listestudioByDateDisposition
	
	@RequestMapping(value="/studioList/superficie/{superficie}", method=RequestMethod.GET)
	public List<Studio> listestudioBySuperficie(@PathVariable("superficie") int pSuperficie) {
		return studioRepo.getStudioBySuperficie(pSuperficie);
	
	}//end listestudioBySuperficie
	
	@RequestMapping(value="/studioList/pieces/{nbPieces}", method=RequestMethod.GET)
	public List<Studio> listeStudioByPieces(@PathVariable("nbPieces") int nbPieces) {
		return studioRepo.getStudioByPieces(nbPieces);
	
	}//end getAllByPieces
	
	
//	@RequestMapping(value="/studioList/visite/{idVisite}", method=RequestMethod.GET)
//	public List<Studio> listestudioByVisite(@PathVariable("idVisite") int pIdVisite) {
//		return studioRepo.getStudioByVisite(pIdVisite);
//	
//	}//end listestudioByVisite
//	
//	@RequestMapping(value="/studioList/contrat/{idContrat}", method=RequestMethod.GET)
//	public List<Studio> listehstudioByContrat(@PathVariable("idContrat") int pIdContrat) {
//		return studioRepo.getStudioByIdContrat(pIdContrat);
//	
//	}//end listestudioByContrat
//	
//	@RequestMapping(value="/studioList/proprietaires/{idProprietaire}", method=RequestMethod.GET)
//	public List<Studio> listestudioByProprietaire(@PathVariable("idProprietaire") int pIdProprietaire) {
//		return studioRepo.getStudioByIdProprietaire(pIdProprietaire);
//	
//	}//end listestudioByContrat
	
}
