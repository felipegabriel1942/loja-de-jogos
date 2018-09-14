package br.com.lojajogos.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.lojajogos.model.Jogo;
import br.com.lojajogos.util.EntityManagerUtil;
import lombok.Getter;
import lombok.Setter;

public class JogoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@Getter
	@Setter
	private Jogo jogo;

	@Getter
	@Setter
	private List<Jogo> jogos;

	

	public void salva(Jogo jogo) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(jogo);
		em.getTransaction().commit();
		
	}

	@SuppressWarnings("unchecked")
	public List<Jogo> listar() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query q = em.createQuery("select j from Jogo j", Jogo.class);

		jogos = q.getResultList();
		
		return jogos;
	}
}
