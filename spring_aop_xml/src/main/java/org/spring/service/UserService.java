package org.spring.service;

import org.spring.model.User;

public interface UserService {
	public void add(User user);
	public void delete(int id);
	public User load(int id);
	
}
