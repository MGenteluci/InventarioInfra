package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Monitor;
import model.Software;

public class DaoMonitor {

	private Connection connection;
	
	public DaoMonitor(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Monitor m){
		
		String sql = "insert into monitor(patrimonio, marca, modelo, colaborador) values (?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, m.getPatrimonio());
			stmt.setString(2, m.getMarca());
			stmt.setString(3, m.getModelo());
			stmt.setInt(4, m.getColaborador());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
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
	
	public List<Monitor> pesquisar() {
		String sql = "select * from monitor order by patrimonio";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Monitor> monitores = new ArrayList<Monitor>();
			
			while(rs.next()){
				Monitor m = new Monitor();
				m.setId(rs.getInt("id"));
				m.setMarca(rs.getString("marca"));
				m.setModelo(rs.getString("modelo"));
				m.setColaborador(rs.getInt("colaborador"));
				m.setPatrimonio(rs.getInt("patrimonio"));	
				
				monitores.add(m);
			}
			
			rs.close();	
			stmt.close();
			
			return monitores;
			
		}catch (SQLException e) {
			System.out.println("Erro na operação: " + e.getMessage());
		}
		
		return null;
	}
	
	public void deletar(int id){
		String sql = "delete from monitor where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, id);
				
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(int patrimonio, String marca, String modelo, int colaborador, int id){
		String sql = "update monitor set patrimonio=?, marca=?, modelo=?, colaborador=? where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, patrimonio);
				stmt.setString(2, marca);
				stmt.setString(3, modelo);
				stmt.setInt(4, colaborador);	
				stmt.setInt(5, id);
				
			stmt.execute();
			stmt.close();
				
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
