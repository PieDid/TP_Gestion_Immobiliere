package com.intiformation.gestionimmo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity(name="role")
@Table(name="roles")
public class Role {
	
	/*_________________ props ________________*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	
	/*_________________ ctors ________________*/

	public Role() {
		super();
	}

	public Role(ERole name) {
		super();
		this.name = name;
	}

	/*_____________ Getters/Setters _____________*/
	

	public ERole getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(ERole name) {
		this.name = name;
	}
	
	
	

}
