package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author rvns The persistent class for the TGF_FLOTA database table.
 * 
 */
@Entity
@Table(name = "TGF_FLOTA")
@NamedQuery(name = "Flota.findAll", query = "SELECT f FROM Flota f")
public class Flota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_FLOTA")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "generator")
	@SequenceGenerator(name ="generator", sequenceName = "TGF_FLOTA_SEQ", allocationSize = 1) 
	private int idFlota;

	@Column(name = "FLO_DESCRIPCION")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name = "FLO_FECHA_CREACION")
	private Date fechaCreacion;

	@Column(name = "FLO_NOMBRE")
	private String nombre;

	// bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name = "PER_DNI")
	private Persona tgfPersona;

	// bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy = "tgfFlota")
	private List<Vehiculo> tgfVehiculos;

	public Flota() {
	}

	public int getIdFlota() {
		return this.idFlota;
	}

	public void setIdFlota(int idFlota) {
		this.idFlota = idFlota;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getTgfPersona() {
		return this.tgfPersona;
	}

	public void setTgfPersona(Persona tgfPersona) {
		this.tgfPersona = tgfPersona;
	}

	public List<Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Vehiculo addTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfFlota(this);

		return tgfVehiculo;
	}

	public Vehiculo removeTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfFlota(null);

		return tgfVehiculo;
	}

}