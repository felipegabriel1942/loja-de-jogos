package br.com.lojajogos.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import br.com.lojajogos.model.Cliente;
import br.com.lojajogos.repository.ClienteRepository;
import br.com.lojajogos.util.MensagensUtil;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name="clienteService",eager = true)
@ApplicationScoped
public class ClienteService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	@Getter
	@Setter
	private ClienteRepository cr;

	public void cadastrarClienteNoSistema(Cliente cliente) {
		cr.cadastrarCliente(cliente);
	}

	public List<Cliente> pesquisarClientesCadastradosPorNome(String nome) {
		try {
			return cr.pesquisarClientesPorNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
			MensagensUtil.mensagemErro("Erro ao listar clientes");
			return null;
		}
	}
	
	public List<Cliente> listarTodosOsClientes(){
		return cr.listarClientes();
	}
	
	public Cliente pesquisarClientePorCodigo(Long codigo) {
		return cr.pesquisarClientesPorPK(codigo);
	}
}
