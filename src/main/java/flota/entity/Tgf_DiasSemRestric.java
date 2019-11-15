package flota.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TGF_DIAS_SEM_RESTRIC database table.
 * 
 */
@Entity
@Table(name="TGF_DIAS_SEM_RESTRIC")
@NamedQuery(name="Tgf_DiasSemRestric.findAll", query="SELECT t FROM Tgf_DiasSemRestric t")
public class Tgf_DiasSemRestric implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, precision=1)
	private long dia;

	@Column(name="DIA_NOMBRE", nullable=false, length=16)
	private String diaNombre;

	public Tgf_DiasSemRestric() {
	}

	public long getDia() {
		return this.dia;
	}

	public void setDia(long dia) {
		this.dia = dia;
	}

	public String getDiaNombre() {
		return this.diaNombre;
	}

	public void setDiaNombre(String diaNombre) {
		this.diaNombre = diaNombre;
	}

}