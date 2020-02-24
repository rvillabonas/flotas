package flota.gateway.base;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

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

	// private Usuario usuario;

	public boolean login(String user, String passwd) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("login");
			query.setParameter("usuario", user);
			query.setParameter("passwd", passwd);
			query.execute();
			String validUsuer = (String) query.getOutputParameterValue("usuVal");

			if (validUsuer.equals("S")) {
				Usuario u = em.find(Usuario.class, user); 
     			u.setFechaUltIngreso(new java.sql.Timestamp(System.currentTimeMillis()));
				this.update (u); 
			}

		} finally {
			if (em != null)
				em.close();
		}

		return true;
	}

	public void findById(String u) {
		// List <Usuario> us = (List<Usuario>) em.createQuery("select u from
		// Usuario u").getResultList();
		// TODO Auto-generated method stub
	}

}
