package org.spring.dao;

import org.spring.model.LogInfo;
import org.spring.model.User;

public interface UserDao{
	@LogInfo("通过LogInfo添加用户信息")
	public void add(User user);
	@LogInfo("通过LogInfo删除用户信息")
	public void delete(int id);
	public User load(int id);
}
