package com.hlm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hlm.bo.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User bo = new User();
		bo.setId(rs.getInt("id"));
		bo.setCreateTime(rs.getDate("create_time"));
		bo.setPassword(rs.getString("password"));
		bo.setSex(rs.getInt("sex"));
		bo.setToken(rs.getString("token"));
		bo.setTokenType(rs.getInt("token_type"));
		bo.setUserCode(rs.getString("user_code"));
		bo.setUserName(rs.getString("user_name"));
		
		return bo;
	}		
}
