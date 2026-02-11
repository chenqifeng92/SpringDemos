package org.spring.service;

import org.spring.dao.MessageDao;
import org.spring.dao.UserDao;
import org.spring.model.User;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

//@Component ("userServiceImpl")
@Service ("userServiceImpl")
public class UserServiceImpl implements UserService {

	private UserDao userDaoImpl;
	private MessageDao messageDaoImpl;

	public MessageDao getMessageDaoImpl() {
		return messageDaoImpl;
	}

	@Resource(name="messageDaoImpl")
	public void setMessageDaoImpl(MessageDao messageDaoImpl) {
		this.messageDaoImpl = messageDaoImpl;
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	@Resource (name="userDaoImpl")
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public void add(User user) {
		messageDaoImpl.add();
		userDaoImpl.add(user);
	}

	@Override
	public void delete(int id) {
		messageDaoImpl.delete();
		userDaoImpl.delete(id);
	}

	@Override
	public User load(int id) {
		return userDaoImpl.load(id);
	}

}
