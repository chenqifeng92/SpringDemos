package org.spring.action;

import org.spring.model.User;
import org.spring.service.UserServiceImpl;

public class UserAction {
	private User user;
	private UserServiceImpl userServiceImpl;
	private int id;

	//functions
	public void add() {
		userServiceImpl.add(user);
	}
	
	public void delete() {
		userServiceImpl.delete(id);
	}
	
	public void load(int id) {
		userServiceImpl.load(id);
	}
	//getters and setters

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}*/
	
	public UserAction(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
