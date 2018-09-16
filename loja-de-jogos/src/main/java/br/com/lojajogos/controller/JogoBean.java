package br.com.lojajogos.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.lojajogos.model.Jogo;
import br.com.lojajogos.service.JogoService;
import br.com.lojajogos.util.MensagensUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class JogoBean implements Serializable {

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
	}

	public void salvarJogo() {
		try {
			js.cadastrarJogo(jogo);
			jogo = new Jogo();
			MensagensUtil.mensagemSucesso("Jogo cadastrado com sucesso");
		} catch (Exception e) {
			MensagensUtil.mensagemErro("Erro ao cadastrar jogo");
		}

	}

	public List<Jogo> listarJogosNaTela() {
		return js.listarJogos();
	}

}
