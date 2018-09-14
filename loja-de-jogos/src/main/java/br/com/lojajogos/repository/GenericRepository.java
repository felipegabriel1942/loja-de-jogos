package br.com.lojajogos.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("rawtypes")
public class GenericRepository<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Class classe;
	
	@Getter
	@Setter
	private EntityManager em;
	
	
	public void iniciarTransacao() {
		if(em.getTransaction().isActive() == false) {
			em.getTransaction().begin();
		}
	}
	
	public void rollbackTransacao() {
		iniciarTransacao();
		em.getTransaction().rollback();
	}
	
	public void commitTransacao() {
		iniciarTransacao();
		em.getTransaction().commit();
	}
	
	public boolean persist(T objeto) {
		try {
			iniciarTransacao();
			em.persist(objeto);
			commitTransacao();
			return true;
		} catch (Exception e) {
			rollbackTransacao();
			return false;
		}
	}
	

}
