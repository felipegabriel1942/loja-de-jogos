package br.com.lojajogos.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.lojajogos.model.Genero;
import br.com.lojajogos.util.EntityManagerUtil;
import lombok.Getter;
import lombok.Setter;

public class GeneroRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter
	@Setter
	private Genero genero;
	
	@Getter
	@Setter
	private List<Genero> listaDeGenero;
	
	@SuppressWarnings("unchecked")
	public List<Genero> listarGeneros(){
		EntityManager em = EntityManagerUtil.getEntityManager();
		Query q = em.createQuery("select g from Genero g", Genero.class);
		
		listaDeGenero = q.getResultList();
		
		return listaDeGenero;
	}

}
