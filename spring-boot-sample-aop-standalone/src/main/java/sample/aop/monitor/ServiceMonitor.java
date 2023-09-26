/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

	@AfterReturning("execution(* sample..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}

	//@Before("execution(* sample.aop.part1.*.*(..))")
	@Before("execution(* sample.aop.part1.*.*.*(..))")
	public void logMethodCall(JoinPoint joinPoint) {
		System.out.println("[X] Appel de la méthode " + joinPoint.getSignature().getName() + " à partir de la classe : " + joinPoint.getSignature().getDeclaringType().getName());
	}

	@Around("execution(* sample.aop.part1.bank.Bank.transfert())")
	public Object interceptCall(ProceedingJoinPoint joinPoint) throws Throwable {
		int rNumber = (int) (Math.random() * 5);
		if (rNumber < 2) {
			return rNumber;
		} else {
			return joinPoint.proceed();
		}
	}

}
