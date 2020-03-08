package flota.view.tables;

import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author rvns
 * 
 */
public class UsuarioTableView {

	private SimpleStringProperty usuNickname;
	private SimpleStringProperty usuClave;
	private Date usuIngreso;
	private SimpleStringProperty nombreRol; 
	
	

	public UsuarioTableView() {
		this.usuNickname = new SimpleStringProperty();
		this.usuClave = new SimpleStringProperty();
		this.nombreRol = new SimpleStringProperty(); 	
	}

	public String getUsuNickname() {
		return usuNickname.get();
	}

	public void setUsuNickname(String usuNickname) {
		this.usuNickname.set(usuNickname);
	}

	public String getUsuClave() {
		return usuClave.get();
	}

	public String getNombreRol() {
		return nombreRol.get();
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol.set(nombreRol);
	}

	public void setUsuClave(String usuClave) {
		this.usuClave.set(usuClave);
	}

	public Date getUsuIngreso() {
		return usuIngreso;
	}

	public void setUsuIngreso(Date usuIngreso) {
		this.usuIngreso = usuIngreso;
	}

}
