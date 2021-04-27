package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.TipologiaSexo;

public class ControladorSexo {
		
		private static ControladorSexo instance = null;
		private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
		
		public static ControladorSexo getInstance() {
			if (instance == null) {
				instance = new ControladorSexo();
			}
			return instance;
		}

		/**
		 * 
		 * @return
		 */
		public List<TipologiaSexo> findAll() {
			EntityManager em = factory.createEntityManager();

			Query q = em.createNativeQuery("SELECT * FROM tipologiaSexo", TipologiaSexo.class);

			List<TipologiaSexo> list = (List<TipologiaSexo>) q.getResultList();
			em.close();
			return list;
		}
}
