package org.spring.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect //申明了这个类是一个切面类，需要额外引入aopalliance.jar,aspectjrt.jar,aspectweaver.jar
public class LogAspect {
    /**
     * execution(* org.spring.dao.*.add*(..))
     * 第一个*表示任意返回值
     * 第二个*表示org.spring.dao中所有类
     * 第三个*表示以add开头的所有方法
     * (..)表示任意参数
     */
    @Before("execution(* org.spring.dao.*.add*(..))||"+
            "execution(* org.spring.dao.*.delete*(..))||"+
            "execution(* org.spring.dao.*.update*(..))")
    public void logStart(JoinPoint jp){
        System.out.println(jp.getTarget());//得到执行的对象
        System.out.println(jp.getSignature().getName());//得到执行的方法
        Logger.info("加入日志by LogAspect");
    }

    /**
     * 函数调用完成后执行
     * @param jp
     */
    @After("execution(* org.spring.dao.*.add*(..))||"+
            "execution(* org.spring.dao.*.delete*(..))||"+
            "execution(* org.spring.dao.*.update*(..))")
    public void logEnd(JoinPoint jp){
        Logger.info("方法调用结束时加入日志by LogAspect");
    }

    /**
     *  函数调用过程中执行
     * @param pjp
     * @throws Throwable
     */
    @Around("execution(* org.spring.dao.*.add*(..))||"+
            "execution(* org.spring.dao.*.delete*(..))||"+
            "execution(* org.spring.dao.*.update*(..))")
    public void logAround(ProceedingJoinPoint pjp) throws Throwable{
        Logger.info("开始在Around中加入日志");
        pjp.proceed();//执行程序
        Logger.info("结束Around");

    }
}
