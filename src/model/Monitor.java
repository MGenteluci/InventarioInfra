package model;

public class Monitor {

	private String marca, modelo;
	private int patrimonio, id, colaborador;
	
	public Monitor(int patrimonio, String marca, String modelo, int colaborador, int id) {
		this.marca = marca;
		this.modelo = modelo;
		this.colaborador = colaborador;
		this.patrimonio = patrimonio;
		this.id = id;
	}
	
	public Monitor(int patrimonio, String marca, String modelo, int colaborador) {
		this.marca = marca;
		this.modelo = modelo;
		this.colaborador = colaborador;
		this.patrimonio = patrimonio;
	}
	
	public Monitor(){
		
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
	
	public int getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(int colaborador) {
		this.colaborador = colaborador;
	}
	
	public int getPatrimonio() {
		return patrimonio;
	}
	
	public void setPatrimonio(int patrimonio) {
		this.patrimonio = patrimonio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}