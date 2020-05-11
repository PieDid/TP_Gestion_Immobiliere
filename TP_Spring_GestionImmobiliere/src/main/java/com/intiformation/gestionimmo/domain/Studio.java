package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name="studio")
@DiscriminatorValue("Studio")
public class Studio extends Habitation implements Serializable{

	/*_________________ ctors ________________*/
	public Studio() {
		super();
	}

	
}
