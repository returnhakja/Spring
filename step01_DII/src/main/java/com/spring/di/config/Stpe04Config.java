package com.spring.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import step03.model.domain.Car;
import step03.model.domain.People;


//configuration 을 붙이면 컨테이너가 자동으로 설정파일이라는 것을 알게 된다

@Configuration

@ComponentScan(basePackages = {"step03.model.domain"})
public class Stpe04Config {
	
	//xml에서 썻던 <bean>이라고 생각하면 된다
//	@Bean
//	public Car car() { //Car메소드
//		Car car = new Car();
//		
//		return car;	
//	}
	
//	@Bean
	//자동차가 내부적으로 들어갈 수 있게끔 설정해줘야한다
	//car를 주입시켜줘야함
//	public People people(Car car) {
//		People people = new People();
//		people.setMyCar(car);
//		return people;
//	}
	

}
