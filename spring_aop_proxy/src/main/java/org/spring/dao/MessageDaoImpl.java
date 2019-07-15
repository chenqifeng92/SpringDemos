package org.spring.dao;

import org.springframework.stereotype.Repository;

@Repository("messageDaoImpl")
public class MessageDaoImpl implements MessageDao {
    @Override
    public void add() {
        System.out.println("Message add");
    }

    @Override
    public void delete() {
        System.out.println("Message delete");
    }

    @Override
    public void load() {
        System.out.println("Message load");
    }
}
