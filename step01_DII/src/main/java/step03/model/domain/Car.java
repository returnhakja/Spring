package step03.model.domain;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Car {
   //Bean ���� : �⺻������, private �ʵ�(������� ����), getter, setter����
   private int carNo;
   private String carName;
   
   public Car() {
      System.out.println("Car �⺻ ������");
   }
   
   public Car(int carNo, String carName) {
      this.carNo = carNo;
      this.carName = carName;
      System.out.println("car ������");
   }

}