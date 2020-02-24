package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TGF_VEHICULO database table.
 * 
 */
@Entity
@Table(name="TGF_VEHICULO")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="VEH_PLACA")
	private String placa;

	@Column(name="ID_CLIENTE")
	private String idCliente;

	@Column(name="VEH_ANIO_MODELO")
	private BigDecimal anioModelo;

	@Column(name="VEH_CANT_LAVADAS")
	private Integer cantLavadas;

	@Temporal(TemporalType.DATE)
	@Column(name="VEH_FECHA_VIG_RTM")
	private Date fechaVigRtm;

	@Temporal(TemporalType.DATE)
	@Column(name="VEH_FECHA_VIG_SOAT")
	private Date fechaVigSoat;

	@Column(name="VEH_MARCA")
	private String marca;

	@Column(name="VEH_PIN")
	private String pin;

	@Column(name="VEH_TOPE")
	private long tope;

	//bi-directional many-to-one association to Conductor
	@ManyToOne
	@JoinColumn(name="ID_CONDUCTOR")
	private Conductor tgfConductor;

	//bi-directional many-to-one association to Flota
	@ManyToOne
	@JoinColumn(name="ID_FLOTA")
	private Flota tgfFlota;

	//bi-directional many-to-one association to FranjaHoraria
	@ManyToOne
	@JoinColumn(name="ID_FRANJA_HORARIA")
	private FranjaHoraria tgfFranjaHoraria;

	//bi-directional many-to-one association to Tarifa
	@ManyToOne
	@JoinColumn(name="ID_TARIFA")
	private Tarifa tgfTarifa;

	public Vehiculo() {
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public BigDecimal getAnioModelo() {
		return this.anioModelo;
	}

	public void setAnioModelo(BigDecimal anioModelo) {
		this.anioModelo = anioModelo;
	}

	public Integer getCantLavadas() {
		return this.cantLavadas;
	}

	public void setCantLavadas(Integer cantLavadas) {
		this.cantLavadas = cantLavadas;
	}

	public Date getFechaVigRtm() {
		return this.fechaVigRtm;
	}

	public void setFechaVigRtm(Date fechaVigRtm) {
		this.fechaVigRtm = fechaVigRtm;
	}

	public Date getFechaVigSoat() {
		return this.fechaVigSoat;
	}

	public void setFechaVigSoat(Date fechaVigSoat) {
		this.fechaVigSoat = fechaVigSoat;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public long getTope() {
		return this.tope;
	}

	public void setTope(long tope) {
		this.tope = tope;
	}

	public Conductor getTgfConductor() {
		return this.tgfConductor;
	}

	public void setTgfConductor(Conductor tgfConductor) {
		this.tgfConductor = tgfConductor;
	}

	public Flota getTgfFlota() {
		return this.tgfFlota;
	}

	public void setTgfFlota(Flota tgfFlota) {
		this.tgfFlota = tgfFlota;
	}

	public FranjaHoraria getTgfFranjaHoraria() {
		return this.tgfFranjaHoraria;
	}

	public void setTgfFranjaHoraria(FranjaHoraria tgfFranjaHoraria) {
		this.tgfFranjaHoraria = tgfFranjaHoraria;
	}

	public Tarifa getTgfTarifa() {
		return this.tgfTarifa;
	}

	public void setTgfTarifa(Tarifa tgfTarifa) {
		this.tgfTarifa = tgfTarifa;
	}

}