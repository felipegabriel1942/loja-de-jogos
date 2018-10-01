package br.com.lojajogos.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "genero")
public class Genero implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_genero", nullable = false, columnDefinition = "serial")
	@Getter
	@Setter
	private Long pkGenero;
	
	
	@Column(name = "nome_genero", nullable = false, length = 255)
	@Getter
	@Setter
	private String nomeGenero;


	public Genero() {
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pkGenero == null) ? 0 : pkGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (pkGenero == null) {
			if (other.pkGenero != null)
				return false;
		} else if (!pkGenero.equals(other.pkGenero))
			return false;
		return true;
	}
	
	
	
	
	
}
