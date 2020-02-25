package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * @author rvns
 * The persistent class for the TGF_ROL database table.
 * 
 */
@Entity
@Table(name="TGF_ROL")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_ROL")
	private long idRol;

	@Column(name="ROL_NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tgfRol")
	private List<Persona> tgfPersonas;

	public Rol() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(List<Persona> tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

	public Persona addTgfPersona(Persona tgfPersona) {
		getTgfPersonas().add(tgfPersona);
		tgfPersona.setTgfRol(this);

		return tgfPersona;
	}

	public Persona removeTgfPersona(Persona tgfPersona) {
		getTgfPersonas().remove(tgfPersona);
		tgfPersona.setTgfRol(null);

		return tgfPersona;
	}

}