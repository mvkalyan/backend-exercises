package com.niit.course13Sprint4.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect //class contains joinPoint and pointcut
public class LoggingAspect {

    //define logger
    private final static Logger logger= LoggerFactory.getLogger(LoggingAspect.class);

    //define pointcut
    //wildcards * and ..
    //* - any return type
    // .. - any type of parameters and any number of parameters

    @Pointcut("execution(* com.niit.course13Sprint4.controller.CustomerController.addCustomer(..))")
   // @Pointcut("execution(* com.niit.course13Sprint4.controller.CustomerController.*..))") // all controller methods
    //@Pointcut("execution(* com.niit.course13Sprint4.*.*.*(..))")
    public void controllerMethod(){

    }

    @Before("controllerMethod()")
    public void beforeAdvisor(JoinPoint joinPoint){
        //advisor before
        logger.info("******************controller method before*********************");
        logger.debug("Method name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.info("##########################################################");
    }

    @After("controllerMethod()")
    public void afterAdvisor(JoinPoint joinPoint){
        //advisor before
        logger.info("******************controller method after*********************");
        logger.debug("Method name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.info("##########################################################");
    }

    //success
    @AfterReturning(value = "controllerMethod()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        logger.info("******************controller method after returning*********************");
        logger.debug("Method name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result "+ result);
        logger.info("##########################################################");
    }

    //failuer
    @AfterThrowing(value = "controllerMethod()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        logger.info("******************controller method after throwing*********************");
        logger.debug("Method name: "+ joinPoint.getSignature().getName());
        logger.debug("Arguments: "+ Arrays.toString(joinPoint.getArgs()));
        logger.debug("Result "+ error);
        logger.info("##########################################################");

    }





}
