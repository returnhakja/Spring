package step01.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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