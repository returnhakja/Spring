 package jpa.basic.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step01.entity.Member;

public class Step01Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step01_JPA_Basic");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		// insert
//		Member member1 = new Member();
//		member1.setId("id1");
//		member1.setAge(27);
//		member1.setUserName("jap1");
////		
////		//db반영?
//		em.persist(member1);
		// insert2
//				Member member2 = new Member();
//				member2.setId("id2");
//				member2.setAge(28);
//				member2.setUserName("jap2");
//				
//				//db반영?
//				em.persist(member2);
		
		//select
		Member member1 = em.find(Member.class, "id1");
//		System.out.println(member1);
//		
//		Member member01 = em.find(Member.class, "id1");
//		System.out.println(member01);
//		
//		System.out.println(member1 == member01);
		//끝났다는 의미에서 해줘야함 (DB반영댐)
		
		
		// JPQL : 엔티티 객체를 대상으로 검색하는 객체 지향 쿼리
		// Member 클래스이름을 먼저 찾아서 대문자로 해주어야함
		// 별칭도 해줘야함 (as 생략가능)
		// * 대신 별칭을 적어줘야함
//		List<Member> allMembers = em.createQuery("select m from Member m", Member.class).getResultList();
		List<String> allMembers = em.createQuery("select m.userName from Member m", String.class).getResultList();
		System.out.println(allMembers);
		
		
		//update : 변경 감지 - 엔티티 조회 및 데이터만 변경하면 자동으로 업데이트실행
		// 모든 멤버변수(필드) set, 업데이트 대상에서 지정되지 않은 멤버변수 데이터는 기존 유지
//		member1.setAge(37);
		
		//영속성 컨텍스트를 초기화하는 clear가 먼저 실행되면?
//		em.clear();
		member1.setAge(37);
		
		//delete
//		em.remove(member1);
		
		
		
		
		tx.commit();
	}

}
