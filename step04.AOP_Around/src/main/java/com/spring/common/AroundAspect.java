package com.spring.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect {
	/* @Around("within(com.spring.aop.*)") */
	
	@Around("within(com.spring.aop.*)")
	public Object aroundAspect(ProceedingJoinPoint point) {
		System.out.println("��ó��");
		System.out.println("�����Ͻ�?");
		
		Object returnValue = null;
		try {
			returnValue = point.proceed();
			System.out.println("���� �� ����" + returnValue);
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("�߻��� ���� :" + e.getMessage());
		}
		System.out.println("��ó��");
		System.out.println("����");
		
		return returnValue;
	}
	
}
