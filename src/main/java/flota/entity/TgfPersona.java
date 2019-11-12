package flota.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */
public class TgfPersona implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String perDni;
	private TgfRol tgfRol;
	private TgfUsuario tgfUsuario;
	private TgfTelefono tgfTelefono;
	private String perNombre1;
	private String perNombre2;
	private String perApellido1;
	private String perApellido2;
	private String perDireccion;
	private String perEstado;
	private String perEmail;
	private BigDecimal perNum1;
	private BigDecimal perNum2;
	private BigDecimal perNum3;
	private Date perDate1;
	private Date perDate2;
	private String perAlf1;
	private String perAlf2;
	private String perAlf3;
	private Set tgfFlotas = new HashSet(0);

	public TgfPersona() {
	}

	public TgfPersona(String perDni, TgfRol tgfRol, TgfUsuario tgfUsuario, TgfTelefono tgfTelefono, String perNombre1,
			String perApellido1, String perEstado) {
		this.perDni = perDni;
		this.tgfRol = tgfRol;
		this.tgfUsuario = tgfUsuario;
		this.tgfTelefono = tgfTelefono;
		this.perNombre1 = perNombre1;
		this.perApellido1 = perApellido1;
		this.perEstado = perEstado;
	}

	public TgfPersona(String perDni, TgfRol tgfRol, TgfUsuario tgfUsuario, TgfTelefono tgfTelefono, String perNombre1,
			String perNombre2, String perApellido1, String perApellido2, String perDireccion, String perEstado,
			String perEmail, BigDecimal perNum1, BigDecimal perNum2, BigDecimal perNum3, Date perDate1, Date perDate2,
			String perAlf1, String perAlf2, String perAlf3, Set tgfFlotas) {
		this.perDni = perDni;
		this.tgfRol = tgfRol;
		this.tgfUsuario = tgfUsuario;
		this.tgfTelefono = tgfTelefono;
		this.perNombre1 = perNombre1;
		this.perNombre2 = perNombre2;
		this.perApellido1 = perApellido1;
		this.perApellido2 = perApellido2;
		this.perDireccion = perDireccion;
		this.perEstado = perEstado;
		this.perEmail = perEmail;
		this.perNum1 = perNum1;
		this.perNum2 = perNum2;
		this.perNum3 = perNum3;
		this.perDate1 = perDate1;
		this.perDate2 = perDate2;
		this.perAlf1 = perAlf1;
		this.perAlf2 = perAlf2;
		this.perAlf3 = perAlf3;
		this.tgfFlotas = tgfFlotas;
	}

	public String getPerDni() {
		return this.perDni;
	}

	public void setPerDni(String perDni) {
		this.perDni = perDni;
	}

	public TgfRol getTgfRol() {
		return this.tgfRol;
	}

	public void setTgfRol(TgfRol tgfRol) {
		this.tgfRol = tgfRol;
	}

	public TgfUsuario getTgfUsuario() {
		return this.tgfUsuario;
	}

	public void setTgfUsuario(TgfUsuario tgfUsuario) {
		this.tgfUsuario = tgfUsuario;
	}

	public TgfTelefono getTgfTelefono() {
		return this.tgfTelefono;
	}

	public void setTgfTelefono(TgfTelefono tgfTelefono) {
		this.tgfTelefono = tgfTelefono;
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

	public String getPerDireccion() {
		return this.perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerEstado() {
		return this.perEstado;
	}

	public void setPerEstado(String perEstado) {
		this.perEstado = perEstado;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
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

	public Set getTgfFlotas() {
		return this.tgfFlotas;
	}

	public void setTgfFlotas(Set tgfFlotas) {
		this.tgfFlotas = tgfFlotas;
	}

}
