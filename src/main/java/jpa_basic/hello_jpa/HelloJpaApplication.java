package jpa_basic.hello_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class HelloJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJpaApplication.class, args);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member = new Member();
			member.setId(2L);
			member.setName("HelloB");
			em.persist(member);

			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
