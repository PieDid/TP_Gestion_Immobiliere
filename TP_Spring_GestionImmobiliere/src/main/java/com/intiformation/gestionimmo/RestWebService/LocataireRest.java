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

import com.intiformation.gestionimmo.domain.ERole;
import com.intiformation.gestionimmo.domain.Locataire;
import com.intiformation.gestionimmo.domain.Role;
import com.intiformation.gestionimmo.repository.LocataireRepository;
import com.intiformation.gestionimmo.repository.RoleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/locataire-rest")
//@PreAuthorize("hasAnyRole('ADMIN','AGENT')")
public class LocataireRest {

	@Autowired
	private LocataireRepository locataireRepo;
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;

	public void setLocataireRepo(LocataireRepository locataireRepo) {
		this.locataireRepo = locataireRepo;
	}
	
	
	@RequestMapping(value="/locataireList", method=RequestMethod.GET)
	public List<Locataire> listeLocataire() {
		return locataireRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/locataireAdd", method=RequestMethod.POST)
	public void saveLocataire(@RequestBody Locataire locataire) {
		// Encodage
		locataire.setMotDePasse(encoder.encode(locataire.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles = new HashSet<>();
		Role locRole = roleRepository.findByName(ERole.ROLE_LOC)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(locRole);
		locataire.setRoles(roles);
		locataireRepo.save(locataire);
		
	}//end save
	
	@RequestMapping(value="/locataire/{identifiant}", method=RequestMethod.GET)
	public Locataire getLocataire(@PathVariable("identifiant") int pIdLocataire) {
		
		return locataireRepo.getLocataireById(pIdLocataire);
		
	}//end get
	
	
	@RequestMapping(value="/locataireUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upLocataire (@PathVariable("identifiant") int pIdLocataire, @RequestBody Locataire pLocataire) {
		// Encodage
		pLocataire.setMotDePasse(encoder.encode(pLocataire.getMotDePasse()));
		locataireRepo.saveAndFlush(pLocataire);
		
	}//end update
	
	
	@RequestMapping(value="/locataireDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delLocataire(@PathVariable("identifiant") int pIdLocataire) {
		
		locataireRepo.deleteById(pIdLocataire);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
