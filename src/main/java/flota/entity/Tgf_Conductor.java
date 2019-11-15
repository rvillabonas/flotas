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
@NamedQuery(name="Tgf_Conductor.findAll", query="SELECT t FROM Tgf_Conductor t")
public class Tgf_Conductor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DNI_CONDUCTOR", unique=true, nullable=false, length=60)
	private String dniConductor;

	@Column(name="CON_APELLIDO1", nullable=false, length=30)
	private String conApellido1;

	@Column(name="CON_APELLIDO2", length=30)
	private String conApellido2;

	@Column(name="CON_DIRECCION", length=60)
	private String conDireccion;

	@Column(name="CON_EMAIL", length=320)
	private String conEmail;

	@Column(name="CON_ESTADO", nullable=false, length=3)
	private String conEstado;

	@Column(name="CON_NOMBRE1", nullable=false, length=30)
	private String conNombre1;

	@Column(name="CON_NOMBRE2", length=30)
	private String conNombre2;

	//bi-directional many-to-one association to Tgf_Telefono
	@ManyToOne
	@JoinColumn(name="TEL_NUMERO", nullable=false)
	private Tgf_Telefono tgfTelefono;

	//bi-directional many-to-one association to Tgf_Vehiculo
	@OneToMany(mappedBy="tgfConductor")
	private List<Tgf_Vehiculo> tgfVehiculos;

	public Tgf_Conductor() {
	}

	public String getDniConductor() {
		return this.dniConductor;
	}

	public void setDniConductor(String dniConductor) {
		this.dniConductor = dniConductor;
	}

	public String getConApellido1() {
		return this.conApellido1;
	}

	public void setConApellido1(String conApellido1) {
		this.conApellido1 = conApellido1;
	}

	public String getConApellido2() {
		return this.conApellido2;
	}

	public void setConApellido2(String conApellido2) {
		this.conApellido2 = conApellido2;
	}

	public String getConDireccion() {
		return this.conDireccion;
	}

	public void setConDireccion(String conDireccion) {
		this.conDireccion = conDireccion;
	}

	public String getConEmail() {
		return this.conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public String getConEstado() {
		return this.conEstado;
	}

	public void setConEstado(String conEstado) {
		this.conEstado = conEstado;
	}

	public String getConNombre1() {
		return this.conNombre1;
	}

	public void setConNombre1(String conNombre1) {
		this.conNombre1 = conNombre1;
	}

	public String getConNombre2() {
		return this.conNombre2;
	}

	public void setConNombre2(String conNombre2) {
		this.conNombre2 = conNombre2;
	}

	public Tgf_Telefono getTgfTelefono() {
		return this.tgfTelefono;
	}

	public void setTgfTelefono(Tgf_Telefono tgfTelefono) {
		this.tgfTelefono = tgfTelefono;
	}

	public List<Tgf_Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Tgf_Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Tgf_Vehiculo addTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfConductor(this);

		return tgfVehiculo;
	}

	public Tgf_Vehiculo removeTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfConductor(null);

		return tgfVehiculo;
	}

}