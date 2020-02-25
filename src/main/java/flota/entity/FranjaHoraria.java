package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author rvns
 * The persistent class for the TGF_FRANJA_HORARIA database table.
 * 
 */
@Entity
@Table(name="TGF_FRANJA_HORARIA")
@NamedQuery(name="FranjaHoraria.findAll", query="SELECT f FROM FranjaHoraria f")
public class FranjaHoraria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FRANJA_HORARIA")
	private long idFranjaHoraria;

	@Column(name="FHO_DESCRIPCION")
	private String descripcion;

	@Column(name="FHO_DIA_SEM")
	private BigDecimal diaSem;

	@Column(name="FHO_ESTADO")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FHO_FECHA_REGISTRO")
	private Date fechaRegistro;

	@Column(name="FHO_HORA_FINAL")
	private String horaFinal;

	@Column(name="FHO_HORA_INICIAL")
	private String horaInicial;

	@Column(name="FHO_NOMBRE")
	private String nombre;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="tgfFranjaHoraria")
	private List<Vehiculo> tgfVehiculos;

	public FranjaHoraria() {
	}

	public long getIdFranjaHoraria() {
		return this.idFranjaHoraria;
	}

	public void setIdFranjaHoraria(long idFranjaHoraria) {
		this.idFranjaHoraria = idFranjaHoraria;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getDiaSem() {
		return this.diaSem;
	}

	public void setDiaSem(BigDecimal diaSem) {
		this.diaSem = diaSem;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraFinal() {
		return this.horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getHoraInicial() {
		return this.horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Vehiculo addTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfFranjaHoraria(this);

		return tgfVehiculo;
	}

	public Vehiculo removeTgfVehiculo(Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfFranjaHoraria(null);

		return tgfVehiculo;
	}

}