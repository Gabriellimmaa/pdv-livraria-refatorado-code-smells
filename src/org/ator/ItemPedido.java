package org.ator;

public class ItemPedido {
	
	/*
	 * Código -> idItemPedido int  
	 * Valor Unitário -> valorUnit int
	 * Quantidade -> quantidade int
	 * Livro -> livro Livro
	*/
	
	private int idItemPedido;
	private int valorUnit;
	private int quantidade;
	private Livro livro;
	
	public int getValorUnit() {
		return valorUnit;
	}
	
	public void setValorUnit(int valorVendido) {
		this.valorUnit = valorVendido;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public int getIdItemPedido() {
		return idItemPedido;
	}
	
	public void setIdItemPedido(int idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
}
