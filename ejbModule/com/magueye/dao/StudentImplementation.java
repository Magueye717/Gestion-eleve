package com.magueye.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.magueye.entity.Student;

@Stateless(name="ELV")
public class StudentImplementation implements InterfaceStudent {
 
	@PersistenceContext(unitName="UP_ELEVE")
       private EntityManager em;
	
	//Ajouter un eleve
	@Override
	public void addStudent(Student student) {
		em.persist(student);
	}
     
	//suprimer un eleve :besoin de connaitre l'ID
	@Override
	public void removeStudent(int id) {
		Student s=em.find(Student.class, id);
		if(s==null) throw new RuntimeException("eleve inexistant");
		em.remove(s);
	}

	//afficher tous les eleve
	@Override
	public List<Student> GetAllStudent() {
		Query req=em.createQuery("select s from Student s");
		return req.getResultList();
	}

	//afficher la liste des eleve par mot clé
	@Override
	public List<Student> GetStudentParMC(String mc) {
		Query req=em.createQuery
				("select s from Student s where p.nomStudent like:x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	//consulter un eleve sachant son ID
	@Override
	public Student getStudent(int id) {
		Student s=em.find(Student.class, id);
		return s;
	}

	//mettre à jour
	@Override
	public void updateStudent(Student s) {
		Student s1=em.find(Student.class, s.getId());
		s1.setName(s.getName());
		s1.setSurname(s.getSurname());
		em.merge(s);
		
	}

}
