package com.ah.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class myAspect {
    @Pointcut("execution(* com.ah.service.impl.*.*(..))")
    public void ppt1() {
    }

    @Around("ppt1()")
    public Object around(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕通知：前置通知，在目标方法之前执行");
        Object proceed = null;
        try {
            proceed = pj.proceed();//执行主方法，拿到放回结果
            System.out.println("环绕通知：后置通知，在目标方法之后执行");
        } catch (Exception e) {
            System.out.println("环绕通知：程序出现错误是执行的方法");
            throw new Exception("事务回滚");
        } finally {
            System.out.println("环绕通知：最终通知 无论如何都会执行");
        }
        return proceed;
    }
}
