package com.mx.CrudEmployees.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmployees.entity.Employees;

public interface EmployeesDao  extends CrudRepository<Employees, Integer>{

}
