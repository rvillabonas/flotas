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
@NamedQuery(name="Telefono.findAll", query="SELECT t FROM Telefono t")
public class Telefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEL_NUMERO")
	private String telNumero;

	@Column(name="TEL_DESCRIPCION")
	private String descripcion;

	//bi-directional many-to-one association to Conductor
	@OneToMany(mappedBy="tgfTelefono1")
	private List<Conductor> tgfConductors1;

	//bi-directional many-to-one association to Conductor
	@OneToMany(mappedBy="tgfTelefono2")
	private List<Conductor> tgfConductors2;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tgfTelefono1")
	private List<Persona> tgfPersonas1;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="tgfTelefono2")
	private List<Persona> tgfPersonas2;

	public Telefono() {
	}

	public String getTelNumero() {
		return this.telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Conductor> getTgfConductors1() {
		return this.tgfConductors1;
	}

	public void setTgfConductors1(List<Conductor> tgfConductors1) {
		this.tgfConductors1 = tgfConductors1;
	}

	public Conductor addTgfConductors1(Conductor tgfConductors1) {
		getTgfConductors1().add(tgfConductors1);
		tgfConductors1.setTgfTelefono1(this);

		return tgfConductors1;
	}

	public Conductor removeTgfConductors1(Conductor tgfConductors1) {
		getTgfConductors1().remove(tgfConductors1);
		tgfConductors1.setTgfTelefono1(null);

		return tgfConductors1;
	}

	public List<Conductor> getTgfConductors2() {
		return this.tgfConductors2;
	}

	public void setTgfConductors2(List<Conductor> tgfConductors2) {
		this.tgfConductors2 = tgfConductors2;
	}

	public Conductor addTgfConductors2(Conductor tgfConductors2) {
		getTgfConductors2().add(tgfConductors2);
		tgfConductors2.setTgfTelefono2(this);

		return tgfConductors2;
	}

	public Conductor removeTgfConductors2(Conductor tgfConductors2) {
		getTgfConductors2().remove(tgfConductors2);
		tgfConductors2.setTgfTelefono2(null);

		return tgfConductors2;
	}

	public List<Persona> getTgfPersonas1() {
		return this.tgfPersonas1;
	}

	public void setTgfPersonas1(List<Persona> tgfPersonas1) {
		this.tgfPersonas1 = tgfPersonas1;
	}

	public Persona addTgfPersonas1(Persona tgfPersonas1) {
		getTgfPersonas1().add(tgfPersonas1);
		tgfPersonas1.setTgfTelefono1(this);

		return tgfPersonas1;
	}

	public Persona removeTgfPersonas1(Persona tgfPersonas1) {
		getTgfPersonas1().remove(tgfPersonas1);
		tgfPersonas1.setTgfTelefono1(null);

		return tgfPersonas1;
	}

	public List<Persona> getTgfPersonas2() {
		return this.tgfPersonas2;
	}

	public void setTgfPersonas2(List<Persona> tgfPersonas2) {
		this.tgfPersonas2 = tgfPersonas2;
	}

	public Persona addTgfPersonas2(Persona tgfPersonas2) {
		getTgfPersonas2().add(tgfPersonas2);
		tgfPersonas2.setTgfTelefono2(this);

		return tgfPersonas2;
	}

	public Persona removeTgfPersonas2(Persona tgfPersonas2) {
		getTgfPersonas2().remove(tgfPersonas2);
		tgfPersonas2.setTgfTelefono2(null);

		return tgfPersonas2;
	}

}