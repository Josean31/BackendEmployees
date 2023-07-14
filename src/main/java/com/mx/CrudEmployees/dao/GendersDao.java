package com.mx.CrudEmployees.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmployees.entity.Genders;

public interface GendersDao extends CrudRepository<Genders, Integer>{

}
