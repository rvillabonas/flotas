package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TGF_TARIFA database table.
 * 
 */
@Entity
@Table(name="TGF_TARIFA")
@NamedQuery(name="Tgf_Tarifa.findAll", query="SELECT t FROM Tgf_Tarifa t")
public class Tgf_Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TARIFA", unique=true, nullable=false, precision=9)
	private long idTarifa;

	@Column(name="TAR_DESCRIPCION", nullable=false, length=60)
	private String tarDescripcion;

	@Column(name="TAR_NOMBRE", nullable=false, length=30)
	private String tarNombre;

	@Column(name="TAR_PRECIO", nullable=false, precision=6, scale=3)
	private BigDecimal tarPrecio;

	//bi-directional many-to-one association to Tgf_Vehiculo
	@OneToMany(mappedBy="tgfTarifa")
	private List<Tgf_Vehiculo> tgfVehiculos;

	public Tgf_Tarifa() {
	}

	public long getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getTarDescripcion() {
		return this.tarDescripcion;
	}

	public void setTarDescripcion(String tarDescripcion) {
		this.tarDescripcion = tarDescripcion;
	}

	public String getTarNombre() {
		return this.tarNombre;
	}

	public void setTarNombre(String tarNombre) {
		this.tarNombre = tarNombre;
	}

	public BigDecimal getTarPrecio() {
		return this.tarPrecio;
	}

	public void setTarPrecio(BigDecimal tarPrecio) {
		this.tarPrecio = tarPrecio;
	}

	public List<Tgf_Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Tgf_Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Tgf_Vehiculo addTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfTarifa(this);

		return tgfVehiculo;
	}

	public Tgf_Vehiculo removeTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfTarifa(null);

		return tgfVehiculo;
	}

}