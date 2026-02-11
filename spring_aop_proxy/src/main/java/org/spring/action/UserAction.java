package org.spring.action;


import jakarta.annotation.Resource;

import org.spring.model.User;
import org.spring.service.UserServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

//@Component ("userAction") //此步相当于<bean id="userAction" class="org.spring.action.UserAction" />
@Controller ("userAction") //注意任何Component到左括号间必须有个空格，否则注入不生效
@Scope ("prototype") //默认为singleton模式
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

	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	@Resource //此步相当于<property name="userServiceImpl" ref="userServiceImpl"></property>
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	public UserAction() {
		
	}
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
