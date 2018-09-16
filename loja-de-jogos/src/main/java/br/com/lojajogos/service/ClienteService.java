package br.com.lojajogos.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;

public class ClienteService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	@Getter
	@Setter
	private ClienteRepository cr;
	
	public void cadastrarClienteNoSistema(Cliente cliente) {
		cr.cadastrarCliente(cliente);
	}
}
