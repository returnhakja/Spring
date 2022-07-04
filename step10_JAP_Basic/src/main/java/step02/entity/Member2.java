package step02.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import jpa.basic.enumtype.MemberType;
import lombok.Data;

@Data
@Entity
public class Member2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	private Integer age;
	
	//
	@Column(name = "reg_time",updatable = false)
	//updatable = false 값이 절때 변하지 않음
	private LocalDateTime registrationTime; // 시간까지 정확히 알려면 LocalDateTime 을 써야한다
	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Data registrationTime;
	
	
//	private String memberType;
	
	
	
	@Column(name = "member_type")
	@Enumerated(EnumType.STRING) // 여기서 STRING은 ENUM에 적었던 것들이 각각으로 들어간다
	private MemberType memberType;
	
	
}
