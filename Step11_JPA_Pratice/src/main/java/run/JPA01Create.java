package run;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.User;

public class JPA01Create {

	public static void create() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("step11_JPA_Pratice");
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
	tx.begin();
	try {
		insert(em); //이 사이에 있을때는 예외가 발생할 수 있다는걸 알아야함
	tx.commit();
	}catch(Exception e) {
		e.printStackTrace();
		tx.rollback(); // 실행되기 전으로 돌려줘야함
	} finally {
		em.close();
	}
	emf.close();	
	}

	private static void insert(EntityManager em) {
		User user = new User();
		
		user.setName("삼번");
		user.setAge(30);
		
		em.persist(user);
		System.out.println(user);
		
	}
	
//	private static void select(EntityManager em) {
//		User user1 = em.find(User.class, "일번");
//		System.out.println(user1);
//	}
//	
//	private static void update() {
//		User user3 = new User();
//		user3.setAge(558);
//		System.out.println(user3);
//	}
//	
//	private static void delete(EntityManager em) {
//		User user4 = new User();
//		em.remove(user4);
//		
//	}
}
