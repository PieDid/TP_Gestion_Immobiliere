package com.intiformation.gestionimmo.RestWebService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intiformation.gestionimmo.domain.ERole;
import com.intiformation.gestionimmo.domain.Personne;
import com.intiformation.gestionimmo.domain.Role;
import com.intiformation.gestionimmo.payload.request.LoginRequest;
import com.intiformation.gestionimmo.payload.request.SignupRequest;
import com.intiformation.gestionimmo.payload.response.JwtResponse;
import com.intiformation.gestionimmo.payload.response.MessageResponse;
import com.intiformation.gestionimmo.repository.PersonneRepository;
import com.intiformation.gestionimmo.repository.RoleRepository;
import com.intiformation.gestionimmo.security.jwt.JwtUtils;
import com.intiformation.gestionimmo.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth-rest")
public class AuthRest {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PersonneRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByNom(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Personne user = new Personne(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

//		ROLE_CLIENT,
//		ROLE_PROP,
//		ROLE_AGENT,
//		ROLE_ADMIN,
//		ROLE_LOC
		if (strRoles == null) {
			Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(clientRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "prop":
					Role propRole = roleRepository.findByName(ERole.ROLE_PROP)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(propRole);

					break;
					
				case "agent":
					Role agentRole = roleRepository.findByName(ERole.ROLE_AGENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(agentRole);

					break;
					
				case "loc":
					Role locRole = roleRepository.findByName(ERole.ROLE_LOC)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(locRole);

					break;
					
				case "client":
					Role clientRole = roleRepository.findByName(ERole.ROLE_CLIENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(clientRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_CLIENT)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
