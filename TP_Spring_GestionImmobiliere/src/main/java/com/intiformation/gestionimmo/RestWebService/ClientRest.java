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

import com.intiformation.gestionimmo.domain.Client;
import com.intiformation.gestionimmo.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client-rest")
public class ClientRest {

	
	@Autowired
	private ClientRepository clientRepo;

	public void setClientRepo(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}
	
	
	@RequestMapping(value="/clientList", method=RequestMethod.GET)
	public List<Client> listeClient() {
		return clientRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/clientAdd", method=RequestMethod.POST)
	public void saveClient(@RequestBody Client client) {
		
		clientRepo.save(client);
		
	}//end save
	
	@RequestMapping(value="/client/{identifiant}", method=RequestMethod.GET)
	public Client getClient(@PathVariable("identifiant") int pIdClient) {
		
		return clientRepo.getClientById(pIdClient);
		
	}//end get
	
	
	@RequestMapping(value="/clientUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upClient (@PathVariable("identifiant") int pIdClient, @RequestBody Client pClient) {
		
		clientRepo.saveAndFlush(pClient);
		
	}//end update
	
	
	@RequestMapping(value="/clientDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delClient(@PathVariable("identifiant") int pIdClient) {
		
		clientRepo.deleteById(pIdClient);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
