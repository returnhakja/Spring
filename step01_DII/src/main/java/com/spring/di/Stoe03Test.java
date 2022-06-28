package com.spring.di;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step03.model.domain.Car;
import step03.model.domain.People;
public class Stoe03Test {

   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("step03.xml");
      
     
//      People p1 = context.getBean("p1",  People.class);
      People p1 = context.getBean(People.class); 
      // id값을 주지않고 일반적으로 줄 경우에는 id값을 제외하고 타입만 매개변수로 전달하고 getbean으로 호출하면 사용가능
      
      
      System.out.println(p1);
      
      // Car
      Car c1 = context.getBean(Car.class); // 기본적으로 이름을 가지고 있음
      //Car c1 = context.getBean("car", Car.class); //기본적으로 클래스이름을 기본이름으로 가지고 있다
      
      
      System.out.println(c1);
      
   }

   
}


