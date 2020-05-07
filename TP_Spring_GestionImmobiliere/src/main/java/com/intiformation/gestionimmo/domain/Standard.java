package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity(name="standard")
@Table(name="standards")
public class Standard implements Serializable{

	private String codeDeClasse;
}
