package flota.gateway.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import flota.config.GenQuerys;
import flota.entity.Usuario;
import flota.gateway.UsuarioMap;
import flota.util.ConnectionFactory;
import flota.view.tables.UsuarioTableView;

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
		return false;
		// TODO Auto-generated method stub

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
		// List <Usuario> us = (List<Usuario>) em.createQuery("select u from
		// Usuario u").getResultList();
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
	 * Obtener el rol del usuario que accede a la aplicacion.
	 * 
	 * @param nombreUs
	 * @return usuRol
	 */
	public int obtenerRol(String nombreUs) {
		int usuRol = 0;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			Query q = em.createNativeQuery(GenQuerys.PERFIL_PERSONA);
			q.setParameter("nickname", nombreUs);
			usuRol = ((BigDecimal) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

		return usuRol;
	}

}
