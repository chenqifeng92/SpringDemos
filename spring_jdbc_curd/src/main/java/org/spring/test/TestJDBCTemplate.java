package org.spring.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.spring.dao.WorkersDao;
import org.spring.model.Workers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 当使用了以下注释之后，就可以直接在Test中进行依赖注入。
 */
@SpringJUnitConfig
@ContextConfiguration("/applicationContext.xml")
public class TestJDBCTemplate {

    @Resource
    private WorkersDao workersDao;

    @Test
    public void contextShouldInjectWorkersDao() {
        assertNotNull(workersDao);
    }

    @Test
    @Disabled("需要本地 MySQL 环境与示例数据，学习时按 jdbc.properties 配置后再执行")
    public void testFindAll() {
        workersDao.findAll();
    }

    @Test
    @Disabled("需要本地 MySQL 环境与示例数据，学习时按 jdbc.properties 配置后再执行")
    public void testFindById() {
        workersDao.findById(1);
    }

    @Test
    @Disabled("需要本地 MySQL 环境与示例数据，学习时按 jdbc.properties 配置后再执行")
    public void testAdd() {
        Workers wkr = new Workers();
        workersDao.add(wkr);
    }

    @Test
    @Disabled("需要本地 MySQL 环境与示例数据，学习时按 jdbc.properties 配置后再执行")
    public void testDelete() {
        workersDao.delete(1);
    }

    @Test
    @Disabled("需要本地 MySQL 环境与示例数据，学习时按 jdbc.properties 配置后再执行")
    public void testModify() {
        Workers wkr = new Workers();
        workersDao.modify(wkr);
    }
}
