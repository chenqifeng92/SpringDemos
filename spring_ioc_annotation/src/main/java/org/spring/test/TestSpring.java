package org.spring.test;

import org.junit.Test;
import org.spring.action.UserAction;
import org.spring.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	//创建spring工厂
	private BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testUser() {
		UserAction ua = factory.getBean("userAction",UserAction.class);
		User u = new User(1,"张三",2000,22);
		ua.setUser(u);
		ua.add();
		
		UserAction ua2 = factory.getBean("userAction",UserAction.class);
		//User u2 = new User(2,"李四",2000,21);
		//ua2.setUser(u2);
		ua2.add();
	}
}
