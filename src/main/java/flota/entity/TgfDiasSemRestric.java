package flota.entity;

/**
 * 
 * @author rvs
 *
 */
public class TgfDiasSemRestric implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean dia;
	private String diaNombre;

	public TgfDiasSemRestric() {
	}

	public TgfDiasSemRestric(boolean dia, String diaNombre) {
		this.dia = dia;
		this.diaNombre = diaNombre;
	}

	public boolean isDia() {
		return this.dia;
	}

	public void setDia(boolean dia) {
		this.dia = dia;
	}

	public String getDiaNombre() {
		return this.diaNombre;
	}

	public void setDiaNombre(String diaNombre) {
		this.diaNombre = diaNombre;
	}

}
