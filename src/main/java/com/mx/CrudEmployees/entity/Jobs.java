package com.mx.CrudEmployees.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="JOBS")
public class Jobs {

	@Id
	int id;
	
	String name;
	
	float salary;
	
	//CARDINALIDAD ONE TO MANY
	@OneToMany(mappedBy="job",cascade=CascadeType.ALL)
	List<Employees> lista = new ArrayList<Employees>();

	public Jobs() {
	}

	public Jobs(int id) {
		this.id = id;
	}

	public Jobs(int id, String name, float salary, List<Employees> lista) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", name=" + name + ", salary=" + salary + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	
	
}
