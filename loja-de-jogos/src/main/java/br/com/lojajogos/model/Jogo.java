package br.com.lojajogos.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_jogo")
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_jogo", nullable = false, columnDefinition = "serial")
	@Getter
	@Setter
	private Long pkJogo;

	@Column(name = "nome_jogo", nullable = false, length = 255)
	@Getter
	@Setter
	private String nomeJogo;

	@Column(name = "genero_jogo", nullable = false, length = 255)
	@Getter
	@Setter
	private String generoJogo;

	@Column(name = "valor_jogo", nullable = false, precision = 10, scale = 2)
	@Getter
	@Setter
	private float valorJogo;
	
	@Column(name = "hora_do_cadastro", nullable = false)
	@Getter
	@Setter
	private Timestamp horaDeCadastro;
	
	@ManyToMany(mappedBy="jogos")
	@Getter
	@Setter
	private List<Venda> vendas;
	
	

	public Jogo() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkJogo == null) ? 0 : pkJogo.hashCode());
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
		Jogo other = (Jogo) obj;
		if (pkJogo == null) {
			if (other.pkJogo != null)
				return false;
		} else if (!pkJogo.equals(other.pkJogo))
			return false;
		return true;
	}

}
