package com.mx.CrudEmployees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudEmployees.dao.JobsDao;
import com.mx.CrudEmployees.entity.Jobs;

@Service
public class JobsServImpl implements JobsServ{

	@Autowired
	JobsDao jobsDao;
	@Override
	public List<Jobs> listar() {
		// TODO Auto-generated method stub
		return (List<Jobs>) jobsDao.findAll();
	}
	@Override
	public void guardar(Jobs job) {
		// TODO Auto-generated method stub
		jobsDao.save(job);
		
	}
	@Override
	public void editar(Jobs job) {
		// TODO Auto-generated method stub
		jobsDao.save(job);
	}
	@Override
	public void eliminar(Jobs job) {
		// TODO Auto-generated method stub
		jobsDao.delete(job);
	}

}
