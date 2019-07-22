package org.spring.test;

import org.junit.Test;
import org.spring.action.UserAction;
import org.spring.model.HelloWorld;
import org.spring.model.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	//创建spring工厂
	private BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testIXHello() {
		//通过工厂获取spring的对象
		//HelloWorld hello = (HelloWorld)factory.getBean("helloWorld");
		HelloWorld hello = factory.getBean("helloWorld",HelloWorld.class);
		
		HelloWorld hello2 = factory.getBean("helloWorld",HelloWorld.class);
		
		System.out.println(hello);//org.spring.model.HelloWorld@1c3a4799
		System.out.println(hello.hello());//Hello World!
		System.out.println(hello==hello2);
	}
	
	@Test
	public void testIXUser() {
		UserAction ua = factory.getBean("userAction",UserAction.class);
		User u = new User(1,"aa",2000,22);
		ua.setUser(u);
		ua.add();
		
		UserAction ua2 = factory.getBean("userAction",UserAction.class);
		User u2 = new User(2,"bb",2000,21);
		ua2.setUser(u2);
		ua2.add();
	}
}
