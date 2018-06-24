package com.hlm.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public  abstract class BaseDao {
	
	@Autowired
	public  JdbcTemplate jdbcTemplate ;
}
