package org.atores;

import java.util.Date;

public class Livro {

	//código do livro, nome do Livro, identificação de sua editora, gênero, data de publicação, nome dos autores, quantidade em estoque. 
	private int codLivro;
	
	private String titulo;
	private Editora editora;
	private String genero;
	private Date dataPub;
	private String[] autores;
	private int qtdEstoque;
	
	public int getCodLivro() {
		return codLivro;
	}
	
	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
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
	
	public String[] getAutores() {
		return autores;
	}
	
	public void setAutores(String[] autores) {
		this.autores = autores;
	}
	
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
}
