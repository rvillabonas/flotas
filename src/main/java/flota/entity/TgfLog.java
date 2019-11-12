package flota.entity;


import java.io.Serializable;

/**
 * 
 * @author rvs
 *
 */
public class TgfLog implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idLog;
	private Serializable logFecha;
	private String logPlaca;
	private String logUsuario;
	private String logConductor;

	public TgfLog() {
	}

	public TgfLog(int idLog, Serializable logFecha, String logPlaca, String logUsuario) {
		this.idLog = idLog;
		this.logFecha = logFecha;
		this.logPlaca = logPlaca;
		this.logUsuario = logUsuario;
	}

	public TgfLog(int idLog, Serializable logFecha, String logPlaca, String logUsuario, String logConductor) {
		this.idLog = idLog;
		this.logFecha = logFecha;
		this.logPlaca = logPlaca;
		this.logUsuario = logUsuario;
		this.logConductor = logConductor;
	}

	public int getIdLog() {
		return this.idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public Serializable getLogFecha() {
		return this.logFecha;
	}

	public void setLogFecha(Serializable logFecha) {
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

	public String getLogConductor() {
		return this.logConductor;
	}

	public void setLogConductor(String logConductor) {
		this.logConductor = logConductor;
	}

}
