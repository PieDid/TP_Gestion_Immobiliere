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

import com.intiformation.gestionimmo.domain.Client;
import com.intiformation.gestionimmo.domain.ERole;
import com.intiformation.gestionimmo.domain.Role;
import com.intiformation.gestionimmo.repository.ClientRepository;
import com.intiformation.gestionimmo.repository.RoleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client-rest")
public class ClientRest {

	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	

	public void setClientRepo(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}
	
	
	@RequestMapping(value="/clientList", method=RequestMethod.GET)
	public List<Client> listeClient() {
		return clientRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/clientAdd", method=RequestMethod.POST)
	public void saveClient(@RequestBody Client client) {
		// Encodage
		client.setMotDePasse(encoder.encode(client.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles = new HashSet<>();
		Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(clientRole);
		client.setRoles(roles);
		clientRepo.save(client);
		
	}//end save
	
	@RequestMapping(value="/client/{identifiant}", method=RequestMethod.GET)
	public Client getClient(@PathVariable("identifiant") int pIdClient) {
		
		return clientRepo.getClientById(pIdClient);
		
	}//end get
	
	
	@RequestMapping(value="/clientUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upClient (@PathVariable("identifiant") int pIdClient, @RequestBody Client pClient) {
		// Encodage
		pClient.setMotDePasse(encoder.encode(pClient.getMotDePasse()));
		clientRepo.saveAndFlush(pClient);
		
	}//end update
	
	
	@RequestMapping(value="/clientDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delClient(@PathVariable("identifiant") int pIdClient) {
		
		clientRepo.deleteById(pIdClient);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
