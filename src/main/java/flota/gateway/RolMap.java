package flota.gateway;

import java.util.List;
import flota.entity.Rol;

public interface RolMap {
	public void  save (Rol u); 
	public void remove (Rol u); 
    public void update (Rol u); 
    public List <Rol> buscarTodo (); 
}
