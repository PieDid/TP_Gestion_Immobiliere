package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Entrepot")
public class Entrepot extends Commerciaux implements Serializable{

	/* ctors */
	public Entrepot() {
		super();
	}
	
	

}
