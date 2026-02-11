package org.spring.controller;

import org.spring.exception.WorkerNotFoundException;
import org.spring.model.Workers;
import org.spring.service.WorkersService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 示例 Controller：保留经典 Spring MVC 的风格，同时演示 REST 风格接口。
 */
@Controller
@RequestMapping("/")
public class WorkersController {

    private final WorkersService workersService;

    public WorkersController(WorkersService workersService) {
        this.workersService = workersService;
    }

    /**
     * 兼容老接口：查询全部员工。
     */
    @GetMapping("/list")
    @ResponseBody
    public List<Workers> queryAllWorkers() {
        return workersService.findAll();
    }

    /**
     * 兼容老接口：按 id 查询员工。
     */
    @GetMapping("/findid")
    @ResponseBody
    public Workers queryWorkersById(@RequestParam("id") int id) {
        Workers workers = workersService.findById(id);
        if (workers == null) {
            throw new WorkerNotFoundException(id);
        }
        return workers;
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Map<String, String>> addWorkers(@ModelAttribute Workers wkr) {
        workersService.add(wkr);
        return ResponseEntity.ok(Map.of("message", "added"));
    }

    @DeleteMapping("/del")
    @ResponseBody
    public ResponseEntity<Map<String, String>> deleteWorkers(@RequestParam("id") int id) {
        workersService.delete(id);
        return ResponseEntity.ok(Map.of("message", "deleted"));
    }

    @PutMapping("/mod")
    @ResponseBody
    public ResponseEntity<Map<String, String>> modifyWorkers(@ModelAttribute Workers wkr) {
        workersService.modify(wkr);
        return ResponseEntity.ok(Map.of("message", "updated"));
    }

    /**
     * 新接口：更语义化的 REST 风格路径。
     */
    @GetMapping("/api/workers")
    @ResponseBody
    public List<Workers> listWorkers() {
        return workersService.findAll();
    }
}
