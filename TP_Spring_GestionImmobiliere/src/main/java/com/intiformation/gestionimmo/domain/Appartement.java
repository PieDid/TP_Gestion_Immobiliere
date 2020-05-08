package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Appartement")
public class Appartement extends Habitation implements Serializable{

	/*    ctor     */
	public Appartement() {
		super();

	}
	
	
	

}
