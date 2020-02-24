package flota.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TGF_PORCENTAJE_SOBRECUPO database table.
 * 
 */
@Entity
@Table(name="TGF_PORCENTAJE_SOBRECUPO")
@NamedQuery(name="PorcentajeSobrecupo.findAll", query="SELECT p FROM PorcentajeSobrecupo p")
public class PorcentajeSobrecupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PORC")
	private Integer idPorc;

	@Column(name="POR_PORCENTAJE")
	private long porcentaje;

	public PorcentajeSobrecupo() {
	}

	public Integer getIdPorc() {
		return this.idPorc;
	}

	public void setIdPorc(Integer idPorc) {
		this.idPorc = idPorc;
	}

	public long getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(long porcentaje) {
		this.porcentaje = porcentaje;
	}

}