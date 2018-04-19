package model;

public class Equipamento {
	
	private int id, patrimonio, colaborador;
    private String hostname, situacao, tipo, modelo, processador, ramOriginal, ramAtual, serviceTag,
    serviceCode, garantia, observacao;
    
    public Equipamento(int id, int patrimonio, String hostname, String situacao, String tipo, String modelo, String processador,
            String ramOriginal, String ramAtual, String serviceTag, String serviceCode, String garantia, String observacao, int colaborador) {
    	this.id = id;
    	this.patrimonio = patrimonio;
        this.hostname = hostname;
        this.situacao = situacao;
        this.tipo = tipo;
        this.modelo = modelo;
        this.processador = processador;
        this.ramOriginal = ramOriginal;
        this.ramAtual = ramAtual;
        this.serviceTag = serviceTag;
        this.serviceCode = serviceCode;
        this.garantia = garantia;
        this.observacao = observacao;
        this.colaborador = colaborador;
    }
    
    public Equipamento(int patrimonio, String hostname, String situacao, String tipo, String modelo, String processador,
            String ramOriginal, String ramAtual, String serviceTag, String serviceCode, String garantia, String observacao, int colaborador) {
    	this.patrimonio = patrimonio;
        this.hostname = hostname;
        this.situacao = situacao;
        this.tipo = tipo;
        this.modelo = modelo;
        this.processador = processador;
        this.ramOriginal = ramOriginal;
        this.ramAtual = ramAtual;
        this.serviceTag = serviceTag;
        this.serviceCode = serviceCode;
        this.garantia = garantia;
        this.observacao = observacao;
        this.colaborador = colaborador;
    }
    
    public Equipamento(){
    	
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

	public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
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

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

	public int getPatrimonio() {
		return patrimonio;
	}

	public void setPatrimonio(int patrimonio) {
		this.patrimonio = patrimonio;
	}

	public int getColaborador() {
		return colaborador;
	}

	public void setColaborador(int colaborador) {
		this.colaborador = colaborador;
	}
    
}