package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TGF_FLOTA database table.
 * 
 */
@Entity
@Table(name="TGF_FLOTA")
@NamedQuery(name="Tgf_Flota.findAll", query="SELECT t FROM Tgf_Flota t")
public class Tgf_Flota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FLOTA", unique=true, nullable=false, precision=9)
	private long idFlota;

	@Column(name="FLO_DESCRIPCION", length=60)
	private String floDescripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FLO_FECHA_CREACION", nullable=false)
	private Date floFechaCreacion;

	@Column(name="FLO_NOMBRE", nullable=false, length=30)
	private String floNombre;

	//bi-directional many-to-one association to Tgf_Persona
	@ManyToOne
	@JoinColumn(name="PER_DNI", nullable=false)
	private Tgf_Persona tgfPersona;

	//bi-directional many-to-one association to Tgf_Vehiculo
	@OneToMany(mappedBy="tgfFlota")
	private List<Tgf_Vehiculo> tgfVehiculos;

	public Tgf_Flota() {
	}

	public long getIdFlota() {
		return this.idFlota;
	}

	public void setIdFlota(long idFlota) {
		this.idFlota = idFlota;
	}

	public String getFloDescripcion() {
		return this.floDescripcion;
	}

	public void setFloDescripcion(String floDescripcion) {
		this.floDescripcion = floDescripcion;
	}

	public Date getFloFechaCreacion() {
		return this.floFechaCreacion;
	}

	public void setFloFechaCreacion(Date floFechaCreacion) {
		this.floFechaCreacion = floFechaCreacion;
	}

	public String getFloNombre() {
		return this.floNombre;
	}

	public void setFloNombre(String floNombre) {
		this.floNombre = floNombre;
	}

	public Tgf_Persona getTgfPersona() {
		return this.tgfPersona;
	}

	public void setTgfPersona(Tgf_Persona tgfPersona) {
		this.tgfPersona = tgfPersona;
	}

	public List<Tgf_Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Tgf_Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Tgf_Vehiculo addTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfFlota(this);

		return tgfVehiculo;
	}

	public Tgf_Vehiculo removeTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfFlota(null);

		return tgfVehiculo;
	}

}