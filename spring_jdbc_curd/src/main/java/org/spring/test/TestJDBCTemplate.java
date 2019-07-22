package org.spring.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.dao.WorkersDao;
import org.spring.model.Workers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 当使用了以下注释之后，就可以直接在Test中进行依赖注入
 */
//让junit运行在spring的测试环境中，
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestJDBCTemplate {
    @Resource
    private WorkersDao workersDao;

    @Test
    public void testFindAll(){
        //TO DO
    }

    public void testFindById(int id){
        //TO DO
    }

    @Test
    public void testAdd(){
        Workers wkr = new Workers();
    }

    @Test
    public void testDelete(){

    }

    @Test
    public void testModify(){

    }
}
