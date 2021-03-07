/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.ea.integration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 *
 * @author Thai Nguyen
 */
@Aspect
@Component
public class TraceAdvice {
//    @Before("execution(* com.miu.ea.service.PersistenceService.*(..))")
//    @Before("target(com.miu.ea.business.Student)")
    @Before("execution(* *.*(..))")
    public void tracebeforemethod(JoinPoint joinpoint) {
        System.out.println ("!!!!!!!!!!!!!!!!!before execution of method "  + joinpoint.getSignature().getName());
    }

//    @After("execution(* com.miu.ea.service.PersistenceService.*(..))")
//    @After("target(com.miu.ea.business.Student)")
    @After("execution(* *.*(..))")
    public void traceaftermethod(JoinPoint joinpoint) {
        System.out.println ("!!!!!!!!!!!!!!!!!after execution of method "  + joinpoint.getSignature().getName());
    }
  
}
