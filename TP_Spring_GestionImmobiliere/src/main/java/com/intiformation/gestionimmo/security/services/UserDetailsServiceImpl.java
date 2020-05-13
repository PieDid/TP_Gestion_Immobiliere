package com.intiformation.gestionimmo.security.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.intiformation.gestionimmo.domain.Personne;
import com.intiformation.gestionimmo.repository.PersonneRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	PersonneRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
		Personne user = userRepository.findByNom(nom)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + nom));

		return UserDetailsImpl.build(user);
	}
}
