package com.mum.waa.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author Yahia
 *
 */
@Aspect
@Configuration
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.mum.waa.blog.service.*.*.*(..))")
	public void beforeServiceMethodsCall(JoinPoint joinpoint) {
		logger.info(new StringBuilder().append("Before calling method : ").append(joinpoint.getSignature().getName())
				.append(" in service layer").toString());
	}

	@After("execution(* com.mum.waa.blog.service.*.*.*(..))")
	public void afterServiceMethodsCall(JoinPoint joinpoint) {
		logger.info(new StringBuilder().append("After calling method : ").append(joinpoint.getSignature().getName())
				.append(" in service layer").toString());
	}
}
