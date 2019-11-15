package flota.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TGF_PORCENTAJE_SOBRECUPO database table.
 * 
 */
@Entity
@Table(name="TGF_PORCENTAJE_SOBRECUPO")
@NamedQuery(name="Tgf_PorcentajeSobrecupo.findAll", query="SELECT t FROM Tgf_PorcentajeSobrecupo t")
public class Tgf_PorcentajeSobrecupo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PORC", unique=true, nullable=false, precision=10)
	private long idPorc;

	@Column(name="POR_PORCENTAJE", nullable=false)
	private Object porPorcentaje;

	public Tgf_PorcentajeSobrecupo() {
	}

	public long getIdPorc() {
		return this.idPorc;
	}

	public void setIdPorc(long idPorc) {
		this.idPorc = idPorc;
	}

	public Object getPorPorcentaje() {
		return this.porPorcentaje;
	}

	public void setPorPorcentaje(Object porPorcentaje) {
		this.porPorcentaje = porPorcentaje;
	}

}