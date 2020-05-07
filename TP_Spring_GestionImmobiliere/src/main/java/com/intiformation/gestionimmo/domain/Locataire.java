package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="locataire")
@DiscriminatorValue("ROLE_LOC")
public class Locataire extends Personne implements Serializable{

}
