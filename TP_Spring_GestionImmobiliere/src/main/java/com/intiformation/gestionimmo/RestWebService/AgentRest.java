package com.intiformation.gestionimmo.RestWebService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.Agent;
import com.intiformation.gestionimmo.domain.ERole;
import com.intiformation.gestionimmo.domain.Role;
import com.intiformation.gestionimmo.repository.AgentRepository;
import com.intiformation.gestionimmo.repository.RoleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/agent-rest")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AgentRest {

	
	@Autowired
	private AgentRepository agentRepo;
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;

	public void setAgentRepo(AgentRepository agentRepo) {
		this.agentRepo = agentRepo;
	}
	
	
	@RequestMapping(value="/agentList", method=RequestMethod.GET)
	public List<Agent> listeAgent() {
		return agentRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/agentAdd", method=RequestMethod.POST)
	public void saveAgent(@RequestBody Agent agent) {
		// Encodage
		agent.setMotDePasse(encoder.encode(agent.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles = new HashSet<>();
		Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(agentRole);
		agent.setRoles(roles);
		agentRepo.save(agent);
		
	}//end save
	
	@RequestMapping(value="/agent/{identifiant}", method=RequestMethod.GET)
	public Agent getAgent(@PathVariable("identifiant") int pIdAgent) {
		
		return agentRepo.getAgentById(pIdAgent);
		
	}//end get
	
	
	@RequestMapping(value="/agentUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upAgent (@PathVariable("identifiant") int pIdAgent, @RequestBody Agent pAgent) {
		// Encodage
		pAgent.setMotDePasse(encoder.encode(pAgent.getMotDePasse()));
		agentRepo.saveAndFlush(pAgent);
		
	}//end update
	
	
	@RequestMapping(value="/agentDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delAgent(@PathVariable("identifiant") int pIdAgent) {
		
		agentRepo.deleteById(pIdAgent);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
