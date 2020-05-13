package com.intiformation.gestionimmo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intiformation.gestionimmo.domain.ERole;
import com.intiformation.gestionimmo.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {


	
	Optional<Role> findByName(ERole name);
	
}
