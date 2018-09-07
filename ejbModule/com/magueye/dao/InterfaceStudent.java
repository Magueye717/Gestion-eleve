package com.magueye.dao;

import java.util.List;

import javax.ejb.Local;

import com.magueye.entity.Student;

@Local
public  interface InterfaceStudent {
	
	public void addStudent(Student student);
	public void removeStudent(int id);
	public List<Student> GetAllStudent();
	public List<Student> GetStudentParMC(String mc);
	public Student getStudent(int id);
	public void updateStudent(Student s);
	
	

}
