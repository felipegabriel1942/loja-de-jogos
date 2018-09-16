package br.com.lojajogos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "clienteGenerator", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "clienteGenerator")
	@Column(name = "pk_jogo", nullable = false, columnDefinition = "serial")
	@Getter
	@Setter
	private Long pkcliente;

	@Column(name = "nome_cliente", nullable = false, length = 255)
	@Getter
	@Setter
	private String nomeCliente;

	@Column(name = "data_nascimento_cliente", nullable = false, length = 255)
	@Getter
	@Setter
	private Date dataDeNascimentoCliente;

	@Column(name = "email_cliente", nullable = false, length = 255)
	@Getter
	@Setter
	private String emailCliente;

	public Cliente() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkcliente == null) ? 0 : pkcliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (pkcliente == null) {
			if (other.pkcliente != null)
				return false;
		} else if (!pkcliente.equals(other.pkcliente))
			return false;
		return true;
	}

}
