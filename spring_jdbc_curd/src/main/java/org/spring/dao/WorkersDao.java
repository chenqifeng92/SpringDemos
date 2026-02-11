package org.spring.dao;

import jakarta.annotation.Resource;
import org.spring.model.Workers;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class WorkersDao {

    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Workers> findAll() {
        return jdbcTemplate.query(
                "SELECT id,name,salary,age FROM workers ORDER BY id",
                new BeanPropertyRowMapper<>(Workers.class)
        );
    }

    public Workers findById(int id) {
        List<Workers> result = jdbcTemplate.query(
                "SELECT id,name,salary,age FROM workers WHERE id=?",
                new BeanPropertyRowMapper<>(Workers.class),
                id
        );
        return result.isEmpty() ? null : result.get(0);
    }

    public void add(Workers wkr) {
        jdbcTemplate.update(
                "INSERT INTO workers(name,salary,age) VALUES (?,?,?)",
                wkr.getName(), wkr.getSalary(), wkr.getAge()
        );
    }

    public void modify(Workers wkr) {
        jdbcTemplate.update(
                "UPDATE workers SET name=?,salary=?,age=? WHERE id=?",
                wkr.getName(), wkr.getSalary(), wkr.getAge(), wkr.getId()
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM workers WHERE id=?", id);
    }
}
