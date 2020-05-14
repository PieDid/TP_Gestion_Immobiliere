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

import com.intiformation.gestionimmo.repository.AdministrateurRepository;
import com.intiformation.gestionimmo.repository.RoleRepository;
import com.intiformation.gestionimmo.domain.Administrateur;
import com.intiformation.gestionimmo.domain.ERole;
import com.intiformation.gestionimmo.domain.Role;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/administrateur-rest")
//@PreAuthorize("hasRole('ADMIN')")
public class AdministrateurRest {
	
	@Autowired
	private AdministrateurRepository adminRepo;
	
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;

	public void setAdminRepo(AdministrateurRepository adminRepo) {
		this.adminRepo = adminRepo;
	}
	
	
	@RequestMapping(value="/administrateurList", method=RequestMethod.GET)
	public List<Administrateur> listeAdmin() {
		return adminRepo.findAll();
	
	}//end getall	
	
	
	@RequestMapping(value="/administrateurAdd", method=RequestMethod.POST)
	public void saveAdmin(@RequestBody Administrateur admin) {
		// Encodage
		admin.setMotDePasse(encoder.encode(admin.getMotDePasse()));
		//Ajout du rôle
		Set<Role> roles = new HashSet<>();
		Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(adminRole);
		admin.setRoles(roles);
		adminRepo.save(admin);
		
	}//end save
	
	@RequestMapping(value="/administrateur/{identifiant}", method=RequestMethod.GET)
	public Administrateur getAdmin(@PathVariable("identifiant") int pIdAdmin) {
		
		return adminRepo.getAdministrateurById(pIdAdmin);
		
	}//end get
	
	
	@RequestMapping(value="/administrateurUpdate/{identifiant}", method=RequestMethod.PUT)
	public void upAdmin (@PathVariable("identifiant") int pIdAdmin, @RequestBody Administrateur pAdmin) {
		// Encodage
		pAdmin.setMotDePasse(encoder.encode(pAdmin.getMotDePasse()));
		adminRepo.saveAndFlush(pAdmin);
		
	}//end update
	
	
	@RequestMapping(value="/administrateurDelete/{identifiant}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delAdmin(@PathVariable("identifiant") int pIdAdmin) {
		
		adminRepo.deleteById(pIdAdmin);
		
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}//end delete
	
	

}//end class
