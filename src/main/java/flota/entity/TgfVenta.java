package flota.entity;

import java.math.BigDecimal;
import java.util.Date;


public class TgfVenta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idVenta;
	private Date venFecha;
	private String venPlaca;
	private String venConcepto;
	private BigDecimal venPrecio;
	private String venUsuario;
	private String venObservaciones;

	public TgfVenta() {
	}

	public TgfVenta(int idVenta, Date venFecha, String venPlaca, String venConcepto, BigDecimal venPrecio,
			String venUsuario) {
		this.idVenta = idVenta;
		this.venFecha = venFecha;
		this.venPlaca = venPlaca;
		this.venConcepto = venConcepto;
		this.venPrecio = venPrecio;
		this.venUsuario = venUsuario;
	}

	public TgfVenta(int idVenta, Date venFecha, String venPlaca, String venConcepto, BigDecimal venPrecio,
			String venUsuario, String venObservaciones) {
		this.idVenta = idVenta;
		this.venFecha = venFecha;
		this.venPlaca = venPlaca;
		this.venConcepto = venConcepto;
		this.venPrecio = venPrecio;
		this.venUsuario = venUsuario;
		this.venObservaciones = venObservaciones;
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Date getVenFecha() {
		return this.venFecha;
	}

	public void setVenFecha(Date venFecha) {
		this.venFecha = venFecha;
	}

	public String getVenPlaca() {
		return this.venPlaca;
	}

	public void setVenPlaca(String venPlaca) {
		this.venPlaca = venPlaca;
	}

	public String getVenConcepto() {
		return this.venConcepto;
	}

	public void setVenConcepto(String venConcepto) {
		this.venConcepto = venConcepto;
	}

	public BigDecimal getVenPrecio() {
		return this.venPrecio;
	}

	public void setVenPrecio(BigDecimal venPrecio) {
		this.venPrecio = venPrecio;
	}

	public String getVenUsuario() {
		return this.venUsuario;
	}

	public void setVenUsuario(String venUsuario) {
		this.venUsuario = venUsuario;
	}

	public String getVenObservaciones() {
		return this.venObservaciones;
	}

	public void setVenObservaciones(String venObservaciones) {
		this.venObservaciones = venObservaciones;
	}

}
