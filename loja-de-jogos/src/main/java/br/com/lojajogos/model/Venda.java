package br.com.lojajogos.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Setter;

import lombok.Getter;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "vendaGenerator", sequenceName = "VENDA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "vendaGenerator")
	@Column(name = "pk_venda", nullable = false, columnDefinition = "serial")
	@Getter
	@Setter
	private Long pkVenda;

	@Column(name = "fk_cliente", nullable = false)
	@Getter
	@Setter
	private Integer fkCliente;

	@Column(name = "dt_venda", nullable = false)
	@Getter
	@Setter
	private Date dataVenda;

	@ManyToMany
	@Getter
	@Setter
	private List<Jogo> jogos;
	
	public Venda() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkVenda == null) ? 0 : pkVenda.hashCode());
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
		Venda other = (Venda) obj;
		if (pkVenda == null) {
			if (other.pkVenda != null)
				return false;
		} else if (!pkVenda.equals(other.pkVenda))
			return false;
		return true;
	}
	
	

}
