package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="client")
@DiscriminatorValue("ROLE_CLIENT")
public class Client extends Personne implements Serializable{

}
