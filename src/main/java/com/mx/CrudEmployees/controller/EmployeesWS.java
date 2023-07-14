package com.mx.CrudEmployees.controller;

import java.time.LocalDate;
import java.time.Period;

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

import com.mx.CrudEmployees.entity.Employees;

import com.mx.CrudEmployees.service.EmployeesServImpl;


@RestController
@RequestMapping("EmployeesWS")
@CrossOrigin
public class EmployeesWS {

	@Autowired
	EmployeesServImpl empServImpl;



	// LISTAR
	// http://localhost:9001/EmployeesWS/listar
	@GetMapping("listar")
	public List<Employees> listar() {
		return empServImpl.listar();
	}

	// GUARDAR
	// http://localhost:9001/EmployeesWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody Employees employee) {
		LocalDate currentDate = LocalDate.now();
		LocalDate birthDate = employee.getBirthdate();
		int edad = Period.between(birthDate, currentDate).getYears();

		// VALIDAR NOMBRES
		for (Employees e : empServImpl.listar()) {
			if (e.getName().equals(employee.getName()) && e.getLast_name().equals(employee.getLast_name())) {
				return new ResponseEntity<String>("Ya existe un empleado con ese nombre", HttpStatus.BAD_REQUEST);
			}
		}

		// VALIDAR EDAD
		if (edad < 18) {
			return new ResponseEntity<String>("El empleado debe de ser mayor de edad", HttpStatus.BAD_REQUEST);
		}
		
		//VALIDAR GENERO Y TRABAJO
		try {
			empServImpl.guardar(employee);
			return new ResponseEntity<String>("Empleado guardado correctamente", HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Datos incorrectos, ingrese un genero y trabajo validos", HttpStatus.BAD_REQUEST);

		}

	}

	// EDITAR
	// http://localhost:9001/EmployeesWS/editar
	@PostMapping("editar")
	public ResponseEntity<String> editar(@RequestBody Employees employee) {
		LocalDate currentDate = LocalDate.now();
		LocalDate birthDate = employee.getBirthdate();
		int edad = Period.between(birthDate, currentDate).getYears();

		// VALIDAR EDAD
		if (edad < 18) {
			return new ResponseEntity<String>("El empleado debe de ser mayor de edad", HttpStatus.BAD_REQUEST);
		}
		
		//VALIDAR GENERO Y TRABAJO
		try {
			empServImpl.guardar(employee);
			return new ResponseEntity<String>("Empleado editado correctamente", HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Datos incorrectos, ingrese un genero y trabajo validos", HttpStatus.BAD_REQUEST);

		}

	}

	// ELIMINAR
	// http://localhost:9001/EmployeesWS/eliminar
	@PostMapping("eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Employees employee) {
		empServImpl.eliminar(employee);
		return new ResponseEntity<String>("El empleado se elimino correctamente", HttpStatus.OK);

	}
	
	
	//BUSCAR
	// http://localhost:9001/EmployeesWS/buscar
	@PostMapping("buscar")
	public Employees buscar(@RequestBody Employees employee) {
		return empServImpl.buscar(employee);
	}

}
