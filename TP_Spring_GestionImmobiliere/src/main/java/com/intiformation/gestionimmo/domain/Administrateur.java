package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="admin")
@DiscriminatorValue("ROLE_ADMIN")
public class Administrateur extends Personne implements Serializable{

}
