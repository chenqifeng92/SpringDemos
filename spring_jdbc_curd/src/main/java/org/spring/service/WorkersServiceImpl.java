package org.spring.service;

import org.spring.dao.WorkersDao;
import org.spring.model.Workers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkersServiceImpl implements WorkersService {

    private final WorkersDao workersDao;

    public WorkersServiceImpl(WorkersDao workersDao) {
        this.workersDao = workersDao;
    }

    @Override
    public List<Workers> findAll() {
        return workersDao.findAll();
    }

    @Override
    public Workers findById(int id) {
        return workersDao.findById(id);
    }

    @Override
    public void add(Workers wkr) {
        workersDao.add(wkr);
    }

    @Override
    public void modify(Workers wkr) {
        workersDao.modify(wkr);
    }

    @Override
    public void delete(int id) {
        workersDao.delete(id);
    }
}
