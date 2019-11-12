package flota.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */
public class TgfTarifa implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idTarifa;
	private String tarNombre;
	private String tarDescripcion;
	private BigDecimal tarPrecio;
	private Set tgfVehiculos = new HashSet(0);

	public TgfTarifa() {
	}

	public TgfTarifa(int idTarifa, String tarNombre, String tarDescripcion, BigDecimal tarPrecio) {
		this.idTarifa = idTarifa;
		this.tarNombre = tarNombre;
		this.tarDescripcion = tarDescripcion;
		this.tarPrecio = tarPrecio;
	}

	public TgfTarifa(int idTarifa, String tarNombre, String tarDescripcion, BigDecimal tarPrecio, Set tgfVehiculos) {
		this.idTarifa = idTarifa;
		this.tarNombre = tarNombre;
		this.tarDescripcion = tarDescripcion;
		this.tarPrecio = tarPrecio;
		this.tgfVehiculos = tgfVehiculos;
	}

	public int getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public String getTarNombre() {
		return this.tarNombre;
	}

	public void setTarNombre(String tarNombre) {
		this.tarNombre = tarNombre;
	}

	public String getTarDescripcion() {
		return this.tarDescripcion;
	}

	public void setTarDescripcion(String tarDescripcion) {
		this.tarDescripcion = tarDescripcion;
	}

	public BigDecimal getTarPrecio() {
		return this.tarPrecio;
	}

	public void setTarPrecio(BigDecimal tarPrecio) {
		this.tarPrecio = tarPrecio;
	}

	public Set getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(Set tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

}
