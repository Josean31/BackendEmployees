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

import com.mx.CrudEmployees.entity.Jobs;
import com.mx.CrudEmployees.service.JobsServImpl;

@RestController
@RequestMapping("JobsWS")
@CrossOrigin
public class JobsWS {
	
	@Autowired
	JobsServImpl jobsServImpl;
	
	//LISTAR
	// http://localhost:9001/JobsWS/listar
	@GetMapping("listar")
	public List<Jobs> listar(){
		return jobsServImpl.listar();
	}
	
	//AGREGAR
	// http://localhost:9001/JobsWS/guardar
	@PostMapping("guardar")
	public ResponseEntity<String> guardar(@RequestBody Jobs job){
		for(Jobs j : jobsServImpl.listar()) {
			if(j.getName().equals(job.getName())) {
				return new ResponseEntity<String>("El puesto ya existe", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<String>("Se guardo correctamente el puesto", HttpStatus.OK);
	}


}
