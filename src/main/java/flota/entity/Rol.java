package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * @author rvns The persistent class for the TGF_ROL database table.
 * 
 */
@Entity
@Table(name = "TGF_ROL")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")
@NamedQuery(name = "Rol.findRoldID", query = "SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ROL")
	private int idRol;

	@Column(name = "ROL_NOMBRE")
	private String nombre;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "rols")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario us) {
		getUsuarios().add(us);
		us.setIdRol(this);
		return us;
	}

	public Usuario removeUsuario(Usuario us) {
		getUsuarios().remove(us);
		us.setIdRol(null);

		return us;
	}

	@Override
	public String toString() {
		return nombre;
	}

}