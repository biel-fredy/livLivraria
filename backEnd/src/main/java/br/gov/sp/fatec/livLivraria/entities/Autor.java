package br.gov.sp.fatec.livLivraria.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUTORES")
public class Autor {
	
	@Id
	@Column(name = "AUT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AUT")
	@SequenceGenerator(name = "SQ_AUT", sequenceName = "SQ_AUT", allocationSize = 1)
	private Long id;

	@Column(name = "AUT_NOME")
	private String nome;

	@ManyToMany(mappedBy = "autores")
	private List<Livro> livros = new ArrayList<Livro>();

	public Autor() {
	}

	public Autor(String nome) {
		super();
		this.nome = nome;
	}

	public void addLivro(Livro livro) {
		this.livros.add(livro);
	}

	public void removeLivro(int indexLivro) {
		this.livros.remove(indexLivro);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Livro> getLivros() {
		return livros;
	}

}
