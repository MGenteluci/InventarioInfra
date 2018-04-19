package model;

public class Software {

	private int id, colaborador;
    private String serial, nome, versao;
    
	public Software(String serial, String nome, String versao, int colaborador) {
		this.serial = serial;
		this.nome = nome;
		this.versao = versao;
		this.colaborador = colaborador;
	}
	
	public Software(){
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public int getColaborador() {
		return colaborador;
	}

	public void setColaborador(int colaborador) {
		this.colaborador = colaborador;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
    
}