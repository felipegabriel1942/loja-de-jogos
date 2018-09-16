package br.com.lojajogos.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.util.EntityManagerUtil;
import lombok.Getter;
import lombok.Setter;

public class ClienteRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	@Getter
	@Setter
	private Cliente cliente;
	
	public void cadastrarCliente(Cliente cliente) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}
}
