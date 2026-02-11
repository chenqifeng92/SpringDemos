package org.spring.dao;

import org.junit.jupiter.api.Test;
import org.spring.model.Workers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = WorkersDaoIntegrationTest.TestConfig.class)
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
    void findAll_shouldReturnSeedData() {
        List<Workers> list = workersDao.findAll();
        assertEquals(2, list.size());
        assertEquals("Tom", list.get(0).getName());
    }

    @Test
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
