package com.intiformation.gestionimmo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


/**
 * table de jointure entre Agent (immobilier) et Biens
 *
 */
public class Visite implements Serializable{

	//manytoone avec Bien
	
	//manytoOne avec Agent

}
