package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TGF_TELEFONO database table.
 * 
 */
@Entity
@Table(name="TGF_TELEFONO")
@NamedQuery(name="Tgf_Telefono.findAll", query="SELECT t FROM Tgf_Telefono t")
public class Tgf_Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEL_NUMERO", unique=true, nullable=false, length=30)
	private String telNumero;

	@Column(name="TEL_DESCRIPCION", nullable=false, length=30)
	private String telDescripcion;

	//bi-directional many-to-one association to Tgf_Conductor
	@OneToMany(mappedBy="tgfTelefono")
	private List<Tgf_Conductor> tgfConductors;

	//bi-directional many-to-one association to Tgf_Persona
	@OneToMany(mappedBy="tgfTelefono")
	private List<Tgf_Persona> tgfPersonas;

	public Tgf_Telefono() {
	}

	public String getTelNumero() {
		return this.telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getTelDescripcion() {
		return this.telDescripcion;
	}

	public void setTelDescripcion(String telDescripcion) {
		this.telDescripcion = telDescripcion;
	}

	public List<Tgf_Conductor> getTgfConductors() {
		return this.tgfConductors;
	}

	public void setTgfConductors(List<Tgf_Conductor> tgfConductors) {
		this.tgfConductors = tgfConductors;
	}

	public Tgf_Conductor addTgfConductor(Tgf_Conductor tgfConductor) {
		getTgfConductors().add(tgfConductor);
		tgfConductor.setTgfTelefono(this);

		return tgfConductor;
	}

	public Tgf_Conductor removeTgfConductor(Tgf_Conductor tgfConductor) {
		getTgfConductors().remove(tgfConductor);
		tgfConductor.setTgfTelefono(null);

		return tgfConductor;
	}

	public List<Tgf_Persona> getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(List<Tgf_Persona> tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

	public Tgf_Persona addTgfPersona(Tgf_Persona tgfPersona) {
		getTgfPersonas().add(tgfPersona);
		tgfPersona.setTgfTelefono(this);

		return tgfPersona;
	}

	public Tgf_Persona removeTgfPersona(Tgf_Persona tgfPersona) {
		getTgfPersonas().remove(tgfPersona);
		tgfPersona.setTgfTelefono(null);

		return tgfPersona;
	}

}