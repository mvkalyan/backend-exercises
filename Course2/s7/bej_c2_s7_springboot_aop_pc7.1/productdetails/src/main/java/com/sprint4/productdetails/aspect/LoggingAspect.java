package com.sprint4.productdetails.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    private final static Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.sprint4.productdetails.controller.ProductController.*..))")
    @Pointcut("execution(* com.sprint4.productdetails.controller.ProductController.getAllProducts(..))")
    public void controllerMethod(){}

    @Before("controllerMethod()")
    public void beforeAdvisor(JoinPoint joinPoint){
        logger.info("***************************CONTROLLER METHOD BEFORE****************************");
        logger.debug("Method Name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.info("###############################################################################");
    }

    @After("controllerMethod()")
    public void afterAdvisor(JoinPoint joinPoint){
        logger.info("***************************CONTROLLER METHOD AFTER****************************");
        logger.debug("Method Name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.info("###############################################################################");
    }

    @AfterReturning(value = "controllerMethod()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        logger.info("**********************CONTROLLER METHOD AFTER RETURNING***********************");
        logger.debug("Method Name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result: "+result);
        logger.info("###############################################################################");
    }

    @AfterThrowing(value = "controllerMethod",throwing = "error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        logger.info("**********************CONTROLLER METHOD AFTER THROWING***********************");
        logger.debug("Method Name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.debug("Error: "+error);
        logger.info("###############################################################################");
    }

}
