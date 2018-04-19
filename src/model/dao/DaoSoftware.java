package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Software;

public class DaoSoftware {
    
	private Connection connection;
	
    public DaoSoftware() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionar(Software software) {
        
        String sql = "insert into software(serial, nome, versao, colaborador) values(?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, software.getSerial());
            stmt.setString(2, software.getNome());
            stmt.setString(3, software.getVersao());
            stmt.setInt(4, software.getColaborador());
            	stmt.execute();
            stmt.close();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
	public List<Software> pesquisar() {
		String sql = "select * from software order by colaborador";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Software> softwares = new ArrayList<Software>();
			
			while(rs.next()){
				Software s = new Software();
				s.setId(rs.getInt("id"));
				s.setSerial(rs.getString("serial"));
				s.setNome(rs.getString("nome"));
				s.setVersao(rs.getString("versao"));
				s.setColaborador(rs.getInt("colaborador"));
				
				softwares.add(s);
			}
			
			rs.close();	
			stmt.close();
			
			return softwares;
			
		}catch (SQLException e) {
			System.out.println("Erro na operação: " + e.getMessage());
		}
		return null;

	}
    
	public String consultarUm(int id){
		
		String sql = "select nome from colaborador where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				String retorno = rs.getString(1);
				return retorno;
			}
			
			rs.close();
			stmt.close();
			return null;
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	public void deletar(int id){
		String sql = "delete from software where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, id);
				
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void alterar(String serial, String nome, String versao, int colaborador, int id){
		String sql = "update software set serial=?, nome=?, versao=?, colaborador=? where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, serial);
				stmt.setString(2, nome);
				stmt.setString(3, versao);
				stmt.setInt(4, colaborador);
				stmt.setInt(5, id);
				
				stmt.execute();
				stmt.close();
				
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}