package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Profesor;

public class ControladorEstudiante {

	private static ControladorEstudiante instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");

	/**
	 * 
	 * @return
	 */
	public static ControladorEstudiante getInstance() {
		if (instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}

	/**
	 * 
	 */
	public ControladorEstudiante() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return
	 */
	public Estudiante findPrimero() {
		Estudiante es = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1",
				Estudiante.class);
		es = (Estudiante) q.getSingleResult();
		em.close();

		return es;
	}

	public Estudiante findUltimo() {
		Estudiante es = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1",
				Estudiante.class);
		es = (Estudiante) q.getSingleResult();
		em.close();

		return es;

	}

	/**
	 * 
	 * @param idActual
	 * @return
	 */
	public Estudiante findSiguiente(int idActual) {
		Estudiante es = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1",
				Estudiante.class);
		q.setParameter(1, idActual);
		es = (Estudiante) q.getSingleResult();
		em.close();

		return es;
	}

	/**
	 * 
	 * @param idActual
	 * @return
	 */
	public Estudiante findAnterior(int idActual) {
		Estudiante es = null;

		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1",
				Estudiante.class);
		q.setParameter(1, idActual);
		es = (Estudiante) q.getSingleResult();
		em.close();

		return es;
	}
	
	public boolean guardar (Estudiante es) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (es.getId() == 0) {
				em.persist(es);
			}
			else {
				em.merge(es);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Estudiante es) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		es = em.merge(es);
		em.remove(es);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Estudiante> findAll() {
		EntityManager em = factory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);

		List<Estudiante> list = (List<Estudiante>) q.getResultList();
		em.close();
		return list;
	}

}
