package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Colaborador;

public class DaoColaborador {
    
	private Connection connection;
	
    public DaoColaborador() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionar(Colaborador colaborador) {
        
        String sql = "insert into colaborador(nome, local, usuario) values(?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, colaborador.getNome());
            stmt.setString(2, colaborador.getLocal());
            stmt.setString(3, colaborador.getUsuario());
            	stmt.execute();
            stmt.close();
        }catch(SQLException e) {
            System.out.println("Erro na operação: " + e.getMessage());
        }
        
    }
    
    public List<Colaborador> pesquisar() {
		String sql = "select * from colaborador order by nome";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
			
			while(rs.next()){
				Colaborador c = new Colaborador();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setLocal(rs.getString("local"));
				c.setUsuario(rs.getString("usuario"));
				
				colaboradores.add(c);
			}
			
			rs.close();	
			stmt.close();
			
			return colaboradores;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
    
    public void deletar(int id){
    	String sql = "delete from colaborador where id=?";
    	
    	try{
    		PreparedStatement stmt = connection.prepareStatement(sql);
    			stmt.setInt(1, id);
    			
    			stmt.execute();
    			stmt.close();
    	}catch(SQLException e){
    		throw new RuntimeException(e);
    	}
    	
    }
    
    public void alterar(String nome, String local, String usuario, int id){
    	String sql = "update colaborador set nome=?, local=?, usuario=? where id=?";
    			
    	try{
    		PreparedStatement stmt = connection.prepareStatement(sql);
    			stmt.setString(1, nome);
    			stmt.setString(2, local);
    			stmt.setString(3, usuario);
    			stmt.setInt(4, id);
    		
    			stmt.execute();
    			stmt.close();
    		
    	}catch(SQLException e){
    		throw new RuntimeException(e);
    	}
    			
    }
    
}
