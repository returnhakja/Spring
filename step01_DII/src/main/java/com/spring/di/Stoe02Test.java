package com.spring.di;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step02.model.domain.Car;
import step02.model.domain.People;
public class Stoe02Test {

   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("step02.xml");
      
     
      People p1 = context.getBean("p1",  People.class);
      System.out.println(p1);
      
   }

   
}


