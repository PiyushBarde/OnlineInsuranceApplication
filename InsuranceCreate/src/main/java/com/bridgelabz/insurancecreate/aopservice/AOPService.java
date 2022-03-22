package com.bridgelabz.insurancecreate.aopservice;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AOPService {
    public AOPService() {
    }
	//logs method before hitting API
    @Before("execution(* com.bridgelabz.insurancecreate.controller.InsuranceCreateController.*(..))")
    public void logBeforeV1(JoinPoint joinPoint) {
        log.info("Initiating API : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs method After hitting API
    @After("execution(* com.bridgelabz.insurancecreate.controller.InsuranceCreateController.*(..))")
    public void logAfter(JoinPoint joinPoint) {
    	log.info("API successfully Executed : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs method After hitting API
    @AfterReturning("execution(* com.bridgelabz.insurancecreate.service.InsuranceCreateService.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
    	log.info("Insurance returned to controller : " + joinPoint.getSignature().getName() + " ");
    }
    
    //logs parameters After hitting API
    @After("execution(* com.bridgelabz.insurancecreate.controller.InsuranceCreateController.*(..))")
    public void logAfterAndSaveArgs(JoinPoint joinPoint) {
    	log.info("After : " + Arrays.toString(joinPoint.getArgs()));
    }
}