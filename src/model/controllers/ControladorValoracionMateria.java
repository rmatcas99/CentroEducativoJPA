package model.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

public class ControladorValoracionMateria {

	public ControladorValoracionMateria() {
		// TODO Auto-generated constructor stub
	}

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");

	// instancia del singleton
	private static ControladorValoracionMateria instancia = null;

	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInstancia() {
		if (instancia == null) {
			instancia = new ControladorValoracionMateria();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findByMateriaAndProfesorAndEstudiante(Materia m, Profesor p, Estudiante e) {
		ValoracionMateria resultado = null;
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createNativeQuery(
					"SELECT * FROM valoracionmateria where idMateria = ? and " + "idProfesor = ? and idEstudiante = ?",
					ValoracionMateria.class);
			q.setParameter(1, m.getId());
			q.setParameter(2, p.getId());
			q.setParameter(3, e.getId());
			resultado = (ValoracionMateria) q.getSingleResult();
			em.close();
		} catch (NoResultException nrEx) {
		}
		return resultado;
	}
	
	public ValoracionMateria findByMateriaAndProfesorAndEstudianteAndValoracion(Materia materia, Profesor profesor,
			Estudiante estudiante, Float valoracion) {
		ValoracionMateria resultado = null;
		EntityManager em = factory.createEntityManager();
		 
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ? and valoracion = ?", ValoracionMateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			q.setParameter(4, valoracion);
			
			resultado = (ValoracionMateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		em.close();
		return resultado;
	}

	/**
	 * 
	 * @param e
	 */
	public boolean save(ValoracionMateria e) {
		EntityManager em = this.factory.createEntityManager();
		try {
			em.getTransaction().begin();
			if (e.getId() != 0) {
				em.merge(e);
			} else {
				em.persist(e);
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}

}
