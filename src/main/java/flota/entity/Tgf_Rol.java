package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TGF_ROL database table.
 * 
 */
@Entity
@Table(name="TGF_ROL")
@NamedQuery(name="Tgf_Rol.findAll", query="SELECT t FROM Tgf_Rol t")
public class Tgf_Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ROL", unique=true, nullable=false, precision=10)
	private long idRol;

	@Column(name="ROL_NOMBRE", nullable=false, length=30)
	private String rolNombre;

	//bi-directional many-to-one association to Tgf_Persona
	@OneToMany(mappedBy="tgfRol")
	private List<Tgf_Persona> tgfPersonas;

	public Tgf_Rol() {
	}

	public long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}

	public String getRolNombre() {
		return this.rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	public List<Tgf_Persona> getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(List<Tgf_Persona> tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

	public Tgf_Persona addTgfPersona(Tgf_Persona tgfPersona) {
		getTgfPersonas().add(tgfPersona);
		tgfPersona.setTgfRol(this);

		return tgfPersona;
	}

	public Tgf_Persona removeTgfPersona(Tgf_Persona tgfPersona) {
		getTgfPersonas().remove(tgfPersona);
		tgfPersona.setTgfRol(null);

		return tgfPersona;
	}

}