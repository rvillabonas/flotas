package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TGF_CONDUCTOR database table.
 * 
 */
@Entity
@Table(name="TGF_CONDUCTOR")
@NamedQuery(name="Conductor.findAll", query="SELECT c FROM Conductor c")
public class Conductor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DNI_CONDUCTOR")
	private String dniConductor;

	@Column(name="CON_APELLIDO1")
	private String apellido1;

	@Column(name="CON_APELLIDO2")
	private String apellido2;

	@Column(name="CON_DIRECCION")
	private String direccion;

	@Column(name="CON_EMAIL")
	private String email;

	@Column(name="CON_ESTADO")
	private String estado;

	@Column(name="CON_NOMBRE1")
	private String nombre1;

	@Column(name="CON_NOMBRE2")
	private String nombre2;

	@Column(name="ID_CLIENTE")
	private String idCliente;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TEL_NUMERO2")
	private Telefono tgfTelefono1;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TEL_NUMERO1")
	private Telefono tgfTelefono2;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="tgfConductor")
	private List<Vehiculo> tgfVehiculos;

	public Conductor() {
	}

	public String getDniConductor() {
		return this.dniConductor;
	}

	public void setDniConductor(String dniConductor) {
		this.dniConductor = dniConductor;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Telefono getTgfTelefono1() {
		return this.tgfTelefono1;
	}

	public void setTgfTelefono1(Telefono tgfTelefono1) {
		this.tgfTelefono1 = tgfTelefono1;
	}

	public Telefono getTgfTelefono2() {
		return this.tgfTelefono2;
	}

	public void setTgfTelefono2(Telefono tgfTelefono2) {
		this.tgfTelefono2 = tgfTelefono2;
	}

	public List<Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Vehiculo addTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfConductor(this);

		return tgfVehiculo;
	}

	public Vehiculo removeTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfConductor(null);

		return tgfVehiculo;
	}

}