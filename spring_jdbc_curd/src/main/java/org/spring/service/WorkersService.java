package org.spring.service;

import org.spring.model.Workers;

import java.util.List;

public interface WorkersService {

    public List<Workers> findAll();
    public Workers findById(int id);
    public void add(Workers wkr);
    public void modify(Workers wkr);
    public void delete(int id);
}
