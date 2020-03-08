package flota.entity;

import java.io.Serializable;
import javax.persistence.*;

import javafx.beans.property.StringProperty;

import java.util.Date;
import java.util.List;

/**
 * @author rvns The persistent class for the TGF_USUARIO database table.
 * 
 */
@Entity
@Table(name = "TGF_USUARIO")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
@NamedStoredProcedureQuery(name = "login", procedureName = "kgf_usuario.pgf_validate_user", parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "usuario"),
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "passwd"),
		@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "usuVal") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USU_NICKNAME")
	private String nickname;

	@Temporal(TemporalType.DATE)
	@Column(name = "USU_FECHA_ULT_INGRESO")
	private Date fechaUltIngreso;

	@Column(name = "USU_PASSWORD")
	private String password;

	// bi-directional many-to-one association to Persona
	@OneToMany(mappedBy = "tgfUsuario")
	private List<Persona> tgfPersonas;

	public Usuario() {
	}

	@ManyToOne
	@JoinColumn(name = "ID_ROL" )
	private Rol rols;

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getFechaUltIngreso() {
		return this.fechaUltIngreso;
	}

	public void setFechaUltIngreso(final Date fechaUltIngreso) {
		this.fechaUltIngreso = fechaUltIngreso;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Persona> getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(List<Persona> tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

	public Persona addTgfPersona(Persona tgfPersona) {
		getTgfPersonas().add(tgfPersona);
		tgfPersona.setTgfUsuario(this);

		return tgfPersona;
	}

	public Persona removeTgfPersona(Persona tgfPersona) {
		getTgfPersonas().remove(tgfPersona);
		tgfPersona.setTgfUsuario(null);

		return tgfPersona;
	}

	public Rol getIdRol() {
		return this.rols;
	}

	public void setIdRol(Rol rol) {
		this.rols = rol;
	}
	

	
}