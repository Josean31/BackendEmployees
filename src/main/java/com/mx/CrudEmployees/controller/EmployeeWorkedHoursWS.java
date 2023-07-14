package com.mx.CrudEmployees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.CrudEmployees.entity.EmployeeWorkedHours;
import com.mx.CrudEmployees.entity.Employees;
import com.mx.CrudEmployees.service.EmployeeWorkedHoursServImpl;
import com.mx.CrudEmployees.service.EmployeesServImpl;

@RestController
@RequestMapping("EmployeeWorkedHoursWS")
@CrossOrigin
public class EmployeeWorkedHoursWS {

	@Autowired
	EmployeeWorkedHoursServImpl hoursServImpl;
	
	@Autowired
	EmployeesServImpl empServImpl;

	// LISTAR
	// http://localhost:9001/EmployeeWorkedHoursWS/listar
	@GetMapping("listar")
	public List<EmployeeWorkedHours> listar(){
		return hoursServImpl.listar();
	}
	
	//AGREGAR
	// http://localhost:9001/EmployeeWorkedHoursWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody EmployeeWorkedHours workedHours){
		for(Employees e: empServImpl.listar()) {
			if(e.getId()==workedHours.getEmployee().getId()) {
				hoursServImpl.guardar(workedHours);
				return new ResponseEntity<String>("Horas registradas", HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>("No existe el empleado", HttpStatus.BAD_REQUEST);
		
	}

	

}
