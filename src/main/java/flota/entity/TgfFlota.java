package flota.entity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */

public class TgfFlota implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idFlota;
	private TgfPersona tgfPersona;
	private String floNombre;
	private String floDescripcion;
	private Date floFechaCreacion;
	private Set tgfVehiculos = new HashSet(0);

	public TgfFlota() {
	}

	public TgfFlota(int idFlota, TgfPersona tgfPersona, String floNombre, Date floFechaCreacion) {
		this.idFlota = idFlota;
		this.tgfPersona = tgfPersona;
		this.floNombre = floNombre;
		this.floFechaCreacion = floFechaCreacion;
	}

	public TgfFlota(int idFlota, TgfPersona tgfPersona, String floNombre, String floDescripcion, Date floFechaCreacion,
			Set tgfVehiculos) {
		this.idFlota = idFlota;
		this.tgfPersona = tgfPersona;
		this.floNombre = floNombre;
		this.floDescripcion = floDescripcion;
		this.floFechaCreacion = floFechaCreacion;
		this.tgfVehiculos = tgfVehiculos;
	}

	public int getIdFlota() {
		return this.idFlota;
	}

	public void setIdFlota(int idFlota) {
		this.idFlota = idFlota;
	}

	public TgfPersona getTgfPersona() {
		return this.tgfPersona;
	}

	public void setTgfPersona(TgfPersona tgfPersona) {
		this.tgfPersona = tgfPersona;
	}

	public String getFloNombre() {
		return this.floNombre;
	}

	public void setFloNombre(String floNombre) {
		this.floNombre = floNombre;
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

	public Set getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(Set tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

}
