package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Monitor;
import model.Software;

public class SoftwareDAO {

	private EntityManager manager;
	
	public SoftwareDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Software salvar(Software s) {
		this.manager.getTransaction().begin();
		Software retorno = this.manager.merge(s);
		this.manager.getTransaction().commit();
		return retorno;
	}
	
	public void remover(Software s) {
		this.manager.getTransaction().begin();
		this.manager.remove(s);
		this.manager.getTransaction().commit();
	}
	
	public Software obter(Long id) {
		return this.manager.find(Software.class, id);
	}
	
	public List<Software> listar(){
		String jpql = "from Software s";
		return this.manager.createQuery(jpql, Software.class).getResultList();
	}
	
}