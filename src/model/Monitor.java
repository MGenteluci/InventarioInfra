package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_monitores")
@SequenceGenerator(name="tab_monitores_pk", sequenceName="seq_monitores_pk", allocationSize=1)
public class Monitor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tab_monitores_pk")
	private Long id;
	
	private String marca;
	
	private String modelo;
	
	@Column(name="data_compra")
	private String dataCompra;
	
	private String situacao;

	@Column(name="data_emprestimo")
	private String dataEmprestimo;
	
	@Column(name="data_devolucao")
	private String dataDevolucao;
	
	@ManyToOne
	@JoinColumn(name="id_colaborador_fk")
	private Colaborador colaborador;
	
	public Monitor() {
		super();
	}

	public Monitor(Long id, String marca, String modelo, String dataCompra, String situacao, String dataEmprestimo,
			String dataDevolucao, Colaborador colaborador) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.dataCompra = dataCompra;
		this.situacao = situacao;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.colaborador = colaborador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
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
		Monitor other = (Monitor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}