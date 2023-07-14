package com.mx.CrudEmployees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.CrudEmployees.dao.GendersDao;
import com.mx.CrudEmployees.entity.Genders;

@Service
public class GendersServImpl implements GendersServ{

	@Autowired
	GendersDao gendersDao;
	
	
	@Override
	public List<Genders> listar() {
		// TODO Auto-generated method stub
		return (List<Genders>) gendersDao.findAll();
	}

}
