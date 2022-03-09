package fr.solution.air.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

import fr.solution.air.exceptions.ErrorResponseAOP;

@Aspect
@Configuration
public class AOPConfig {

	private Logger log = LoggerFactory.getLogger(AOPConfig.class);

	@Before(value = "execution(* fr.solution.air.controllers.*.*(..))")
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}", joinPoint);
	}

	@After(value = "execution(* fr.solution.air.controllers.*.*(..))")
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("Complete exceution of {}", joinPoint);
	}

	@Around(value = "execution(* fr.solution.air.controllers.*.*(..))")
	public Object timeTracker(ProceedingJoinPoint joinPoint) throws Throwable {

		long stratTime = System.currentTimeMillis();

		try {
			Object obj = joinPoint.proceed();
			long timeTaken = System.currentTimeMillis() - stratTime;
			log.info("Time taken by {} is {} ms", joinPoint, timeTaken);
			return obj;
		} catch (ErrorResponseAOP e) {
			log.info("ErrorResponse StatusCode {}", e.getHttpStatus().value());
			log.info("ErrorResponse Message {}", e.getMessage());
			throw new ResponseStatusException(e.getHttpStatus(),
					e.getMessage());
		}
	}
}
