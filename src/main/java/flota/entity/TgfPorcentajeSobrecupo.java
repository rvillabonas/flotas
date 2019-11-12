package flota.entity;

import java.io.Serializable;

/**
 * 
 * @author rvS
 *
 */
public class TgfPorcentajeSobrecupo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idPorc;
	private Serializable porPorcentaje;

	public TgfPorcentajeSobrecupo() {
	}

	public TgfPorcentajeSobrecupo(long idPorc, Serializable porPorcentaje) {
		this.idPorc = idPorc;
		this.porPorcentaje = porPorcentaje;
	}

	public long getIdPorc() {
		return this.idPorc;
	}

	public void setIdPorc(long idPorc) {
		this.idPorc = idPorc;
	}

	public Serializable getPorPorcentaje() {
		return this.porPorcentaje;
	}

	public void setPorPorcentaje(Serializable porPorcentaje) {
		this.porPorcentaje = porPorcentaje;
	}

}
