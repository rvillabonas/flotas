package flota.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author rvs
 *
 */
public class TgfVehiculo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vehPlaca;
	private TgfTarifa tgfTarifa;
	private TgfFranjaHoraria tgfFranjaHoraria;
	private TgfConductor tgfConductor;
	private TgfFlota tgfFlota;
	private String vehPin;
	private String vehMarca;
	private int vehAnioModelo;
	private Date vehFechaVigSoat;
	private Date vehFechaVigRtm;
	private long vehCantLavadas;
	private BigDecimal vehTope;

	public TgfVehiculo() {
	}

	public TgfVehiculo(String vehPlaca, TgfTarifa tgfTarifa, TgfFranjaHoraria tgfFranjaHoraria,
			TgfConductor tgfConductor, int vehAnioModelo, long vehCantLavadas, BigDecimal vehTope) {
		this.vehPlaca = vehPlaca;
		this.tgfTarifa = tgfTarifa;
		this.tgfFranjaHoraria = tgfFranjaHoraria;
		this.tgfConductor = tgfConductor;
		this.vehAnioModelo = vehAnioModelo;
		this.vehCantLavadas = vehCantLavadas;
		this.vehTope = vehTope;
	}

	public TgfVehiculo(String vehPlaca, TgfTarifa tgfTarifa, TgfFranjaHoraria tgfFranjaHoraria,
			TgfConductor tgfConductor, TgfFlota tgfFlota, String vehPin, String vehMarca, int vehAnioModelo,
			Date vehFechaVigSoat, Date vehFechaVigRtm, long vehCantLavadas, BigDecimal vehTope) {
		this.vehPlaca = vehPlaca;
		this.tgfTarifa = tgfTarifa;
		this.tgfFranjaHoraria = tgfFranjaHoraria;
		this.tgfConductor = tgfConductor;
		this.tgfFlota = tgfFlota;
		this.vehPin = vehPin;
		this.vehMarca = vehMarca;
		this.vehAnioModelo = vehAnioModelo;
		this.vehFechaVigSoat = vehFechaVigSoat;
		this.vehFechaVigRtm = vehFechaVigRtm;
		this.vehCantLavadas = vehCantLavadas;
		this.vehTope = vehTope;
	}

	public String getVehPlaca() {
		return this.vehPlaca;
	}

	public void setVehPlaca(String vehPlaca) {
		this.vehPlaca = vehPlaca;
	}

	public TgfTarifa getTgfTarifa() {
		return this.tgfTarifa;
	}

	public void setTgfTarifa(TgfTarifa tgfTarifa) {
		this.tgfTarifa = tgfTarifa;
	}

	public TgfFranjaHoraria getTgfFranjaHoraria() {
		return this.tgfFranjaHoraria;
	}

	public void setTgfFranjaHoraria(TgfFranjaHoraria tgfFranjaHoraria) {
		this.tgfFranjaHoraria = tgfFranjaHoraria;
	}

	public TgfConductor getTgfConductor() {
		return this.tgfConductor;
	}

	public void setTgfConductor(TgfConductor tgfConductor) {
		this.tgfConductor = tgfConductor;
	}

	public TgfFlota getTgfFlota() {
		return this.tgfFlota;
	}

	public void setTgfFlota(TgfFlota tgfFlota) {
		this.tgfFlota = tgfFlota;
	}

	public String getVehPin() {
		return this.vehPin;
	}

	public void setVehPin(String vehPin) {
		this.vehPin = vehPin;
	}

	public String getVehMarca() {
		return this.vehMarca;
	}

	public void setVehMarca(String vehMarca) {
		this.vehMarca = vehMarca;
	}

	public int getVehAnioModelo() {
		return this.vehAnioModelo;
	}

	public void setVehAnioModelo(int vehAnioModelo) {
		this.vehAnioModelo = vehAnioModelo;
	}

	public Date getVehFechaVigSoat() {
		return this.vehFechaVigSoat;
	}

	public void setVehFechaVigSoat(Date vehFechaVigSoat) {
		this.vehFechaVigSoat = vehFechaVigSoat;
	}

	public Date getVehFechaVigRtm() {
		return this.vehFechaVigRtm;
	}

	public void setVehFechaVigRtm(Date vehFechaVigRtm) {
		this.vehFechaVigRtm = vehFechaVigRtm;
	}

	public long getVehCantLavadas() {
		return this.vehCantLavadas;
	}

	public void setVehCantLavadas(long vehCantLavadas) {
		this.vehCantLavadas = vehCantLavadas;
	}

	public BigDecimal getVehTope() {
		return this.vehTope;
	}

	public void setVehTope(BigDecimal vehTope) {
		this.vehTope = vehTope;
	}

}
