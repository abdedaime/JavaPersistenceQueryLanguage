package com.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.hicham.model.Departement;

/**
 * @author hicham
 *
 */
public class DepartementDao {
	private EntityManagerFactory entityManagerFactory;

	public DepartementDao() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("JpqlDaAz");
	}

	public void addDeparetement(Departement dt) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.persist(dt);
		tr.commit();
		em.close();

	}
	

	public Departement getDeparetementById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Departement dt = em.find(Departement.class, id);
		em.getTransaction().commit();
		em.close();
		return dt;
	}
}
