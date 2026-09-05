package com.example.fortry.aspect;

import jakarta.servlet.ServletRequest;
import org.apache.juli.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {
    private static final Logger log=  LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.example.fortry.controller..*.*(..))")
    public void controllerLog(){}

    @Around("controllerLog()")
   public Object logAround(ProceedingJoinPoint JoinPoint) throws Throwable{

        long start=System.currentTimeMillis();
        log.info("\n============================"+start+ "开始 ==============================");

        Object object=JoinPoint.proceed();

        long end=System.currentTimeMillis();
        log.info("\n===================="+end+" 结束，耗时："+(end-start)+"====================");

        return object;
    }
}
