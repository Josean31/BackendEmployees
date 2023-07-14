package com.mx.CrudEmployees.service;

import java.util.List;

import com.mx.CrudEmployees.entity.EmployeeWorkedHours;

public interface EmployeeWorkedHoursServ {
	
	public void guardar(EmployeeWorkedHours hours);
	public void editar(EmployeeWorkedHours hours);

	public void eliminar(EmployeeWorkedHours hours);

	public EmployeeWorkedHours buscar(EmployeeWorkedHours hours);

	public List<EmployeeWorkedHours> listar();

	

}
