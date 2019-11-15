package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TGF_FRANJA_HORARIA database table.
 * 
 */
@Entity
@Table(name="TGF_FRANJA_HORARIA")
@NamedQuery(name="Tgf_FranjaHoraria.findAll", query="SELECT t FROM Tgf_FranjaHoraria t")
public class Tgf_FranjaHoraria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FRANJA_HORARIA", unique=true, nullable=false, precision=9)
	private long idFranjaHoraria;

	@Column(name="FHO_DESCRIPCION", length=60)
	private String fhoDescripcion;

	@Column(name="FHO_DIA_SEM", nullable=false, precision=1)
	private BigDecimal fhoDiaSem;

	@Column(name="FHO_ESTADO", nullable=false, length=3)
	private String fhoEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="FHO_FECHA_REGISTRO")
	private Date fhoFechaRegistro;

	@Column(name="FHO_HORA_FINAL", nullable=false, length=5)
	private String fhoHoraFinal;

	@Column(name="FHO_HORA_INICIAL", nullable=false, length=5)
	private String fhoHoraInicial;

	@Column(name="FHO_NOMBRE", nullable=false, length=30)
	private String fhoNombre;

	//bi-directional many-to-one association to Tgf_Vehiculo
	@OneToMany(mappedBy="tgfFranjaHoraria")
	private List<Tgf_Vehiculo> tgfVehiculos;

	public Tgf_FranjaHoraria() {
	}

	public long getIdFranjaHoraria() {
		return this.idFranjaHoraria;
	}

	public void setIdFranjaHoraria(long idFranjaHoraria) {
		this.idFranjaHoraria = idFranjaHoraria;
	}

	public String getFhoDescripcion() {
		return this.fhoDescripcion;
	}

	public void setFhoDescripcion(String fhoDescripcion) {
		this.fhoDescripcion = fhoDescripcion;
	}

	public BigDecimal getFhoDiaSem() {
		return this.fhoDiaSem;
	}

	public void setFhoDiaSem(BigDecimal fhoDiaSem) {
		this.fhoDiaSem = fhoDiaSem;
	}

	public String getFhoEstado() {
		return this.fhoEstado;
	}

	public void setFhoEstado(String fhoEstado) {
		this.fhoEstado = fhoEstado;
	}

	public Date getFhoFechaRegistro() {
		return this.fhoFechaRegistro;
	}

	public void setFhoFechaRegistro(Date fhoFechaRegistro) {
		this.fhoFechaRegistro = fhoFechaRegistro;
	}

	public String getFhoHoraFinal() {
		return this.fhoHoraFinal;
	}

	public void setFhoHoraFinal(String fhoHoraFinal) {
		this.fhoHoraFinal = fhoHoraFinal;
	}

	public String getFhoHoraInicial() {
		return this.fhoHoraInicial;
	}

	public void setFhoHoraInicial(String fhoHoraInicial) {
		this.fhoHoraInicial = fhoHoraInicial;
	}

	public String getFhoNombre() {
		return this.fhoNombre;
	}

	public void setFhoNombre(String fhoNombre) {
		this.fhoNombre = fhoNombre;
	}

	public List<Tgf_Vehiculo> getTgfVehiculos() {
		return this.tgfVehiculos;
	}

	public void setTgfVehiculos(List<Tgf_Vehiculo> tgfVehiculos) {
		this.tgfVehiculos = tgfVehiculos;
	}

	public Tgf_Vehiculo addTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().add(tgfVehiculo);
		tgfVehiculo.setTgfFranjaHoraria(this);

		return tgfVehiculo;
	}

	public Tgf_Vehiculo removeTgfVehiculo(Tgf_Vehiculo tgfVehiculo) {
		getTgfVehiculos().remove(tgfVehiculo);
		tgfVehiculo.setTgfFranjaHoraria(null);

		return tgfVehiculo;
	}

}