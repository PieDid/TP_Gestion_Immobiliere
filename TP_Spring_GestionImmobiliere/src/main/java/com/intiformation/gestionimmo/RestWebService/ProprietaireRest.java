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
import com.intiformation.gestionimmo.domain.Proprietaire;
import com.intiformation.gestionimmo.domain.Role;
import com.intiformation.gestionimmo.repository.ProprietaireRepository;
import com.intiformation.gestionimmo.repository.RoleRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/proprietaire-rest")
public class ProprietaireRest {

	@Autowired
	private ProprietaireRepository proprioRepo;
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;

	public void setProprioRepo(ProprietaireRepository proprioRepo) {
		this.proprioRepo = proprioRepo;
	}
	
	
	@RequestMapping(value="/proprietaireList", method=RequestMethod.GET)
	public List<Proprietaire> listeProprietaire() {
		return proprioRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/proprietaireAdd", method=RequestMethod.POST)
	public void saveProprietaire(@RequestBody Proprietaire proprietaire) {
		// Encodage
		proprietaire.setMotDePasse(encoder.encode(proprietaire.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles = new HashSet<>();
		Role propRole = roleRepository.findByName(ERole.ROLE_PROP)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(propRole);
		proprietaire.setRoles(roles);
		proprioRepo.save(proprietaire);
		
	}//end save
	
	@RequestMapping(value="/proprietaire/{identifiant}", method=RequestMethod.GET)
	public Proprietaire getProprietaire(@PathVariable("identifiant") int pIdProprietaire) {
		
		return proprioRepo.getProprietaireById(pIdProprietaire);
		
	}//end get
	
	
	@RequestMapping(value="/proprietaireUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upProprietaire (@PathVariable("identifiant") int pIdProprietaire, @RequestBody Proprietaire pProprietaire) {
		
		// Encodage
		pProprietaire.setMotDePasse(encoder.encode(pProprietaire.getMotDePasse()));
		proprioRepo.saveAndFlush(pProprietaire);
		
	}//end update
	
	
	@RequestMapping(value="/proprietaireDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delProprietaire(@PathVariable("identifiant") int pIdProprietaire) {
		
		proprioRepo.deleteById(pIdProprietaire);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	
}
