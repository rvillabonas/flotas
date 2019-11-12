package flota.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author rvs
 *
 */
public class TgfUsuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuNickname;
	private String usuPassword;
	private Date usuFechaUltIngreso;
	private Set tgfPersonas = new HashSet(0);

	public TgfUsuario() {
	}

	public TgfUsuario(String usuNickname, String usuPassword) {
		this.usuNickname = usuNickname;
		this.usuPassword = usuPassword;
	}

	public TgfUsuario(String usuNickname, String usuPassword, Date usuFechaUltIngreso, Set tgfPersonas) {
		this.usuNickname = usuNickname;
		this.usuPassword = usuPassword;
		this.usuFechaUltIngreso = usuFechaUltIngreso;
		this.tgfPersonas = tgfPersonas;
	}

	public String getUsuNickname() {
		return this.usuNickname;
	}

	public void setUsuNickname(String usuNickname) {
		this.usuNickname = usuNickname;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public Date getUsuFechaUltIngreso() {
		return this.usuFechaUltIngreso;
	}

	public void setUsuFechaUltIngreso(Date usuFechaUltIngreso) {
		this.usuFechaUltIngreso = usuFechaUltIngreso;
	}

	public Set getTgfPersonas() {
		return this.tgfPersonas;
	}

	public void setTgfPersonas(Set tgfPersonas) {
		this.tgfPersonas = tgfPersonas;
	}

}
