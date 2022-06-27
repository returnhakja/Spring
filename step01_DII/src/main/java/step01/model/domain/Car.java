package step01.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Car {
   //Bean 조건 : 기본생성자, private 필드(멤버변수 존재), getter, setter존재
   private int carNo;
   private String carName;
   
   public Car() {
      System.out.println("Car 기본 생성자");
   }
   
   public Car(int carNo, String carName) {
      this.carNo = carNo;
      this.carName = carName;
      System.out.println("car 생성자");
   }

}