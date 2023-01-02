package com.stackroute.muzixservice.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//implement logger using AOP for all the methods
@Component
@Aspect
public class LoggerAspectClass {
    //define logger by creating an object
    private final static Logger logger = LoggerFactory.getLogger(LoggerAspectClass.class);

    //define pointcut - required a method to monitor on  -- monitoring insertTrack method
    @Pointcut("execution(* com.stackroute.muzixservice.controller.MuzixController.saveTrack(..))")
    public void pointCutControllerMethod() {
    }

    //before advisor, monitor before calling pointCut
    @Before("pointCutControllerMethod()")
    public void beforeAdvisor(JoinPoint joinPoint) {
        logger.info("---------------------------Pointcut Before Advisor---------------------------");
        logger.debug("Method name : " + joinPoint.getSignature().getName());
        logger.debug("Input Parameters : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("#############################################################################");
    }

    //before advisor, monitor after calling pointCut
    @After("pointCutControllerMethod()")
    public void afterAdvisor(JoinPoint joinPoint) {
        logger.info("---------------------------Pointcut After Advisor---------------------------");
        logger.debug("Method name : " + joinPoint.getSignature().getName());
        logger.debug("Input Parameters : " + Arrays.toString(joinPoint.getArgs()));
        logger.info("#############################################################################");
    }

    //calling method which is being monitored. depends on output, it will call AfterReturningAdvisor or AfterThrowingAdvisor

    //After returning advisor, In case of success
    @AfterReturning(value = "pointCutControllerMethod()", returning = "output")
    public void afterReturningAdvisor(JoinPoint joinPoint, Object output) {
        logger.info("-----------------------Pointcut After Returning Advisor----------------------");
        logger.debug("Method name : " + joinPoint.getSignature().getName());
        logger.debug("Input Parameters : " + Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result: " + output);
        logger.info("#############################################################################");
    }

    //After returning advisor, In case of failure, throws exception
    @AfterThrowing(value = "pointCutControllerMethod()", throwing = "error")
    public void afterThrowingAdvisor(JoinPoint joinPoint, Throwable error) {
        logger.info("------------------------Pointcut After Throwing Advisor----------------------");
        logger.debug("Method name : " + joinPoint.getSignature().getName());
        logger.debug("Input Parameters : " + Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result: " + error);
        logger.info("#############################################################################");
    }
}
