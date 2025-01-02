package com.heyrr.organization.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Before(value = "servicePointcut()")
    public void logMethodEntry(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Entering method: {}", String.format("%s.%s", className, methodName));
    }

    @Before(value = "servicePointcut()")
    public void logMethodParams(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args.length == 0)
            log.info("No method parameters!");
        else {
            StringBuilder arguments = new StringBuilder();
            for (Object arg : args) {
                if (arg != null)
                    arguments.append(arg);
            }
            log.info("Method parameters: {}", arguments);
        }
    }

    @AfterReturning(pointcut = "servicePointcut()", returning = "result")
    public void logMethodReturning(JoinPoint joinPoint, Object result) {
        if (result == null)
            log.info("Method has no return value!");
        else
            log.info("Return value: {}", result);
    }

    @AfterThrowing(pointcut = "servicePointcut()", throwing = "exception")
    public void logMethodException(JoinPoint joinPoint, Exception exception) {
        log.error("An unexpected error occurred", exception);
    }

    @After(value = "servicePointcut()")
    public void logMethodExit(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Exiting method: {}", String.format("%s.%s", className, methodName));
    }

    @Pointcut(value = "execution(* com.heyrr.organization.services.impl.*.*(..))")
    public void servicePointcut() {}
}
