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
      // id���� �����ʰ� �Ϲ������� �� ��쿡�� id���� �����ϰ� Ÿ�Ը� �Ű������� �����ϰ� getbean���� ȣ���ϸ� ��밡��
      
      
      System.out.println(p1);
      
      // Car
      Car c1 = context.getBean(Car.class); // �⺻������ �̸��� ������ ����
      //Car c1 = context.getBean("car", Car.class); //�⺻������ Ŭ�����̸��� �⺻�̸����� ������ �ִ�
      
      
      System.out.println(c1);
      
   }

   
}


