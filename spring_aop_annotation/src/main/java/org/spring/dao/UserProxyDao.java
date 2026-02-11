package org.spring.dao;

import org.spring.model.User;
import org.spring.proxy.Logger;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

@Component ("userProxyDao")
public class UserProxyDao implements UserDao{

    private UserDao userDaoImpl;

    public UserDao getUserDaoImpl() {
        return userDaoImpl;
    }

    @Resource
    public void setUserDaoImpl(UserDao userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Override
    public void add(User user){
        Logger.info("通过UserProxy添加了用户");
        userDaoImpl.add(user);
    }

    @Override
    public void delete(int id){
        Logger.info("通过UserProxy删除了用户");
        userDaoImpl.delete(id);
    }

    @Override
    public User load(int id) {
        return userDaoImpl.load(id);
    }

}
