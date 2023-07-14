package com.mx.CrudEmployees.service;

import java.util.List;

import com.mx.CrudEmployees.entity.Employees;

public interface EmployeesServ {
	
	public void guardar(Employees employee);
	public void editar(Employees employee);

	public void eliminar(Employees employee);

	public Employees buscar(Employees employee);

	public List<Employees> listar();


}
