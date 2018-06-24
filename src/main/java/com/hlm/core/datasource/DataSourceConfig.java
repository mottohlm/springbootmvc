package com.hlm.core.datasource;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean(name="dataSource")
	public DataSource datasource(Environment env){
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl(env.getProperty("datasource.url"));
		ds.setUsername(env.getProperty("datasource.username"));
		ds.setPassword(env.getProperty("datasource.password"));
		ds.setDriverClassName(env.getProperty("datasource.driver-class"));
		return ds ;
	}
}
