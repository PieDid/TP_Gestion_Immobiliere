package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Maison")
public class Maison extends Habitation implements Serializable{

	public Maison() {
		super();
	}
	
}
