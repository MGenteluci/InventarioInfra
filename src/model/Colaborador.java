package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_colaboradores")
@SequenceGenerator(name="tab_colaboradores_pk", sequenceName="seq_colaboradores_pk", allocationSize=1)
public class Colaborador {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tab_colaboradores_pk")
	private Long id;
	
	private String nome;
	
	private String usuario;
	
	private String email;
	
	private String local;
	
	@Column(name="data_admissao")
	private String dataAdmissao;
	
	@Column(name="data_demissao")
	private String dataDemissao;
	
	private String situacao;
	
	@OneToMany(mappedBy="colaborador", fetch=FetchType.LAZY)
	private List<Software> softwares;
	
	@OneToMany(mappedBy="colaborador", fetch=FetchType.LAZY)
	private List<Monitor> monitores;
	
	@OneToMany(mappedBy="colaborador", fetch=FetchType.LAZY)
	private List<Equipamento> equipamentos;
	
	public Colaborador() {
		super();
	}

	public Colaborador(Long id, String nome, String usuario, String email, String local, String dataAdmissao,
			String dataDemissao, String situacao, List<Software> softwares, List<Monitor> monitores,
			List<Equipamento> equipamentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.email = email;
		this.local = local;
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.situacao = situacao;
		this.softwares = softwares;
		this.monitores = monitores;
		this.equipamentos = equipamentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(String dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public List<Software> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}

	public List<Monitor> getMonitores() {
		return monitores;
	}

	public void setMonitores(List<Monitor> monitores) {
		this.monitores = monitores;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
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
		Colaborador other = (Colaborador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}