package org.spring.service;

import jakarta.annotation.Resource;

import org.spring.dao.UserDao;
import org.spring.model.User;
import org.springframework.stereotype.Service;

//@Component ("userServiceImpl")
@Service ("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	//默认通过名称来注入
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public User load(int id) {
		
		return userDao.load(id);
	}

}
