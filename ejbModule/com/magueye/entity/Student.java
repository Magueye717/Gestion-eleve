package com.magueye.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="ELEVE")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="number")
	private int number;
	
	public Student() {}

	public Student(int id, String name, String surname, int number) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public Student setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Student setSurname(String surname) {
		this.surname = surname;
		return this;
	}

	public int getNumber() {
		return number;
	}

	public Student setNumber(int number) {
		this.number = number;
		return this;
	}
}
