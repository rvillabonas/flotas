package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TGF_VENTA database table.
 * 
 */
@Entity
@Table(name="TGF_VENTA")
@NamedQuery(name="Tgf_Venta.findAll", query="SELECT t FROM Tgf_Venta t")
public class Tgf_Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_VENTA", unique=true, nullable=false, precision=9)
	private long idVenta;

	@Column(name="VEN_CONCEPTO", nullable=false, length=30)
	private String venConcepto;

	@Temporal(TemporalType.DATE)
	@Column(name="VEN_FECHA", nullable=false)
	private Date venFecha;

	@Column(name="VEN_OBSERVACIONES", length=200)
	private String venObservaciones;

	@Column(name="VEN_PLACA", nullable=false, length=6)
	private String venPlaca;

	@Column(name="VEN_PRECIO", nullable=false, precision=6, scale=3)
	private BigDecimal venPrecio;

	@Column(name="VEN_USUARIO", nullable=false, length=30)
	private String venUsuario;

	public Tgf_Venta() {
	}

	public long getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public String getVenConcepto() {
		return this.venConcepto;
	}

	public void setVenConcepto(String venConcepto) {
		this.venConcepto = venConcepto;
	}

	public Date getVenFecha() {
		return this.venFecha;
	}

	public void setVenFecha(Date venFecha) {
		this.venFecha = venFecha;
	}

	public String getVenObservaciones() {
		return this.venObservaciones;
	}

	public void setVenObservaciones(String venObservaciones) {
		this.venObservaciones = venObservaciones;
	}

	public String getVenPlaca() {
		return this.venPlaca;
	}

	public void setVenPlaca(String venPlaca) {
		this.venPlaca = venPlaca;
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

}