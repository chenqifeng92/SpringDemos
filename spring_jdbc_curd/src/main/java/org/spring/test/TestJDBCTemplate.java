package org.spring.test;

import jakarta.annotation.Resource;
import org.spring.dao.WorkersDao;
import org.spring.model.Workers;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * JDBC 示例运行器（保留在 main 目录以兼容历史目录结构）。
 *
 * 更完整的自动化测试请参考 src/test/java 下的单元测试、集成测试与性能测试。
 */
@Component
public class TestJDBCTemplate {

    @Resource
    private WorkersDao workersDao;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestJDBCTemplate runner = context.getBean(TestJDBCTemplate.class);

        runner.printAllWorkers();

        context.close();
    }

    public void printAllWorkers() {
        System.out.println("workers count=" + workersDao.findAll().size());
    }

    public void addSampleWorker() {
        Workers wkr = new Workers();
        wkr.setName("demo-user");
        wkr.setSalary(5000);
        wkr.setAge(25);
        workersDao.add(wkr);
    }
}
