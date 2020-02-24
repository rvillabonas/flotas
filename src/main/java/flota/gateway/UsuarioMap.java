package flota.gateway;

import flota.entity.Usuario;;

public interface UsuarioMap {
	public void  save (Usuario u); 
	public void remove (Usuario u); 
    public void update (Usuario u); 
    public void findById (String u); 
}
