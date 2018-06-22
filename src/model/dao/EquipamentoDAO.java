package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Equipamento;

public class EquipamentoDAO {

	private EntityManager manager;
	
	public EquipamentoDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Equipamento salvar(Equipamento e) {
		this.manager.getTransaction().begin();
		Equipamento retorno = this.manager.merge(e);
		this.manager.getTransaction().commit();
		return retorno;
	}
	
	public void remover(Equipamento e) {
		this.manager.getTransaction().begin();
		this.manager.remove(e);
		this.manager.getTransaction().commit();
	}
	
	public Equipamento obter(Long id) {
		return this.manager.find(Equipamento.class, id);
	}
	
	public List<Equipamento> listar(){
		String jpql = "from Equipamento e";
		return this.manager.createQuery(jpql, Equipamento.class).getResultList();
	}
	
}