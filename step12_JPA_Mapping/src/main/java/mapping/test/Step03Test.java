package mapping.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step03.entity.Member;
import step03.entity.Team;

public class Step03Test {

	static void logic(EntityManager em) {
		
		// 팀 먼저?? 멤버 먼저 ??? -> 팀을 먼저만들어야지
		Team teamA = new Team();
		teamA.setName("TeamA");
		em.persist(teamA);
		Team teamB = new Team();
		teamB.setName("TeamA");
		em.persist(teamB);
		
		Member member1 = new Member();
		member1.setName("집에갈래");
		member1.setAge(10);
		member1.setTeam(teamA);
		em.persist(member1);
		
		teamA.getMembers().add(member1);
		
		
		Member member2 = new Member();
		member2.setName("집에갈래2");
		member2.setAge(20);
		member2.setTeam(teamB);
		em.persist(member2);
		
		teamB.getMembers().add(member2);
//		
	
		Member member01 = em.find(Member.class, member1.getId());
		System.out.println(member01);
//		Team team01 = em.find(Team.class, 1L);
		Team team01 = em.find(Team.class, teamA.getId());
		System.out.println(team01);
		System.out.println(team01.getMembers());
		
		List<Member> members = new ArrayList<Member>();
		Member member3 = new Member();
		member3.setName("집에가자3");		
		member3.setAge(222);
		member3.setTeam(teamB);
		members.add(member3);
		
		team01.setMembers(members);
		em.persist(team01);
		System.out.println(team01.getMembers());
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
