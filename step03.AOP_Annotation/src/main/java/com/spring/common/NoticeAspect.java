package com.spring.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
// 공통안내 로직
public class NoticeAspect {
	
	// 구매 전 공통 로직
	@Before("execution(* com.spring.aop.Car.buy*(..))")
	public void noticeBuyStart() {
		System.out.println("구매할꺼임?");
	}
	
	
	// 구매 후 공통 로직
	@After("execution(* com.spring.aop.Car.buy*(..))")
	public void noticeBuyEnd() {
		System.out.println("구매 완료");
	}
	
	
	// 리턴값이 있는 메소드에만 적용하는 공통 로직
	@AfterReturning(pointcut = "execution(* com.spring.aop.Car.buy*(..))", returning = "v")
	public void noticeReturnValue(String v) {
		if(v != null) {
			System.out.println("Return 후 처리 로직 : " + v);
		}
	}
	
	// 예외처리를 하는 공통 로직
	@AfterThrowing(pointcut = "execution(* com.spring.aop.Car.sell*(..))", throwing = "exception")
	public void noticeSellException(Exception exception) {
		System.out.println("발생된 예외 : " + exception.getMessage());
	}
}
