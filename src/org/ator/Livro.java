package org.ator;

import java.util.Date;

public class Livro {
	
	/*
	 * Código -> idLivro int
	 * Título -> titulo String
	 * Editora -> editora editora
	 * Gênero -> genero String
	 * Data de Publicação -> dataPub Date
	 * Autor -> autor String
	 * Quantidade em Estoque -> qtdEstoque int
 	 */

	private int idLivro;
	
	private String titulo;
	private Editora editora;
	private String genero;
	private Date dataPub;
	private String autor;
	private int qtdEstoque;
	
	public int getIdLivro() {
		return idLivro;
	}
	
	public void setIdLivro(int codLivro) {
		this.idLivro = codLivro;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Editora getEditora() {
		return editora;
	}
	
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Date getDataPub() {
		return dataPub;
	}
	
	public void setDataPub(Date dataPub) {
		this.dataPub = dataPub;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
}
