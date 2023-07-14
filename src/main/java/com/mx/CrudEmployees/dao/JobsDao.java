package com.mx.CrudEmployees.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.CrudEmployees.entity.Jobs;

public interface JobsDao extends CrudRepository<Jobs, Integer>{

}
