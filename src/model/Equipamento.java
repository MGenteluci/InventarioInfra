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
@Table(name="tab_equipamentos")
@SequenceGenerator(name="tab_equipamentos_pk", sequenceName="seq_equipamentos_pk", allocationSize=1)
public class Equipamento {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tab_equipamentos_pk")
	private Long id;
	
	private String hostname;
	
	private int patrimonio;
	
	private String tipo;
	
	private String modelo;
	
	private String processador;
	
	@Column(name="serial_tag")
	private String serialTag;
	
	@Column(name="service_code")
	private String serviceCode;
	
	@Column(name="data_garantia")
	private String dataGarantia;
	
	@Column(name="so_comprado")
	private String soComprado;
	
	@Column(name="so_atual")
	private String soAtual;
	
	@Column(name="ram_original")
	private String ramOriginal;
	
	@Column(name="ram_atual")
	private String ramAtual;
	
	@ManyToOne
	@JoinColumn(name="id_colaborador_fk")
	private Colaborador colaborador;
	
	public Equipamento() {
		super();
	}

	public Equipamento(Long id, String hostname, int patrimonio, String tipo, String modelo, String processador,
			String serialTag, String serviceCode, String dataGarantia, String soComprado, String soAtual,
			String ramOriginal, String ramAtual, Colaborador colaborador) {
		super();
		this.id = id;
		this.hostname = hostname;
		this.patrimonio = patrimonio;
		this.tipo = tipo;
		this.modelo = modelo;
		this.processador = processador;
		this.serialTag = serialTag;
		this.serviceCode = serviceCode;
		this.dataGarantia = dataGarantia;
		this.soComprado = soComprado;
		this.soAtual = soAtual;
		this.ramOriginal = ramOriginal;
		this.ramAtual = ramAtual;
		this.colaborador = colaborador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(int patrimonio) {
		this.patrimonio = patrimonio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getSerialTag() {
		return serialTag;
	}

	public void setSerialTag(String serialTag) {
		this.serialTag = serialTag;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDataGarantia() {
		return dataGarantia;
	}

	public void setDataGarantia(String dataGarantia) {
		this.dataGarantia = dataGarantia;
	}

	public String getSoComprado() {
		return soComprado;
	}

	public void setSoComprado(String soComprado) {
		this.soComprado = soComprado;
	}

	public String getSoAtual() {
		return soAtual;
	}

	public void setSoAtual(String soAtual) {
		this.soAtual = soAtual;
	}

	public String getRamOriginal() {
		return ramOriginal;
	}

	public void setRamOriginal(String ramOriginal) {
		this.ramOriginal = ramOriginal;
	}

	public String getRamAtual() {
		return ramAtual;
	}

	public void setRamAtual(String ramAtual) {
		this.ramAtual = ramAtual;
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
		Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}