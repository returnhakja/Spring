package step02.model.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Data;

@Data
public class People {
   private String name;
   private int age;
   
	/* Autowired(required = true) �� �����ϰ��ִ� ���� �־������ �������� �� �� �ִ� */
//   @Autowired  
   @Autowired(required = false)
   @Qualifier("c2")
   private Car myCar;
   
   public People() {
      System.out.println("People �⺻ ������");
   }
   public People(String name, int age, Car myCar) {
      this.name = name;
      this.age = age;
      this.myCar = myCar;
      System.out.println("People ������");
      
   }

}