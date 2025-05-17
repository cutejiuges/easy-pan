package com.easy_pan.back.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {
    // 在所有handle方法上输出
    @Around("execution(* com.easy_pan.back.biz.handler..*Handler.handle(..))")
    public Object costTimeLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        log.info("方法[{}.{}]执行耗时:[{}ms]", className, methodName, System.currentTimeMillis() - startTime);
        return result;
    }

    @Around("@annotation(com.easy_pan.back.annotation.ArgsLogging)")
    public Object argsLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("方法[{}.{}] 入参:{}", className, methodName, args);
        Object result = joinPoint.proceed(args);
        log.info("方法[{}.{}] 出参:{}", className, methodName, result);
        return result;
    }
}
