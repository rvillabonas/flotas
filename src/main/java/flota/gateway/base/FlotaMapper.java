package flota.gateway.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import flota.constantes.GenQuerys;
import flota.entity.Flota;
import flota.entity.Persona;
import flota.entity.Rol;
import flota.gateway.FlotaMap;
import flota.util.ConnectionFactory;

public class FlotaMapper implements FlotaMap {
	private EntityManager em;
	Persona p;

	@Override
	public boolean save(Flota f) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.persist(f);
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

	@Override
	public boolean remove(Flota f) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(f));
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

	@Override
	public boolean update(Flota f) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			//f = em.find(Flota.class,  );
			
			em.merge(f);
			em.flush();
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

	@Override
	public List<Flota> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Se obtiene la un lista de flotas del cliente.
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Flota> findFlotaByClient(String idClient) {
		List<Flota> listFlota = new ArrayList<Flota>();
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			Query query = em.createQuery(GenQuerys.FLOTA_BY_CLIENT);
			query.setParameter("idPer", idClient);
			listFlota = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (em != null)
				em.close();
		}
		return listFlota;

	}

	@Override
	public Flota findFlotaById(Integer flotId) {
		// TODO Auto-generated method stub
		return null;
	}
}
