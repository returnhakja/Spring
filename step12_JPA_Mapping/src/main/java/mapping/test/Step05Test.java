package mapping.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import step05.entity.Member;
import step05.entity.Product;

public class Step05Test {

   static void logic(EntityManager em) {
      
//      Product productA = new Product();
//      productA.setId(1L);
//      productA.setName("상품A");
//      em.persist(productA);
      
//      Member member1 = new Member();
//      member1.setId(1L);
//      member1.setName("멤버1");
//      member1.setAge(27);
      //단방향으로만 참조하는 경우
      
      
      
//      
//      productA.getMembers().add(member1);
//      member1.getProducts().add(productA);
      
    //  
//      member1.addProduct(productA);
      
//      em.persist(member1);
//      em.persist(productA);
	   
	   //find
//	   Member member = em.find(Member.class, 1L);
//	   System.out.println(member);
//	   
//	   List<Product> products = member.getProducts();
//	   for(Product product : products) {
//		   System.out.println(product);
//	   }
	   // 역으로 find 물건을 통해 어떤사람이 구매?
	   Product product = em.find(Product.class, 1L);
	   List<Member> members = product.getMembers();
	   for(Member member : members) {
		   System.out.println(member);
	   }
	   
      
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