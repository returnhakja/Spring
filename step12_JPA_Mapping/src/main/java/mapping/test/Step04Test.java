package mapping.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step04.entity.Member;
import step04.entity.Team;

public class Step04Test {

	static void logic(EntityManager em) {
		

		Team teamA = new Team();
		teamA.setName("TeamA");
		em.persist(teamA);

		
		Member member1 = new Member();
		member1.setName("집에갈래");
		member1.setAge(10);
		member1.setTeam(teamA);
		em.persist(member1);
		
		teamA.getMembers().add(member1);
		
		
		Member member2 = new Member();
		member2.setName("집에갈래2");
		member2.setAge(20);
		member2.setTeam(teamA);
		em.persist(member2);
		
		teamA.getMembers().add(member2);
		
		em.flush();
		em.clear();
		
		Member findMember = em.find(Member.class, member1.getId());
		
		System.out.println("멤버 정소 : " + findMember.getName());
		
		Team findTeam = findMember.getTeam();
		System.out.println("team 정보 : "+ findTeam);
	
		
	}
	
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step12_JPA_Maping");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			logic(em);
				tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}

}
