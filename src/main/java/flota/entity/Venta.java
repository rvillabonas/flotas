package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/*
 * @author rvns
 * The persistent class for the TGF_VENTA database table.
 * 
 */
@Entity
@Table(name="TGF_VENTA")
@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_VENTA")
	private long idVenta;

	@Column(name="VEN_CONCEPTO")
	private String concepto;

	@Temporal(TemporalType.DATE)
	@Column(name="VEN_FECHA")
	private Date fecha;

	@Column(name="VEN_OBSERVACIONES")
	private String observaciones;

	@Column(name="VEN_PLACA")
	private String placa;

	@Column(name="VEN_PRECIO")
	private BigDecimal precio;

	@Column(name="VEN_USUARIO")
	private String usuario;

	public Venta() {
	}

	public long getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
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

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}