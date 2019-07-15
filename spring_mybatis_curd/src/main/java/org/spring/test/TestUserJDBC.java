package org.spring.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.dao.UserDao;
import org.spring.model.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 当使用了以下注释之后，就可以直接在Test中进行依赖注入
 */
//让junit运行在spring的测试环境中，
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")//加载beans.xml
public class TestUserJDBC {
    @Resource
    private UserDao userDao;

    @Test
    public void testAdd(){
        User u = new User();
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testUpdate(){

    }
}
