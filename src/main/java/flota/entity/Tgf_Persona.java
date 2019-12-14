package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TGF_PERSONA database table.
 * 
 */
@Entity
@Table(name="TGF_PERSONA")
@NamedQuery(name="Tgf_Persona.findAll", query="SELECT t FROM Tgf_Persona t")
public class Tgf_Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PER_DNI", unique=true, nullable=false, length=60)
	private String perDni;

	@Column(name="PER_ALF1", length=60)
	private String perAlf1;

	@Column(name="PER_ALF2", length=60)
	private String perAlf2;

	@Column(name="PER_ALF3", length=60)
	private String perAlf3;

	@Column(name="PER_APELLIDO1", nullable=false, length=30)
	private String perApellido1;

	@Column(name="PER_APELLIDO2", length=30)
	private String perApellido2;

	@Temporal(TemporalType.DATE)
	@Column(name="PER_DATE1")
	private Date perDate1;

	@Temporal(TemporalType.DATE)
	@Column(name="PER_DATE2")
	private Date perDate2;

	@Column(name="PER_DIRECCION", length=60)
	private String perDireccion;

	@Column(name="PER_EMAIL", length=320)
	private String perEmail;

	@Column(name="PER_ESTADO", nullable=false, length=3)
	private String perEstado;

	@Column(name="PER_NOMBRE1", nullable=false, length=30)
	private String perNombre1;

	@Column(name="PER_NOMBRE2", length=30)
	private String perNombre2;

	@Column(name="PER_NUM1", precision=6, scale=4)
	private BigDecimal perNum1;

	@Column(name="PER_NUM2", precision=6, scale=4)
	private BigDecimal perNum2;

	@Column(name="PER_NUM3", precision=6, scale=4)
	private BigDecimal perNum3;

	//bi-directional many-to-one association to Tgf_Flota
	@OneToMany(mappedBy="tgfPersona")
	private List<Tgf_Flota> tgfFlotas;

	//bi-directional many-to-one association to Tgf_Rol
	@ManyToOne
	@JoinColumn(name="ID_ROL", nullable=false)
	private Tgf_Rol tgfRol;

	//bi-directional many-to-one association to Tgf_Telefono
	@ManyToOne
	@JoinColumn(name="TEL_NUMERO", nullable=false)
	private Tgf_Telefono tgfTelefono;

	//bi-directional many-to-one association to Tgf_Usuario
	@ManyToOne
	@JoinColumn(name="USU_NICKNAME", nullable=false)
	private Usuario tgfUsuario;

	public Tgf_Persona() {
	}

	public String getPerDni() {
		return this.perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public String getPerAlf1() {
		return this.perAlf1;
	}

	public void setPerAlf1(String perAlf1) {
		this.perAlf1 = perAlf1;
	}

	public String getPerAlf2() {
		return this.perAlf2;
	}

	public void setPerAlf2(String perAlf2) {
		this.perAlf2 = perAlf2;
	}

	public String getPerAlf3() {
		return this.perAlf3;
	}

	public void setPerAlf3(String perAlf3) {
		this.perAlf3 = perAlf3;
	}

	public String getPerApellido1() {
		return this.perApellido1;
	}

	public void setPerApellido1(String perApellido1) {
		this.perApellido1 = perApellido1;
	}

	public String getPerApellido2() {
		return this.perApellido2;
	}

	public void setPerApellido2(String perApellido2) {
		this.perApellido2 = perApellido2;
	}

	public Date getPerDate1() {
		return this.perDate1;
	}

	public void setPerDate1(Date perDate1) {
		this.perDate1 = perDate1;
	}

	public Date getPerDate2() {
		return this.perDate2;
	}

	public void setPerDate2(Date perDate2) {
		this.perDate2 = perDate2;
	}

	public String getPerDireccion() {
		return this.perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public String getPerEstado() {
		return this.perEstado;
	}

	public void setPerEstado(String perEstado) {
		this.perEstado = perEstado;
	}

	public String getPerNombre1() {
		return this.perNombre1;
	}

	public void setPerNombre1(String perNombre1) {
		this.perNombre1 = perNombre1;
	}

	public String getPerNombre2() {
		return this.perNombre2;
	}

	public void setPerNombre2(String perNombre2) {
		this.perNombre2 = perNombre2;
	}

	public BigDecimal getPerNum1() {
		return this.perNum1;
	}

	public void setPerNum1(BigDecimal perNum1) {
		this.perNum1 = perNum1;
	}

	public BigDecimal getPerNum2() {
		return this.perNum2;
	}

	public void setPerNum2(BigDecimal perNum2) {
		this.perNum2 = perNum2;
	}

	public BigDecimal getPerNum3() {
		return this.perNum3;
	}

	public void setPerNum3(BigDecimal perNum3) {
		this.perNum3 = perNum3;
	}

	public List<Tgf_Flota> getTgfFlotas() {
		return this.tgfFlotas;
	}

	public void setTgfFlotas(List<Tgf_Flota> tgfFlotas) {
		this.tgfFlotas = tgfFlotas;
	}

	public Tgf_Flota addTgfFlota(Tgf_Flota tgfFlota) {
		getTgfFlotas().add(tgfFlota);
		tgfFlota.setTgfPersona(this);

		return tgfFlota;
	}

	public Tgf_Flota removeTgfFlota(Tgf_Flota tgfFlota) {
		getTgfFlotas().remove(tgfFlota);
		tgfFlota.setTgfPersona(null);

		return tgfFlota;
	}

	public Tgf_Rol getTgfRol() {
		return this.tgfRol;
	}

	public void setTgfRol(Tgf_Rol tgfRol) {
		this.tgfRol = tgfRol;
	}

	public Tgf_Telefono getTgfTelefono() {
		return this.tgfTelefono;
	}

	public void setTgfTelefono(Tgf_Telefono tgfTelefono) {
		this.tgfTelefono = tgfTelefono;
	}

	public Usuario getTgfUsuario() {
		return this.tgfUsuario;
	}

	public void setTgfUsuario(Usuario tgfUsuario) {
		this.tgfUsuario = tgfUsuario;
	}

}