package com.intiformation.gestionimmo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="photo")
@Table(name="photos")
@Proxy(lazy = false)
public class Photo implements Serializable{

	/*_________________ props ________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_photo")
	private int id_photo;
	
	@Column(name="photo")
	private String photo;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="bien_id", referencedColumnName="id_bien")
	private Bien bien;
	
	
	
	/*_________________ ctors ________________*/
	public Photo() {
		super();
	}

	public Photo(String photo) {
		super();
		this.photo = photo;
	}
	
	public Photo(int id_photo, String photo) {
		super();
		this.id_photo = id_photo;
		this.photo = photo;
	}

	
	
	
	/*_________________ méthodes ________________*/
	@Override
	public String toString() {
		return "Photo [id_photo=" + id_photo + ", photo=" + photo + "]";
	}

	
	
	/*_________________ getters|setters ________________*/
	public int getId_photo() {
		return id_photo;
	}

	public void setId_photo(int id_photo) {
		this.id_photo = id_photo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
