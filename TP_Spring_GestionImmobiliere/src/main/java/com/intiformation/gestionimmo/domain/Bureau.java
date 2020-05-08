package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bureau")
public class Bureau extends Commerciaux implements Serializable{

	/* ctors */
	public Bureau() {
		super();
	}

}
