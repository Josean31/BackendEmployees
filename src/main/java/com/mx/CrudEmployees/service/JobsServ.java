package com.mx.CrudEmployees.service;

import java.util.List;

import com.mx.CrudEmployees.entity.Jobs;

public interface JobsServ {
	
	public List<Jobs> listar();
	public void guardar(Jobs job);
	public void editar(Jobs job);
	public void eliminar(Jobs job);


}
