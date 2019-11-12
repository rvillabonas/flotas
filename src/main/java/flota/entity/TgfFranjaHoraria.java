package flota.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */

public class TgfFranjaHoraria implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idFranjaHoraria;
	private String fhoNombre;
	private String fhoDescripcion;
	private boolean fhoDiaSem;
	private String fhoHoraInicial;
	private String fhoHoraFinal;
	private String fhoEstado;
	private Date fhoFechaRegistro;
	private Set tgfVehiculos = new HashSet(0);

	public TgfFranjaHoraria() {
	}

	public TgfFranjaHoraria(int idFranjaHoraria, String fhoNombre, boolean fhoDiaSem, String fhoHoraInicial,
			String fhoHoraFinal, String fhoEstado) {
		this.idFranjaHoraria = idFranjaHoraria;
		this.fhoNombre = fhoNombre;
		this.fhoDiaSem = fhoDiaSem;
		this.fhoHoraInicial = fhoHoraInicial;
		this.fhoHoraFinal = fhoHoraFinal;
		this.fhoEstado = fhoEstado;
	}

	public TgfFranjaHoraria(int idFranjaHoraria, String fhoNombre, String fhoDescripcion, boolean fhoDiaSem,
			String fhoHoraInicial, String fhoHoraFinal, String fhoEstado, Date fhoFechaRegistro, Set tgfVehiculos) {
		this.idFranjaHoraria = idFranjaHoraria;
		this.fhoNombre = fhoNombre;
		this.fhoDescripcion = fhoDescripcion;
		this.fhoDiaSem = fhoDiaSem;
		this.fhoHoraInicial = fhoHoraInicial;
		this.fhoHoraFinal = fhoHoraFinal;
		this.fhoEstado = fhoEstado;
		this.fhoFechaRegistro = fhoFechaRegistro;
		this.tgfVehiculos = tgfVehiculos;
	}

	public int getIdFranjaHoraria() {
		return this.idFranjaHoraria;
	}

	public void setIdFranjaHoraria(int idFranjaHoraria) {
		this.idFranjaHoraria = idFranjaHoraria;
	}

	public String getFhoNombre() {
		return this.fhoNombre;
	}

	public void setFhoNombre(String fhoNombre) {
		this.fhoNombre = fhoNombre;
	}

	public String getFhoDescripcion() {
		return this.fhoDescripcion;
	}

	public void setFhoDescripcion(String fhoDescripcion) {
		this.fhoDescripcion = fhoDescripcion;
	}

	public boolean isFhoDiaSem() {
		return this.fhoDiaSem;
	}

	public void setFhoDiaSem(boolean fhoDiaSem) {
		this.fhoDiaSem = fhoDiaSem;
	}

	public String getFhoHoraInicial() {
		return this.fhoHoraInicial;
	}

	public void setFhoHoraInicial(String fhoHoraInicial) {
		this.fhoHoraInicial = fhoHoraInicial;
	}

	public String getFhoHoraFinal() {
		return this.fhoHoraFinal;
	}

	public void setFhoHoraFinal(String fhoHoraFinal) {
		this.fhoHoraFinal = fhoHoraFinal;
	}

	public String getFhoEstado() {
		return this.fhoEstado;
	}

	public void setFhoEstado(String fhoEstado) {
		this.fhoEstado = fhoEstado;
	}

	public Date getFhoFechaRegistro() {
		return this.fhoFechaRegistro;
	}

	public void setFhoFechaRegistro(Date fhoFechaRegistro) {
		this.fhoFechaRegistro = fhoFechaRegistro;
	}

	public Set getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(Set tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

}
