package com.mx.CrudEmployees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.CrudEmployees.dao.EmployeeWorkedHoursDao;
import com.mx.CrudEmployees.entity.EmployeeWorkedHours;

@Service
public class EmployeeWorkedHoursServImpl implements EmployeeWorkedHoursServ{
	
	@Autowired
	EmployeeWorkedHoursDao hoursDao;

	@Transactional
	@Override
	public void guardar(EmployeeWorkedHours hours) {
		// TODO Auto-generated method stub
		hoursDao.save(hours);
	}
	@Transactional
	@Override
	public void editar(EmployeeWorkedHours hours) {
		// TODO Auto-generated method stub
		hoursDao.save(hours);
		
	}

	@Transactional
	@Override
	public void eliminar(EmployeeWorkedHours hours) {
		// TODO Auto-generated method stub
		hoursDao.delete(hours);
	}

	@Transactional(readOnly=true)
	@Override
	public EmployeeWorkedHours buscar(EmployeeWorkedHours hours) {
		// TODO Auto-generated method stub
		return hoursDao.findById(hours.getId()).orElse(null);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<EmployeeWorkedHours> listar() {
		// TODO Auto-generated method stub
		return (List<EmployeeWorkedHours>) hoursDao.findAll();
	}

}
