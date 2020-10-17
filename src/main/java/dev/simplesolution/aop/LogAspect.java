package dev.simplesolution.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogAspect {
	protected Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Before("within(dev.simplesolution..*)")
	public void logBefore(JoinPoint joinPoint) {
		// Log method name
		logger.info("Invoke method: " + joinPoint.getSignature().toLongString());
		// Log arguments
		if(joinPoint.getArgs() != null) {
			for(Object obj : joinPoint.getArgs()) {
				logger.info("Argument: " + obj.toString());
			}
		}
	}
	
	@AfterReturning(pointcut =  "within(dev.simplesolution..*)", returning = "returnObject")
	public void logAfterReturning(JoinPoint joinPoint, Object returnObject) {
		// Log method name
		logger.info("Return from method: " + joinPoint.getSignature().toLongString());
		// Log the return value
		logger.info("Return Object: " + returnObject);
	}
	
	@AfterThrowing(pointcut = "within(dev.simplesolution..*)", throwing = "ex")
	public void logAfterThrowing(Exception ex) {
		// Log the exception message
		logger.info("Error: " + ex.getMessage());
	}
}
