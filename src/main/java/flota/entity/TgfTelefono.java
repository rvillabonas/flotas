package flota.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */
public class TgfTelefono implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String telNumero;
	private String telDescripcion;
	private Set tgfConductors = new HashSet(0);
	private Set tgfPersonas = new HashSet(0);

	public TgfTelefono() {
	}

	public TgfTelefono(String telNumero, String telDescripcion) {
		this.telNumero = telNumero;
		this.telDescripcion = telDescripcion;
	}

	public TgfTelefono(String telNumero, String telDescripcion, Set tgfConductors, Set tgfPersonas) {
		this.telNumero = telNumero;
		this.telDescripcion = telDescripcion;
		this.tgfConductors = tgfConductors;
		this.tgfPersonas = tgfPersonas;
	}

	public String getTelNumero() {
		return this.telNumero;
	}

	public void setTelNumero(String telNumero) {
		this.telNumero = telNumero;
	}

	public String getTelDescripcion() {
		return this.telDescripcion;
	}

	public void setTelDescripcion(String telDescripcion) {
		this.telDescripcion = telDescripcion;
	}

	public Set getTgfConductors() {
		return this.tgfConductors;
	}

	public void setTgfConductors(Set tgfConductors) {
		this.tgfConductors = tgfConductors;
	}

	public Set getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(Set tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

}
