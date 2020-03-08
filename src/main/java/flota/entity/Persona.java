package flota.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author rvns
 * The persistent class for the TGF_PERSONA database table.
 * 
 */
@Entity
@Table(name="TGF_PERSONA")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PER_DNI")
	private String perDni;

	@Column(name="PER_ALF1")
	private String alf1;

	@Column(name="PER_ALF2")
	private String alf2;

	@Column(name="PER_ALF3")
	private String alf3;

	@Column(name="PER_APELLIDO1")
	private String apellido1;

	@Column(name="PER_APELLIDO2")
	private String apellido2;

	@Temporal(TemporalType.DATE)
	@Column(name="PER_DATE1")
	private Date date1;

	@Temporal(TemporalType.DATE)
	@Column(name="PER_DATE2")
	private Date date2;

	@Column(name="PER_DIRECCION")
	private String direccion;

	@Column(name="PER_EMAIL")
	private String email;

	@Column(name="PER_NOMBRE1")
	private String nombre1;

	@Column(name="PER_NOMBRE2")
	private String nombre2;

	@Column(name="PER_NUM1")
	private BigDecimal num1;

	@Column(name="PER_NUM2")
	private  BigDecimal num2;

	@Column(name="PER_NUM3")
	private BigDecimal num3;

	//bi-directional many-to-one association to Flota
	@OneToMany(mappedBy="tgfPersona")
	private List<Flota> tgfFlotas;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TEL_NUMERO2")
	private Telefono tgfTelefono1;

	//bi-directional many-to-one association to Telefono
	@ManyToOne
	@JoinColumn(name="TEL_NUMERO1")
	private Telefono tgfTelefono2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="USU_NICKNAME")
	private Usuario tgfUsuario;

	public Persona() {
	}

	public String getPerDni() {
		return this.perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public String getAlf1() {
		return this.alf1;
	}

	public void setAlf1(String alf1) {
		this.alf1 = alf1;
	}

	public String getAlf2() {
		return this.alf2;
	}

	public void setAlf2(String alf2) {
		this.alf2 = alf2;
	}

	public String getAlf3() {
		return this.alf3;
	}

	public void setAlf3(String alf3) {
		this.alf3 = alf3;
	}

	public String getApellido1() {
		return this.apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public Date getDate1() {
		return this.date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return this.date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre1() {
		return this.nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public BigDecimal getNum1() {
		return this.num1;
	}

	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}

	public BigDecimal getNum2() {
		return this.num2;
	}

	public void setNum2(BigDecimal num2) {
		this.num2 = num2;
	}

	public BigDecimal getNum3() {
		return this.num3;
	}

	public void setNum3(BigDecimal num3) {
		this.num3 = num3;
	}

	public List<Flota> getTgfFlotas() {
		return this.tgfFlotas;
	}

	public void setTgfFlotas(List<Flota> tgfFlotas) {
		this.tgfFlotas = tgfFlotas;
	}

	public Flota addTgfFlota(Flota tgfFlota) {
		getTgfFlotas().add(tgfFlota);
		tgfFlota.setTgfPersona(this);

		return tgfFlota;
	}

	public Flota removeTgfFlota(Flota tgfFlota) {
		getTgfFlotas().remove(tgfFlota);
		tgfFlota.setTgfPersona(null);

		return tgfFlota;
	}

	public Telefono getTgfTelefono1() {
		return this.tgfTelefono1;
	}

	public void setTgfTelefono1(Telefono tgfTelefono1) {
		this.tgfTelefono1 = tgfTelefono1;
	}

	public Telefono getTgfTelefono2() {
		return this.tgfTelefono2;
	}

	public void setTgfTelefono2(Telefono tgfTelefono2) {
		this.tgfTelefono2 = tgfTelefono2;
	}

	public Usuario getTgfUsuario() {
		return this.tgfUsuario;
	}

	public void setTgfUsuario(Usuario tgfUsuario) {
		this.tgfUsuario = tgfUsuario;
	}

}