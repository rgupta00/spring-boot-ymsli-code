package com.bookapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class MyLoggingAspect {

	private Logger logger=LoggerFactory.getLogger(MyLoggingAspect.class);
	//@Around("@annotation(Loggable)")
	@Around("@annotation(MyLogger)")
	public Object aroundLogging(ProceedingJoinPoint joinPoint) throws Throwable {
		long start=System.currentTimeMillis();
		
		//by using ProceedingJoinPoint provide u the power to call
		// the actual logic and it also give target method inforation so that u can log them
		Object returnVal=joinPoint.proceed();
		
		
		long end=System.currentTimeMillis();
		
		logger.info("method take:"+(end-start)+ "ms to execute"+ "method name: "
		+joinPoint.getSignature().getName());
		return returnVal;
	}
}
