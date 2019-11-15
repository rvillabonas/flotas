package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TGF_USUARIO database table.
 * 
 */
@Entity
@Table(name="TGF_USUARIO")
@NamedQuery(name="Tgf_Usuario.findAll", query="SELECT t FROM Tgf_Usuario t")
public class Tgf_Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USU_NICKNAME", unique=true, nullable=false, length=30)
	private String usuNickname;

	@Temporal(TemporalType.DATE)
	@Column(name="USU_FECHA_ULT_INGRESO")
	private Date usuFechaUltIngreso;

	@Column(name="USU_PASSWORD", nullable=false, length=200)
	private String usuPassword;

	//bi-directional many-to-one association to Tgf_Persona
	@OneToMany(mappedBy="tgfUsuario")
	private List<Tgf_Persona> tgfPersonas;

	public Tgf_Usuario() {
	}

	public String getUsuNickname() {
		return this.usuNickname;
	}

	public void setUsuNickname(String usuNickname) {
		this.usuNickname = usuNickname;
	}

	public Date getUsuFechaUltIngreso() {
		return this.usuFechaUltIngreso;
	}

	public void setUsuFechaUltIngreso(Date usuFechaUltIngreso) {
		this.usuFechaUltIngreso = usuFechaUltIngreso;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public List<Tgf_Persona> getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(List<Tgf_Persona> tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

	public Tgf_Persona addTgfPersona(Tgf_Persona tgfPersona) {
		getTgfPersonas().add(tgfPersona);
		tgfPersona.setTgfUsuario(this);

		return tgfPersona;
	}

	public Tgf_Persona removeTgfPersona(Tgf_Persona tgfPersona) {
		getTgfPersonas().remove(tgfPersona);
		tgfPersona.setTgfUsuario(null);

		return tgfPersona;
	}

}