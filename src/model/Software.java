package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_softwares")
@SequenceGenerator(name="tab_softwares_pk", sequenceName="seq_softwares_pk", allocationSize=1)
public class Software {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tab_softwares_pk")
	private Long id;
	
	private String serial;
	
	private String nome;
	
	private String versao;
	
	@ManyToOne
	@JoinColumn(name="id_colaborador_fk")
	private Colaborador colaborador;
	
	public Software() {
		super();
	}

	public Software(Long id, String serial, String nome, String versao, Colaborador colaborador) {
		super();
		this.id = id;
		this.serial = serial;
		this.nome = nome;
		this.versao = versao;
		this.colaborador = colaborador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Software other = (Software) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}