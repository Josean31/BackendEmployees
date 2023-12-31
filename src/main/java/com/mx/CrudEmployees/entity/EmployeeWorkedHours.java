package com.mx.CrudEmployees.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLOYEE_WORKED_HOURS")
public class EmployeeWorkedHours {
	
	@Id
	int id;
	
	//CARDINALIDAD Employee_id many to one
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="EMPLOYEE_ID")
	Employees employee;
	
	
	int worked_hours;
	
	Date worked_date;

	public EmployeeWorkedHours() {
	}

	public EmployeeWorkedHours(int id) {
		this.id = id;
	}

	public EmployeeWorkedHours(int id, Employees employee, int worked_hours, Date worked_date) {
		this.id = id;
		this.employee = employee;
		this.worked_hours = worked_hours;
		this.worked_date = worked_date;
	}

	@Override
	public String toString() {
		return "EmployeeWorkedHours [id=" + id + ", employee=" + employee + ", worked_hours=" + worked_hours
				+ ", worked_date=" + worked_date + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public int getWorked_hours() {
		return worked_hours;
	}

	public void setWorked_hours(int worked_hours) {
		this.worked_hours = worked_hours;
	}

	public Date getWorked_date() {
		return worked_date;
	}

	public void setWorked_date(Date worked_date) {
		this.worked_date = worked_date;
	}
	
	

}
