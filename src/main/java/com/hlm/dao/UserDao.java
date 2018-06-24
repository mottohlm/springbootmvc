package com.hlm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hlm.bo.User;


public  interface UserDao {
	

	/**
	 * 查询用户总数
	 * @return
	 */
	public int countUser();

	/**
	 * 新增用户,新增成功返回id
	 * @param bo
	 */
	public int inserUser(User bo);
	
	/**
	 * 删除用户，删除成功返回用户ID，否则返回空
	 * @param bo
	 * @return
	 */
	public int deleteUser(User bo);
	
	/**
	 * 更新用户
	 * @param bo
	 */
	public void updateUser(User bo);
	
	/**
	 * 通过用户名去查找用户
	 * @param name
	 */
	public List<User> findUserByName(String name);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<User> findAllUser();

}
