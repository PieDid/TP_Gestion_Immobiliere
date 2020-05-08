package com.intiformation.gestionimmo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Commerce")
public class Commerce extends Commerciaux{

	/* ctors */
	public Commerce() {
		super();
	}

	
}
