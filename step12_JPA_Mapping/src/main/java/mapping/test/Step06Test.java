package mapping.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step06.entity.Member;
import step06.entity.Order;
import step06.entity.Product;

public class Step06Test {

   static void logic(EntityManager em) {
//      
//      Product productA = new Product();
//      productA.setId(1L);
//      productA.setName("상품A");
//      em.persist(productA);
//      
//      Member member1 = new Member();
//      member1.setId(1L);
//      member1.setName("멤버1");
//      member1.setAge(27);
//      em.persist(member1);
//      
//
     // MemberProduct
//      Order	memberproduct = new Order();
//      memberproduct.setMember(member1);
//      memberproduct.setProduct(productA);
//      em.persist(memberproduct);
      
      
	  //조회
		/*
		 * Order order = em.find(Order.class, 1L); Member member = order.getMember();
		 * Product product = order.getProduct();
		 * 
		 * System.out.println(member); System.out.println(product);
		 */
      
	   //삭제
	   Member member = em.find(Member.class, 1L);
	   System.out.println(member);
	   em.remove(member);
	   
      
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