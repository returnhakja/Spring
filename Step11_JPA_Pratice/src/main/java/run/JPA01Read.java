package run;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;


public class JPA01Read {
	
	public static void Read() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("step11_JPA_Pratice");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			read(em); //이 사이에 있을때는 예외가 발생할 수 있다는걸 알아야함
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback(); // 실행되기 전으로 돌려줘야함
		} finally {
			em.close();
		}
		emf.close();	
		}
	
		
	private static void read(EntityManager em) {
		List<User> allUsers = em.createQuery("select u from User u", User.class).getResultList();
		System.out.println(allUsers);
	}
}
