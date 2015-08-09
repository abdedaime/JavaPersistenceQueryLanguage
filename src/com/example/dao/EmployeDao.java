/**
 * 
 */
package com.example.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.hicham.model.Employe;

/**
 * @author hicham 1 déc. 2014 18:45:22
 */
// https://docs.jboss.org/hibernate/orm/3.6/quickstart/en-US/html/hibernate-gsg-tutorial-jpa.html
public class EmployeDao implements Dao<Employe> {

	private EntityManagerFactory entityManagerFactory;

	public EmployeDao() {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("JpqlDaAz");
	}

	@Override
	public void add(Employe t) {
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(t);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	@Override
	public Employe retrieve(Employe t) {

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		;
		Employe em = entityManager.find(Employe.class, t.getId());
		entityManager.getTransaction().commit();
		entityManager.close();
		return em;
	}

	@Override
	public void delete(Employe t) {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		em.remove(t);
		tr.commit();
		em.close();

	}

	@Override
	public List<Employe> getAll() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query qr = em.createQuery("select    e  from Employe as e  ");
		List<Employe> resultList = (List<Employe>) qr.getResultList();
		em.getTransaction().commit();
		em.close();

		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getNumberEmployeBydepartement() {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		Query qr = em
				.createQuery("select     count(e.id),e.departement    from Employe   as e group by  e.departement ");
		List<Object[]> all = qr.getResultList();
		tr.commit();
		em.close();
		return all;

	}

	@SuppressWarnings("unchecked")
	public List<Employe> getEmployeBetwenTodate(Date debut, Date fin) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query qr = em
				.createQuery("select   e  from Employe as e where e.dateEmbauche between ?1 and ?2  ");
		qr.setParameter(1, debut, TemporalType.DATE);
		qr.setParameter(2, fin);

		List<Employe> e = qr.getResultList();
		em.getTransaction().commit();
		em.close();
		return e;

	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getSommeSalDepartement() {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		Query qr = em
				.createQuery("select e.departement ,sum(e.sal) as somme  from Employe as e     group by  e.departement having somme>1300  order by  somme desc ");
		List<Object[]> all = qr.getResultList();
		em.getTransaction().commit();
		em.close();
		return all;

	}
}
