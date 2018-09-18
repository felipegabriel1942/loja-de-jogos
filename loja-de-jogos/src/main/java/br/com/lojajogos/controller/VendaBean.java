package br.com.lojajogos.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import br.com.lojajogos.converter.ClienteConverter;
import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.service.ClienteService;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class VendaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String nomeCliente;

	@Inject
	@Getter
	@Setter
	private Cliente clienteEmAtendimento;

	@Inject
	@Getter
	@Setter
	private ClienteConverter clienteConverter;

	@Inject
	@Getter
	@Setter
	@ManagedProperty("#{clienteService}")
	private ClienteService cs;
	
	@PostConstruct
	public void init() {
		clienteEmAtendimento = new Cliente();
	}

	public List<Cliente> pesquisaDeCliente(String nome) {
		List<Cliente> clientes = cs.pesquisarClientesCadastradosPorNome(nome);
		List<Cliente> clientesFiltrados = new ArrayList<Cliente>();
		
		
		for (int i = 0; i < clientes.size(); i++) {
			Cliente clientePesquisado = clientes.get(i);
			if(clientePesquisado.getNomeCliente().startsWith(nome)) {
				clientesFiltrados.add(clientePesquisado);
			}
		}

		return clientesFiltrados;
	}
	
	public Cliente setarClienteEmAtendimento(Long codigo) {
		return clienteEmAtendimento = cs.pesquisarClientePorCodigo(codigo);
	}

}
