package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/*
 * @author rvns
 * The persistent class for the TGF_TARIFA database table.
 * 
 */
@Entity
@Table(name="TGF_TARIFA")
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_TARIFA")
	private long idTarifa;

	@Column(name="TAR_DESCRIPCION")
	private String descripcion;

	@Column(name="TAR_NOMBRE")
	private String nombre;

	@Column(name="TAR_PRECIO")
	private BigDecimal precio;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="tgfTarifa")
	private List<Vehiculo> tgfVehiculos;

	public Tarifa() {
	}

	public long getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Vehiculo addTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfTarifa(this);

		return tgfVehiculo;
	}

	public Vehiculo removeTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfTarifa(null);

		return tgfVehiculo;
	}

}