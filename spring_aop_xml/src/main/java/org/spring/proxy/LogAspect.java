package org.spring.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component("logAspect")
public class LogAspect {

    public void logStart(JoinPoint jp){
        System.out.println(jp.getTarget());//得到执行的对象
        System.out.println(jp.getSignature().getName());//得到执行的方法
        Logger.info("加入日志by LogAspect");
    }

    public void logEnd(JoinPoint jp){
        Logger.info("方法调用结束时加入日志by LogAspect");
    }

    public void logAround(ProceedingJoinPoint pjp) throws Throwable{
        Logger.info("开始在Around中加入日志");
        pjp.proceed();//执行程序
        Logger.info("结束Around");

    }
}
