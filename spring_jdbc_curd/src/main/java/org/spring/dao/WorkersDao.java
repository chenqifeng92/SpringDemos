package org.spring.dao;

import org.spring.model.Workers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class WorkersDao {

    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Workers> findAll(){
        jdbcTemplate.update("SELECT * FROM workers");
        return null;
    }
    public Workers findById(int id){
        jdbcTemplate.update("SELECT * FROM workers WHERE id=?");
        return null;
    }
    public void add(Workers wkr){
        jdbcTemplate.update("INSERT INTO workers(name,salary,age) " +
                        "VALUE (?,?,?)",wkr.getName(),wkr.getSalary(),wkr.getAge());
    }
    public void modify(Workers wkr){
        jdbcTemplate.update("UPDATE workers SET name=?,salary=?,age=?" +
                        "WHERE id=?",wkr.getName(),wkr.getSalary(),wkr.getAge());
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM workers WHERE id=?",id);
    }
}
