package com.lvdveekens.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class HelloWorldAspect {

    @Around("this(com.lvdveekens.aspectj.App+) && execution(public * *(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println(">>> BEFORE >>>");
        Object result = point.proceed();
        System.out.println("<<< AFTER <<<");
        return result;
    }
}
