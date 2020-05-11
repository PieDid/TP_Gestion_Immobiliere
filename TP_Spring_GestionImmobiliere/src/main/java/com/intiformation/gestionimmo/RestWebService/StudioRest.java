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
		
		return studioRepo.getOne(pIdstudio);
		
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
	
	
	
	@RequestMapping(value="/studioList/{offre}", method=RequestMethod.GET)
	public List<Studio> listestudioByOffre(@PathVariable("offre") String pOffre) {
		return studioRepo.getStudioByOffre(pOffre);
	
	}//end getAllByOffre
}
