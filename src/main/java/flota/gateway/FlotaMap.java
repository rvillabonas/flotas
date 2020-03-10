package flota.gateway;

import java.util.List;
import flota.entity.Flota;

public interface FlotaMap {

	public boolean save(Flota f);

	public boolean remove(Flota f);

	public boolean update(Flota f);

	public List<Flota> getAll();

	public Flota findFlotaByClient(String clienId);

	public Flota findFlotaById(Integer flotId);

}
