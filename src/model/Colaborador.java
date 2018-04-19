package model;

public class Colaborador {

	private int id;
    private String nome, local, usuario;

    public Colaborador(int id, String nome, String local, String usuario) {
        this.id = id;
    	this.nome = nome;
        this.local = local;
        this.usuario = usuario;
    }
    
    public Colaborador(String nome, String local, String usuario) {
    	this.nome = nome;
        this.local = local;
        this.usuario = usuario;
    }
    
    public Colaborador(){
    	
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
 
}