package org.spring.action;

import org.spring.model.User;
import org.spring.service.UserServiceImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userAction")
@Scope("prototype")
public class UserAction {
    private User user;
    private UserServiceImpl userServiceImpl;
    private int id;

    public void add(){
        userServiceImpl.add(user);
    }

    public void delete(){
        userServiceImpl.delete(id);
    }

    public void load(){
        userServiceImpl.load(id);
    }

    public void update(){
        userServiceImpl.update(user);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    @Resource
    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
}
