package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.model.domain.Car;
import step01.model.domain.People;

public class Stoe01Test {

   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("step01.xml");
      
      //Car
      Car c1 = context.getBean("c1", Car.class);
      System.out.println(c1);
      
      // People
      People p1 = context.getBean("p1", People.class);
      System.out.println(p1);
      /* Setter Injection
       * people p1 = new People();
       * p1.setName("spring");
       * p1.setAge(29);
       * p1.setMyCar(c1);
       *  
       */
      
      //과연 객체 생성 순서는 ?
      // 객체 생성이 먼저 이루어지고 그 후에, 의존성 주입이 일어나게 된다
      
      //step2
      //People2
      People p2 = context.getBean("p2", People.class);
      System.out.println(p2);
      
      //p1과 p2는 다른 사람일 것이다 = 다른 객체이다
      System.out.println(p1 == p2); //false
      
      //p1의 mycar와 p2의 mycar는? true 임 왜냐 ?기본값이 singleton 이기 때문
      System.out.println(p1.getMyCar() == p2.getMyCar()); //true
      
      // 그렇다면 p1-mycar와 p2-myCar가 서로 다른 객체가 되려면 ?
      // step01.xml 의 scope = "prototype"을 추가하면 flase가 된다 (새로운객체가 된다)
      
      
      // scope가 request 이면 ? 요청마다 새로운 객체로 생성
      // session 이면 ? 세션마다 새로운 객체로 생성
      
   }

}
