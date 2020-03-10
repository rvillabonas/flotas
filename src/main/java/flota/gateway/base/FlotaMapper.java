package flota.gateway.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import flota.entity.Flota;
import flota.gateway.FlotaMap;
import flota.util.ConnectionFactory;

public class FlotaMapper implements FlotaMap {
	private EntityManager em;

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
		}
	}

	@Override
	public boolean update(Flota f) {
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			em.getTransaction().begin();
			em.merge(f);
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public List<Flota> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flota findFlotaByClient(String clienId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flota findFlotaById(Integer flotId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * SE obtiene la un lista de flotas del cliente.
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<Flota> getAllFlotas() {
		List<Flota> listFlota = new ArrayList<Flota>();
		try {
			em = ConnectionFactory.getEntityManagerFactory().createEntityManager();
			listFlota = em.createNamedQuery("Flota.findAll").getResultList();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null)
				em.close();
		}
		return listFlota;
	}

	

}
