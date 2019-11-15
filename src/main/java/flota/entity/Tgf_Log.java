package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the TGF_LOG database table.
 * 
 */
@Entity
@Table(name="TGF_LOG")
@NamedQuery(name="Tgf_Log.findAll", query="SELECT t FROM Tgf_Log t")
public class Tgf_Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_LOG", unique=true, nullable=false, precision=9)
	private long idLog;

	@Column(name="LOG_CONDUCTOR", length=60)
	private String logConductor;

	@Column(name="LOG_FECHA", nullable=false)
	private Timestamp logFecha;

	@Column(name="LOG_PLACA", nullable=false, length=6)
	private String logPlaca;

	@Column(name="LOG_USUARIO", nullable=false, length=30)
	private String logUsuario;

	public Tgf_Log() {
	}

	public long getIdLog() {
		return this.idLog;
	}

	public void setIdLog(long idLog) {
		this.idLog = idLog;
	}

	public String getLogConductor() {
		return this.logConductor;
	}

	public void setLogConductor(String logConductor) {
		this.logConductor = logConductor;
	}

	public Timestamp getLogFecha() {
		return this.logFecha;
	}

	public void setLogFecha(Timestamp logFecha) {
		this.logFecha = logFecha;
	}

	public String getLogPlaca() {
		return this.logPlaca;
	}

	public void setLogPlaca(String logPlaca) {
		this.logPlaca = logPlaca;
	}

	public String getLogUsuario() {
		return this.logUsuario;
	}

	public void setLogUsuario(String logUsuario) {
		this.logUsuario = logUsuario;
	}

}