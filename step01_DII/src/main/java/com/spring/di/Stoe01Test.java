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
      
      //���� ��ü ���� ������ ?
      // ��ü ������ ���� �̷������ �� �Ŀ�, ������ ������ �Ͼ�� �ȴ�
      
      //step2
      //People2
      People p2 = context.getBean("p2", People.class);
      System.out.println(p2);
      
      //p1�� p2�� �ٸ� ����� ���̴� = �ٸ� ��ü�̴�
      System.out.println(p1 == p2); //false
      
      //p1�� mycar�� p2�� mycar��? true �� �ֳ� ?�⺻���� singleton �̱� ����
      System.out.println(p1.getMyCar() == p2.getMyCar()); //true
      
      // �׷��ٸ� p1-mycar�� p2-myCar�� ���� �ٸ� ��ü�� �Ƿ��� ?
      // step01.xml �� scope = "prototype"�� �߰��ϸ� flase�� �ȴ� (���οü�� �ȴ�)
      
      
      // scope�� request �̸� ? ��û���� ���ο� ��ü�� ����
      // session �̸� ? ���Ǹ��� ���ο� ��ü�� ����
      
   }

}
