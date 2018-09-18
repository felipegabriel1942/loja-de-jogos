package br.com.lojajogos.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.util.EntityManagerUtil;
import lombok.Getter;
import lombok.Setter;

public class ClienteRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	@Getter
	@Setter
	private Cliente cliente;

	@Getter
	@Setter
	private List<Cliente> clientes;

	public void cadastrarCliente(Cliente cliente) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> pesquisarClientesPorNome(String nome) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query q = em.createQuery("Select c From Cliente c where c.nomeCliente like :clientePesquisado", Cliente.class)
				.setParameter("clientePesquisado", nome + "%");

		clientes = q.getResultList();

		return clientes;

	}

	public Cliente pesquisarClientesPorPK(Long codigo) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query q = em.createQuery("Select c From Cliente c where c.pkcliente = :codigoCliente", Cliente.class)
				.setParameter("codigoCliente", codigo);

		cliente = (Cliente) q.getSingleResult();

		return cliente;

	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query q = em.createQuery("Select c From Cliente c", Cliente.class);

		clientes = q.getResultList();

		return clientes;

	}
}
