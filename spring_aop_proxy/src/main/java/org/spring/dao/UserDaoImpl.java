package org.spring.dao;

import org.spring.model.User;
import org.springframework.stereotype.Repository;

//@Component ("userDaoImpl")
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao{
    @Override
    public void add(User user) {
        System.out.println(user);
    }

    @Override
    public void delete(int id) {
        System.out.println(id);
    }

    @Override
    public User load(int id) {
        System.out.println("load: "+id);
        return null;
    }
}
