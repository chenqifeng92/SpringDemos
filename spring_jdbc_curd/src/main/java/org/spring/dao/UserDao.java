package org.spring.dao;

import org.spring.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Repository("userDao")
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(User user){
        jdbcTemplate.update("INSERT INTO ususer(username,email,mobile,gender,birthday,password) " +
                        "VALUE (?,?,?,?,?,?)",user.getUsername(),user.getEmail(),user.getMobile(),
                user.getGender(),user.getBirthday(),user.getPassword());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM ususer WHERE id=?",id);
    }
    public void load(int id){
        jdbcTemplate.update("SELECT * FROM ususer WHERE id=?",id);
    }
    public void update(User user){
        jdbcTemplate.update("UPDATE ususer SET username=?,email=?,mobile=?,gender=?,birthday=?password=?" +
                "WHERE id=?",user.getId(),user.getUsername(),user.getEmail(),user.getMobile(),user.getGender(),
                user.getBirthday(),user.getPassword());
    }
    public List<User> queryAll(String sql){
        jdbcTemplate.update("SELECT * FROM ususer");
        return null;
    }
}
