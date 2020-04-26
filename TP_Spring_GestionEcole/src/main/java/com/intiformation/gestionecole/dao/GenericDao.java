package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.domain.Adresse;
import com.intiformation.gestionecole.domain.Aide;
import com.intiformation.gestionecole.domain.Cours;
import com.intiformation.gestionecole.domain.Enseigne;
import com.intiformation.gestionecole.domain.Etudiant;
import com.intiformation.gestionecole.domain.EtudiantCours;
import com.intiformation.gestionecole.domain.Matiere;
import com.intiformation.gestionecole.domain.Personne;
import com.intiformation.gestionecole.domain.Promotion;

@Repository
@Transactional
public class GenericDao<T> implements IGenericDao<T>{

	//props
	protected Class<T> entityClass;

	
	@Autowired
	private SessionFactory sessionFactory;
	

	/*_________________ getters|setters ________________*/
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	/*_________________ ctor ________________*/
	
	
	public GenericDao(Class<T> entityClass) {
		this.entityClass = entityClass;
		System.out.println("Classe e entityClass : " + entityClass.getClass());
		System.out.println("entitynameName : " + entityClass.getClass().getSimpleName().substring(0).toLowerCase());
	}


	/**
	 * ctor vide pour l'injection spring
	 */
	public GenericDao() {}
	/*_________________ méthodes ________________*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		//String entityName = (entityClass).getSimpleName().substring(0).toLowerCase();
		String entityName = "";
		
		if(this.entityClass.getClass().equals(Cours.class)) {
			entityName = "cours";
		}
		if(this.entityClass.getClass().equals(Personne.class)) {
			entityName = "personne";
		}
		if(this.entityClass.getClass().equals(Aide.class)) {
			entityName = "aide";
		}
		if(this.entityClass.getClass().equals(Adresse.class)) {
			entityName = "adresse";
		}
		if(this.entityClass.getClass().equals(Enseigne.class)) {
			entityName = "enseigne";
		}
		if(this.entityClass.getClass().equals(EtudiantCours.class)) {
			entityName = "etudiantCours";
		}
		if(this.entityClass.getClass().equals(Matiere.class)) {
			entityName = "matiere";
		}
		if(this.entityClass.getClass().equals(Promotion.class)) {
			entityName = "promotion";
		}
		
		
		System.out.println("CONTROLL :: Nom de l'entité : " + entityName);
		String clauseFROM = "FROM " + entityName + " e";
		//String clauseFROM = "FROM cours e";
		return sessionFactory.getCurrentSession().createQuery(clauseFROM).getResultList();
	}




	@Override
	public T getById(int id) {
		return sessionFactory.getCurrentSession().find(entityClass, id);
	}

	@Override
	public T getByLibelle(String libelle) {
		return sessionFactory.getCurrentSession().find(entityClass, libelle);
	}


	// Supprime un étudiant
	public void delete(int id) {
		sessionFactory.getCurrentSession().remove(getById(id));
	}
	
	@Override
	public void delete(String pLibelle) {
		sessionFactory.getCurrentSession().remove(getByLibelle(pLibelle));
		
	}
	
	// Ajoute un étudiant
	@Override
	public void add(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}
	
	// Modifie un étudiant
	@Override
	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}
	
	
}
