package org.spring.exception;

/**
 * 业务异常：根据 id 查询员工时不存在。
 */
public class WorkerNotFoundException extends RuntimeException {
    public WorkerNotFoundException(int id) {
        super("Worker not found, id=" + id);
    }
}
