package flota.gateway.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import flota.config.GenQuerys;
import flota.entity.Rol;
import flota.entity.Usuario;
import flota.gateway.RolMap;
import flota.util.ConnectionFactory;

public class RolMapper implements RolMap {
	private EntityManager em;

	@Override
	public void save(Rol u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Rol u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Rol u) {
		// TODO Auto-generated method stub

	}

	/**
	 * Se obtienen la lista de usuarios registrados.
	 * 
	 * @return List<Usuario>
	 */
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		List<Usuario> us = new ArrayList<Usuario>();
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			us = em.createNamedQuery("Usuario.findAll").getResultList();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
		return us;
	}

	/**
	 * Se obtine la lista de roles de la aplicacion
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Rol> buscarTodo() {
		List<Rol> rol = new ArrayList<Rol>();
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			rol = em.createNamedQuery("Rol.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
		return rol;
	}

	/**
	 * Obtener el id de un rol
	 * 
	 * @param idenRol
	 * @return
	 */
	public int obtenerRol(String idenRol) {
		int usuRol = 0;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			Query q = em.createNativeQuery(GenQuerys.ROL_DESCRIP);
			q.setParameter("rolname", idenRol);
			usuRol = ((BigDecimal) q.getSingleResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

		return usuRol;
	}
/**
 * Obtener rol by id.
 * @param idRol
 * @return
 */
	public Rol getById(int idRol) {
		Rol rol = null;
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			rol = em.find(Rol.class, idRol);
			System.out.println("rol nombre "  + rol.getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}

		return rol;
	}

}
