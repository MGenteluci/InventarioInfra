package model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import model.Colaborador;

public class ColaboradorDAO {

	private EntityManager manager;
	
	public ColaboradorDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Colaborador salvar(Colaborador c) {
		this.manager.getTransaction().begin();
		Colaborador retorno = this.manager.merge(c);
		this.manager.getTransaction().commit();
		return retorno;
	}
	
	public Colaborador obter(Long id) {
		return this.manager.find(Colaborador.class, id);
	}
	
	public List<Colaborador> listar(){
		String jpql = "from Colaborador c where c.situacao='Ativo'";
		return this.manager.createQuery(jpql, Colaborador.class).getResultList();
	}
	
}