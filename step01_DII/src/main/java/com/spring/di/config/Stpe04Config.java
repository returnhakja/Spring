package com.spring.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import step03.model.domain.Car;
import step03.model.domain.People;


//configuration �� ���̸� �����̳ʰ� �ڵ����� ���������̶�� ���� �˰� �ȴ�

@Configuration

@ComponentScan(basePackages = {"step03.model.domain"})
public class Stpe04Config {
	
	//xml���� ���� <bean>�̶�� �����ϸ� �ȴ�
//	@Bean
//	public Car car() { //Car�޼ҵ�
//		Car car = new Car();
//		
//		return car;	
//	}
	
//	@Bean
	//�ڵ����� ���������� �� �� �ְԲ� ����������Ѵ�
	//car�� ���Խ��������
//	public People people(Car car) {
//		People people = new People();
//		people.setMyCar(car);
//		return people;
//	}
	

}
