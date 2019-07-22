package org.spring.controller;

import org.spring.model.Workers;
import org.spring.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class WorkersController {
    @Autowired
    private WorkersService workersService;

    private Logger log = Logger.getLogger(String.valueOf(WorkersController.class));

    @RequestMapping("/list")
    @ResponseBody
    public List<Workers> queryAllWorkers(){
        return workersService.findAll();
    }

    @RequestMapping("/findid")
    @ResponseBody
    public Workers queryWorkersById(int id){
        return workersService.findById(id);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void addWorkers(Workers wkr){
        workersService.add(wkr);
    }

    @RequestMapping("/del")
    @ResponseBody
    public void deleteWorkers(int id){
        workersService.delete(id);
    }

    @RequestMapping("/mod")
    @ResponseBody
    public void modifyWorkers(Workers wkr){
        workersService.modify(wkr);
    }
}
