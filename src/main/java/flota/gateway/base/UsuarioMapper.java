package flota.gateway.base;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import flota.constantes.GenQuerys;
import flota.entity.Persona;
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
		} finally {
			if (em != null)
				em.close();
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
			em.getTransaction().rollback();
			return false;
		} finally {
			if (em != null)
				em.close();
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
		} finally {
			if (em != null)
				em.close();
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

	/**
	 * 
	 * @param idRol
	 * @param nickName
	 * @return
	 */

	/**
	 * Retorna una persona por su iD
	 * 
	 * @param idRol
	 * @param nickName
	 * @return
	 */
	public Persona findPerByIdRoL(Integer idRol, String nickName) {
		String dniPer;
		Persona p = null;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			Query query = em.createNativeQuery(GenQuerys.PER_LOGGED);
			query.setParameter("idRol", idRol);
			query.setParameter("nickName", nickName);	
			dniPer = (String) query.getSingleResult();
			p = em.find(Persona.class, dniPer); 
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return null;
		} finally {
			if (em != null)
				em.close();
		}
		return p;
	}
}
