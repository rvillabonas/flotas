package flota.gateway;

import flota.entity.Usuario;

public interface UsuarioMap {
	public void  save (Usuario u); 
	public void remove (Usuario u); 
    public Usuario update (Usuario u); 
    public void findById (String u); 
}
