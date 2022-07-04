package jpa.basic.test;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.EnumType;
import javax.persistence.Persistence;

import jpa.basic.enumtype.MemberType;
import step02.entity.Member2;

public class Step02Test {

	public static void main(String[] args) {
		System.out.println(MemberType.VIP);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPA_Basic");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
		logic(em); //이 사이에 있을때는 예외가 발생할 수 있다는걸 알아야함
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback(); // 실행되기 전으로 돌려줘야함
		} finally {
			em.close();
		}
		emf.close();		
	}
	
	private static void logic(EntityManager em) {
		Member2 member = new Member2();
		
		member.setName("춘자");
		member.setAge(50);
		member.setMemberType(MemberType.NORMAL);
		member.setRegistrationTime(LocalDateTime.now());
		
		em.persist(member);
		System.out.println(member);
	}

}
