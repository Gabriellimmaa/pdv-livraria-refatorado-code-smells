package br.livraria.model;

import java.util.Date;

public class Livro {

	private int id;
	private String titulo;
	private String genero;
	private Date dataPublicada;
	private String autor;
	private int qtdEstoque;
	private double precoUnit;
	private Editora editora;
	
	public double getPrecoUnit() {
		return precoUnit;
	}
	public void setPrecoUnit(double precoUnit) {
		this.precoUnit = precoUnit;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getDataPublicada() {
		return dataPublicada;
	}
	public void setDataPublicada(Date dataPublicada) {
		this.dataPublicada = dataPublicada;
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
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	
}
