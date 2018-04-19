package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Equipamento;

public class DaoEquipamento {

	private Connection connection;
	
	public DaoEquipamento(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Equipamento equipamento){	
		
		String sql = "insert into equipamento(patrimonio, hostname, situacao, tipo, modelo, processador, ramoriginal, ramatual, serviceTag, serviceCode, garantia, observacao, colaborador) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, equipamento.getPatrimonio());
			stmt.setString(2, equipamento.getHostname());
			stmt.setString(3, equipamento.getSituacao());
			stmt.setString(4, equipamento.getTipo());
			stmt.setString(5, equipamento.getModelo());
			stmt.setString(6, equipamento.getProcessador());
			stmt.setString(7, equipamento.getRamOriginal());
			stmt.setString(8, equipamento.getRamAtual());
			stmt.setString(9, equipamento.getServiceTag());
			stmt.setString(10, equipamento.getServiceCode());
			stmt.setString(11, equipamento.getGarantia());
			stmt.setString(12, equipamento.getObservacao());
			stmt.setInt(13, equipamento.getColaborador());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Equipamento> pesquisar(){
		
		String sql = "select * from equipamento order by hostname";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
			
			while(rs.next()){
				Equipamento e = new Equipamento();
				e.setId(rs.getInt("id"));
				e.setPatrimonio(rs.getInt("patrimonio"));
				e.setHostname(rs.getString("hostname"));
				e.setSituacao(rs.getString("situacao"));
				e.setTipo(rs.getString("tipo"));
				e.setModelo(rs.getString("modelo"));
				e.setProcessador(rs.getString("processador"));
				e.setRamOriginal(rs.getString("ramOriginal"));
				e.setRamAtual(rs.getString("ramAtual"));
				e.setServiceTag(rs.getString("serviceTag"));
				e.setServiceCode(rs.getString("serviceCode"));
				e.setGarantia(rs.getString("garantia"));
				e.setObservacao(rs.getString("observacao"));
				e.setColaborador(rs.getInt("colaborador"));
				
				equipamentos.add(e);
			}
			
			rs.close();
			stmt.close();
			
			return equipamentos;
			
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
	
	public void deletar(int id){
		String sql = "delete from equipamento where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public void alterar(int patrimonio, String hostname, String situacao, String tipo, String modelo, String processador, String ramOriginal, String ramAtual, String serviceTag,
			String serviceCode, String garantia, String observacao, int colaborador, int id){
		String sql = "update equipamento set patrimonio=?, hostname=?, situacao=?, tipo=?, modelo=?, processador=?, ramOriginal=?, ramAtual=?, serviceTag=?, serviceCode=?, garantia=?, observacao=?, colaborador=? where id=?";
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, patrimonio);
				stmt.setString(2, hostname);
				stmt.setString(3, situacao);
				stmt.setString(4, tipo);
				stmt.setString(5, modelo);
				stmt.setString(6, processador);
				stmt.setString(7, ramOriginal);
				stmt.setString(8, ramAtual);
				stmt.setString(9, serviceTag);
				stmt.setString(10, serviceCode);
				stmt.setString(11, garantia);
				stmt.setString(12, observacao);
				stmt.setInt(13, colaborador);
				stmt.setInt(14, id);
			
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
}
