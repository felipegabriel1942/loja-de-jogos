package br.com.lojajogos.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.lojajogos.model.Jogo;
import br.com.lojajogos.service.JogoService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class JogoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter
	@Setter
	private JogoService js;
	
	@Inject
	@Getter
	@Setter
	private Jogo jogo;
	
	@Getter
	@Setter
	private List<Jogo> listaJogos;
	
	@PostConstruct
	public void init() {
		jogo = new Jogo();
		listaJogos = listarJogosNaTela();
	}
	
	public void salvarJogo() {
		js.cadastrarJogo(jogo);
		jogo = new Jogo();
		listaJogos = listarJogosNaTela();
		saveMessage();
	}
	
	public List<Jogo> listarJogosNaTela() {
		return js.listarJogos();
	}
	
	public void saveMessage() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "=)", "Jogo cadastrado com sucesso"));
	}

}
