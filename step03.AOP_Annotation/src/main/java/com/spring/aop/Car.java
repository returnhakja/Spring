package com.spring.aop;

import org.springframework.stereotype.Component;

// ����, �Ǹ� ������ �ٽ� ���


@Component
public class Car {
	//�����ϴ� ����
	public void buy() {
		System.out.println("�ڵ��� ����");
	}
	
	public void buyMoney(int money) {
		System.out.println("�ڵ��� ���� �ݾ� : " + money);
	}
	
	public String buyReturn() {
		return "���ż���";
	}
	
	//�Ǹ� �޼ҵ�
	public void sellCar(int money) throws Exception {
		if(money <= 1000) {
			throw new Exception("�ʹ� ������");
		}
	}
}
