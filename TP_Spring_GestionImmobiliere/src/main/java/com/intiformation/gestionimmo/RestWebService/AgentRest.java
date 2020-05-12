package com.intiformation.gestionimmo.RestWebService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Agent;
import com.intiformation.gestionimmo.repository.AgentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/agent-rest")
public class AgentRest {

	
	@Autowired
	private AgentRepository agentRepo;

	public void setAgentRepo(AgentRepository agentRepo) {
		this.agentRepo = agentRepo;
	}
	
	
	@RequestMapping(value="/agentList", method=RequestMethod.GET)
	public List<Agent> listeAgent() {
		return agentRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/agentAdd", method=RequestMethod.POST)
	public void saveAgent(@RequestBody Agent agent) {
		
		agentRepo.save(agent);
		
	}//end save
	
	@RequestMapping(value="/agent/{identifiant}", method=RequestMethod.GET)
	public Agent getAgent(@PathVariable("identifiant") int pIdAgent) {
		
		return agentRepo.getAgentById(pIdAgent);
		
	}//end get
	
	
	@RequestMapping(value="/agentUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upAgent (@PathVariable("identifiant") int pIdAgent, @RequestBody Agent pAgent) {
		
		agentRepo.saveAndFlush(pAgent);
		
	}//end update
	
	
	@RequestMapping(value="/agentDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delAgent(@PathVariable("identifiant") int pIdAgent) {
		
		agentRepo.deleteById(pIdAgent);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
