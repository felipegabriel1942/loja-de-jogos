package br.com.lojajogos.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.lojajogos.model.Jogo;
import br.com.lojajogos.repository.JogoRepository;
import lombok.Getter;
import lombok.Setter;

public class JogoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter
	@Setter
	private JogoRepository jr;
	
	
	
	public void cadastrarJogo(Jogo jogo) {
		jr.salva(jogo);
	}
	
	public List<Jogo> listarJogos() {
		return jr.listar();
	}
	
	
}
