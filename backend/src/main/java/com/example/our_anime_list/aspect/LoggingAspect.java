package com.example.our_anime_list.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.example.our_anime_list.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint) {
        log.info("Executing Controller method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.example.our_anime_list.controller.*.*(..))", returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        log.info("Controller Method executed: " + joinPoint.getSignature().getName() + ", Return: " + result);
    }
}