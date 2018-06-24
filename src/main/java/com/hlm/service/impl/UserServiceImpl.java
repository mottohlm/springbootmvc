package com.hlm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hlm.bo.User;
import com.hlm.dao.UserDao;
import com.hlm.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int countUser() {
		
		return userDao.countUser();
	}

	@Override
	public int inserUser(User bo) {

		return userDao.inserUser(bo);
	}

	@Override
	public int deleteUser(User bo) {
		return 0;
	}

	@Override
	public void updateUser(User bo) {
		userDao.updateUser(bo);
		
	}

	@Override
	public List<User> findUserByName(String name) {
		
		return userDao.findUserByName(name);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

}
