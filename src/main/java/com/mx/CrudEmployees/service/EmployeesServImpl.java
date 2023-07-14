package com.mx.CrudEmployees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudEmployees.dao.EmployeesDao;
import com.mx.CrudEmployees.entity.Employees;

@Service
public class EmployeesServImpl implements EmployeesServ{
	
	@Autowired
	EmployeesDao empDao;

	@Transactional
	@Override
	public void guardar(Employees employee) {
		// TODO Auto-generated method stub
		empDao.save(employee);
		
	}
	@Transactional
	@Override
	public void editar(Employees employee) {
		// TODO Auto-generated method stub
		empDao.save(employee);
		
	}
	@Transactional
	@Override
	public void eliminar(Employees employee) {
		// TODO Auto-generated method stub
		empDao.delete(employee);
	}
	@Transactional(readOnly=true)
	@Override
	public Employees buscar(Employees employee) {
		// TODO Auto-generated method stub
		return empDao.findById(employee.getId()).orElse(null);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Employees> listar() {
		// TODO Auto-generated method stub
		return (List<Employees>) empDao.findAll();
	}
	
	
	

}
