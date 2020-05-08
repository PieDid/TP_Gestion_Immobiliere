package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="administrateur")
@DiscriminatorValue("ROLE_ADMIN")
public class Administrateur extends Personne implements Serializable{

	@Override
	public String toString() {
		return "Administrateur [" + super.toString() + "]";
	}
	
}
