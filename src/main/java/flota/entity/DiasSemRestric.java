package flota.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TGF_DIAS_SEM_RESTRIC database table.
 * 
 */
@Entity
@Table(name="TGF_DIAS_SEM_RESTRIC")
@NamedQuery(name="DiasSemRestric.findAll", query="SELECT d FROM DiasSemRestric d")
public class DiasSemRestric implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long dia;

	@Column(name="DIA_NOMBRE")
	private String nombre;

	public DiasSemRestric() {
	}

	public long getDia() {
		return this.dia;
	}

	public void setDia(long dia) {
		this.dia = dia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}