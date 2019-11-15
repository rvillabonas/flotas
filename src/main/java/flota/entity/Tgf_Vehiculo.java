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
@NamedQuery(name="Tgf_Vehiculo.findAll", query="SELECT t FROM Tgf_Vehiculo t")
public class Tgf_Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEH_PLACA", unique=true, nullable=false, length=6)
	private String vehPlaca;

	@Column(name="VEH_ANIO_MODELO", nullable=false, precision=6)
	private BigDecimal vehAnioModelo;

	@Column(name="VEH_CANT_LAVADAS", nullable=false, precision=10)
	private BigDecimal vehCantLavadas;

	@Temporal(TemporalType.DATE)
	@Column(name="VEH_FECHA_VIG_RTM")
	private Date vehFechaVigRtm;

	@Temporal(TemporalType.DATE)
	@Column(name="VEH_FECHA_VIG_SOAT")
	private Date vehFechaVigSoat;

	@Column(name="VEH_MARCA", length=30)
	private String vehMarca;

	@Column(name="VEH_PIN", length=30)
	private String vehPin;

	@Column(name="VEH_TOPE", nullable=false, precision=6, scale=3)
	private BigDecimal vehTope;

	//bi-directional many-to-one association to Tgf_Conductor
	@ManyToOne
	@JoinColumn(name="ID_CONDUCTOR", nullable=false)
	private Tgf_Conductor tgfConductor;

	//bi-directional many-to-one association to Tgf_Flota
	@ManyToOne
	@JoinColumn(name="ID_FLOTA")
	private Tgf_Flota tgfFlota;

	//bi-directional many-to-one association to Tgf_FranjaHoraria
	@ManyToOne
	@JoinColumn(name="ID_FRANJA_HORARIA", nullable=false)
	private Tgf_FranjaHoraria tgfFranjaHoraria;

	//bi-directional many-to-one association to Tgf_Tarifa
	@ManyToOne
	@JoinColumn(name="ID_TARIFA", nullable=false)
	private Tgf_Tarifa tgfTarifa;

	public Tgf_Vehiculo() {
	}

	public String getVehPlaca() {
		return this.vehPlaca;
	}

	public void setVehPlaca(String vehPlaca) {
		this.vehPlaca = vehPlaca;
	}

	public BigDecimal getVehAnioModelo() {
		return this.vehAnioModelo;
	}

	public void setVehAnioModelo(BigDecimal vehAnioModelo) {
		this.vehAnioModelo = vehAnioModelo;
	}

	public BigDecimal getVehCantLavadas() {
		return this.vehCantLavadas;
	}

	public void setVehCantLavadas(BigDecimal vehCantLavadas) {
		this.vehCantLavadas = vehCantLavadas;
	}

	public Date getVehFechaVigRtm() {
		return this.vehFechaVigRtm;
	}

	public void setVehFechaVigRtm(Date vehFechaVigRtm) {
		this.vehFechaVigRtm = vehFechaVigRtm;
	}

	public Date getVehFechaVigSoat() {
		return this.vehFechaVigSoat;
	}

	public void setVehFechaVigSoat(Date vehFechaVigSoat) {
		this.vehFechaVigSoat = vehFechaVigSoat;
	}

	public String getVehMarca() {
		return this.vehMarca;
	}

	public void setVehMarca(String vehMarca) {
		this.vehMarca = vehMarca;
	}

	public String getVehPin() {
		return this.vehPin;
	}

	public void setVehPin(String vehPin) {
		this.vehPin = vehPin;
	}

	public BigDecimal getVehTope() {
		return this.vehTope;
	}

	public void setVehTope(BigDecimal vehTope) {
		this.vehTope = vehTope;
	}

	public Tgf_Conductor getTgfConductor() {
		return this.tgfConductor;
	}

	public void setTgfConductor(Tgf_Conductor tgfConductor) {
		this.tgfConductor = tgfConductor;
	}

	public Tgf_Flota getTgfFlota() {
		return this.tgfFlota;
	}

	public void setTgfFlota(Tgf_Flota tgfFlota) {
		this.tgfFlota = tgfFlota;
	}

	public Tgf_FranjaHoraria getTgfFranjaHoraria() {
		return this.tgfFranjaHoraria;
	}

	public void setTgfFranjaHoraria(Tgf_FranjaHoraria tgfFranjaHoraria) {
		this.tgfFranjaHoraria = tgfFranjaHoraria;
	}

	public Tgf_Tarifa getTgfTarifa() {
		return this.tgfTarifa;
	}

	public void setTgfTarifa(Tgf_Tarifa tgfTarifa) {
		this.tgfTarifa = tgfTarifa;
	}

}