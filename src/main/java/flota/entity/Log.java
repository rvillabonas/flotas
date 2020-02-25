package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * @author rvns
 * The persistent class for the TGF_LOG database table.
 * 
 */
@Entity
@Table(name="TGF_LOG")
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_LOG")
	private long idLog;

	@Column(name="LOG_CONDUCTOR")
	private String conductor;

	@Column(name="LOG_FECHA")
	private Timestamp fecha;

	@Column(name="LOG_OBSERVACIONES")
	private String observaciones;

	@Column(name="LOG_PLACA")
	private String placa;

	@Column(name="LOG_USUARIO")
	private String usuario;

	public Log() {
	}

	public long getIdLog() {
		return this.idLog;
	}

	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}

	public String getConductor() {
		return this.conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public Timestamp getFecha() {
		return this.fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}