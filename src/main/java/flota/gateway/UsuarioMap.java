package flota.gateway;

import flota.entity.Usuario;;

public interface UsuarioMap {
	public boolean  save (Usuario u); 
	public boolean remove (Usuario u); 
    public boolean update (Usuario u); 
    public void findById (String u); 
}
