package org.spring.dao;

import org.spring.model.User;
import org.springframework.stereotype.Repository;

//@Component ("userDao")
@Repository ("userDao")
public class UserDao {
	public void add(User user) {
		System.out.println("添加了"+user);
	}

	public void delete(int id) {
		System.out.println("删除了"+id);
	}

	public User load(int id) {
		System.out.println("load: "+id);
		return null;
	}
}
