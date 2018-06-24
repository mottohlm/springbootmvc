package com.hlm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.hlm.bo.User;
import com.hlm.core.dao.BaseDao;
import com.hlm.dao.UserDao;
import com.hlm.mapper.UserMapper;


@Component
public  class UserDaoImpl extends BaseDao implements UserDao{

	
	@Override
	public int countUser() {

		int count = jdbcTemplate.queryForObject("select count(*) from hlm_users", Integer.class);
		return count;
	}

	@Override
	public int inserUser(User bo) {
		 String sql = "INSERT INTO `hlm_users` (user_code,user_name,sex,token,token_type,create_time,PASSWORD) VALUES(?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps =  connection.prepareStatement(sql , new String[]{"id"});
				ps.setString(1, bo.getUserCode());
				ps.setString(2, bo.getUserName());
				ps.setInt(3, bo.getSex());
				ps.setString(4, bo.getToken());
				ps.setInt(5, bo.getTokenType());
				ps.setDate(6, bo.getCreateTime());
				ps.setString(7, bo.getPassword());
				return ps;
				
			}
		},keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public int deleteUser(User bo) {
		
		return 0;
	}

	@Override
	public void updateUser(User bo) {
		String sql = "UPDATE `hlm_users` s SET s.`password`=?,s.`sex`=?,s.`token`=?,s.`token_type`=?,s.`user_code`=?,s.`user_name`=? WHERE s.`id`=? ";
		jdbcTemplate.update(sql,bo.getPassword(),bo.getSex(),bo.getToken(),bo.getTokenType(),bo.getUserCode(),bo.getUserName(),bo.getId());
		
	}

	@Override
	public List<User> findUserByName(String name) {
		
		return null;
	}

	@Override
	public List<User> findAllUser() {
		String sql = "select * from hlm_users ";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users;
	}
	

}
