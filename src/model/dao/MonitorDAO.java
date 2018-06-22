package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Monitor;

public class MonitorDAO {

private EntityManager manager;
	
	public MonitorDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Monitor salvar(Monitor m) {
		this.manager.getTransaction().begin();
		Monitor retorno = this.manager.merge(m);
		this.manager.getTransaction().commit();
		return retorno;
	}
	
	public void remover(Monitor m) {
		this.manager.getTransaction().begin();
		this.manager.remove(m);
		this.manager.getTransaction().commit();
	}
	
	public Monitor obter(Long id) {
		return this.manager.find(Monitor.class, id);
	}
	
	public List<Monitor> listar(){
		String jpql = "from Monitor m";
		return this.manager.createQuery(jpql, Monitor.class).getResultList();
	}
	
}