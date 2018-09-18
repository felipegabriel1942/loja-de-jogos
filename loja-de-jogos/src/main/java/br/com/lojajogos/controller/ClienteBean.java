package br.com.lojajogos.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.service.ClienteService;
import br.com.lojajogos.util.MensagensUtil;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@Getter
	@Setter
	private ClienteService cs;

	@Inject
	@Getter
	@Setter
	private Cliente cliente;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
	}

	public void salvarCliente() {
		try {
			cs.cadastrarClienteNoSistema(cliente);
			cliente = new Cliente();
			MensagensUtil.mensagemSucesso("Cliente cadastrado com sucesso");

		} catch (Exception e) {
			MensagensUtil.mensagemErro("Erro ao cadastrar o cliente");
		}
	}
	
	
}
