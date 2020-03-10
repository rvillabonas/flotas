package flota.gateway.base;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import flota.entity.Usuario;
import flota.gateway.UsuarioMap;
import flota.util.ConnectionFactory;

public class UsuarioMapper implements UsuarioMap {
	private EntityManager em;
	private boolean crud;

	/**
	 * Persistir usuario
	 */
	public boolean save(Usuario u) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	/**
	 * Remover Usuario.
	 */
	public boolean remove(Usuario u) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(u));
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error " + e.getCause());
			em.getTransaction().rollback();
			return false;
		}
	}

	/**
	 * Actualizar usuario.
	 */
	public boolean update(Usuario u) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}

	}

	/**
	 * Encontrar Usuario por su ID.
	 */
	public void findById(String u) {
		// TODO Auto-generated method stub
	}

	/**
	 * Autenticacion del usuario contra la base de datos.
	 * 
	 * @param user
	 * @param passwd
	 * @return Usuario
	 */
	public Usuario login(String user, String passwd) {
		Usuario u = null;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			StoredProcedureQuery query = em.createNamedStoredProcedureQuery("login");
			query.setParameter("usuario", user);
			query.setParameter("passwd", passwd);
			query.execute();
			String validUsuer = (String) query.getOutputParameterValue("usuVal");
			if (validUsuer.equals("S")) {
				Calendar cal = Calendar.getInstance();
				u = em.find(Usuario.class, user);
				u.setFechaUltIngreso(new java.sql.Date(cal.getTimeInMillis()));
				crud = this.update(u);
				if (!crud) {
					System.out.println("Error");
				}
			}

		} finally {
			if (em != null)
				em.close();
		}
		return u;
	}

}
