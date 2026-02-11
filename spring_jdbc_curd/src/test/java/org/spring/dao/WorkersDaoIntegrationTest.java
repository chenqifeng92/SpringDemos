package org.spring.dao;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.spring.model.Workers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = WorkersDaoIntegrationTest.TestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class WorkersDaoIntegrationTest {

    @Configuration
    static class TestConfig {
        @Bean
        DataSource dataSource() {
            return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("classpath:schema.sql")
                    .addScript("classpath:data.sql")
                    .build();
        }

        @Bean
        WorkersDao workersDao(DataSource dataSource) {
            WorkersDao dao = new WorkersDao();
            dao.setDataSource(dataSource);
            return dao;
        }
    }

    @jakarta.annotation.Resource
    private WorkersDao workersDao;


    @Test
    @Order(1)
    void findAll_shouldReturnSeedData() {
        List<Workers> list = workersDao.findAll();
        assertEquals(2, list.size());
        assertEquals("Tom", list.get(0).getName());
    }

    @Test
    @Order(2)
    void addAndFindById_shouldWork() {
        Workers workers = new Workers();
        workers.setName("Alice");
        workers.setSalary(8000);
        workers.setAge(26);
        workersDao.add(workers);

        List<Workers> all = workersDao.findAll();
        assertEquals(3, all.size());
        Workers latest = all.get(2);
        assertNotNull(workersDao.findById(latest.getId()));
    }

    @Test
    @Order(3)
    void modifyAndDelete_shouldWork() {
        Workers first = workersDao.findAll().get(0);
        first.setName("Tom-Updated");
        first.setSalary(9000);
        first.setAge(31);
        workersDao.modify(first);

        Workers updated = workersDao.findById(first.getId());
        assertEquals("Tom-Updated", updated.getName());

        workersDao.delete(first.getId());
        assertNull(workersDao.findById(first.getId()));
    }
}
