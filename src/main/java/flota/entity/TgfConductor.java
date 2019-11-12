package flota.entity;


import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */
public class TgfConductor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dniConductor;
	private TgfTelefono tgfTelefono;
	private String conNombre1;
	private String conNombre2;
	private String conApellido1;
	private String conApellido2;
	private String conDireccion;
	private String conEstado;
	private String conEmail;
	private Set tgfVehiculos = new HashSet(0);

	public TgfConductor() {
	}

	public TgfConductor(String dniConductor, TgfTelefono tgfTelefono, String conNombre1, String conApellido1,
			String conEstado) {
		this.dniConductor = dniConductor;
		this.tgfTelefono = tgfTelefono;
		this.conNombre1 = conNombre1;
		this.conApellido1 = conApellido1;
		this.conEstado = conEstado;
	}

	public TgfConductor(String dniConductor, TgfTelefono tgfTelefono, String conNombre1, String conNombre2,
			String conApellido1, String conApellido2, String conDireccion, String conEstado, String conEmail,
			Set tgfVehiculos) {
		this.dniConductor = dniConductor;
		this.tgfTelefono = tgfTelefono;
		this.conNombre1 = conNombre1;
		this.conNombre2 = conNombre2;
		this.conApellido1 = conApellido1;
		this.conApellido2 = conApellido2;
		this.conDireccion = conDireccion;
		this.conEstado = conEstado;
		this.conEmail = conEmail;
		this.tgfVehiculos = tgfVehiculos;
	}

	public String getDniConductor() {
		return this.dniConductor;
	}

	public void setDniConductor(String dniConductor) {
		this.dniConductor = dniConductor;
	}

	public TgfTelefono getTgfTelefono() {
		return this.tgfTelefono;
	}

	public void setTgfTelefono(TgfTelefono tgfTelefono) {
		this.tgfTelefono = tgfTelefono;
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

	public String getConEstado() {
		return this.conEstado;
	}

	public void setConEstado(String conEstado) {
		this.conEstado = conEstado;
	}

	public String getConEmail() {
		return this.conEmail;
	}

	public void setConEmail(String conEmail) {
		this.conEmail = conEmail;
	}

	public Set getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(Set tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

}
