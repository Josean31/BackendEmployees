package com.mx.CrudEmployees.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPLOYEES")
public class Employees {

	@Id
	int id;

	// CARDINALIDAD GENDER_ID many to one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENDER_ID")
	Genders gender;

	// CARDINALIDAD JOB_ID
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "JOB_ID")
	Jobs job;

	String name;
	String last_name;
	LocalDate birthdate;

	// CARDINALIDAD employee_worked_hours
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	List<EmployeeWorkedHours> lista = new ArrayList<EmployeeWorkedHours>();

	
	
	
	public Employees() {
	}


	public Employees(int id) {
		this.id = id;
	}


	public Employees(int id, Genders gender, Jobs job, String name, String last_name, LocalDate birthdate,
			List<EmployeeWorkedHours> lista) {
		this.id = id;
		this.gender = gender;
		this.job = job;
		this.name = name;
		this.last_name = last_name;
		this.birthdate = birthdate;
		this.lista = lista;
	}


	@Override
	public String toString() {
		return "Employees [id=" + id + ", gender=" + gender + ", job=" + job + ", name=" + name + ", last_name="
				+ last_name + ", birthdate=" + birthdate + "]\n";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Genders getGender() {
		return gender;
	}


	public void setGender(Genders gender) {
		this.gender = gender;
	}


	public Jobs getJob() {
		return job;
	}


	public void setJob(Jobs job) {
		this.job = job;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public LocalDate getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	
	
	

}
