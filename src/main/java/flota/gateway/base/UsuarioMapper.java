package flota.gateway.base;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import flota.config.GenQuerys;
import flota.entity.Usuario;
import flota.gateway.UsuarioMap;
import flota.util.ConnectionFactory;

public class UsuarioMapper implements UsuarioMap {
	private EntityManager em;

	public void save(Usuario u) {
		// TODO Auto-generated method stub

	}

	public void remove(Usuario u) {
		// TODO Auto-generated method stub

	}

	public void update(Usuario u) {

		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public String login(String user, String passwd) {
		String loginStatus;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("login");
			query.setParameter("usuario", user);
			query.setParameter("passwd", passwd);
			query.execute();
			String validUsuer = (String) query.getOutputParameterValue("usuVal");

			if (validUsuer.equals("S")) {
				Calendar cal = Calendar.getInstance();
				Usuario u = em.find(Usuario.class, user);
				u.setFechaUltIngreso(new java.sql.Date(cal.getTimeInMillis()));
				this.update(u);
				loginStatus = user;
			} else {
				loginStatus = null;

			}

		} finally {
			if (em != null)
				em.close();
		}
		return loginStatus;
	}

	public String obtenerRol(String nombreUs) {
		String perDni = null;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			Query q = em.createNativeQuery(GenQuerys.PERFIL_PERSONA);
			q.setParameter("nickname", nombreUs);
			perDni = (String) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

		return perDni;
	}

	public void findById(String u) {
		// List <Usuario> us = (List<Usuario>) em.createQuery("select u from
		// Usuario u").getResultList();
		// TODO Auto-generated method stub
	}

}
