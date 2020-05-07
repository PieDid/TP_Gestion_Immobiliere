package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="bien")
@Table(name="biens")
public class Bien implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment
	@Column(name="id_bien")
	private int id_bien;
	
	@Column(name="statut")
	private String statut;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "standard_id", referencedColumnName = "id_standard") 
	private Standard standard;
	
}
