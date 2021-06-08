package br.livraria.model;

public class Item {

	private int id;
	private Livro livro;
	private Pedido pedido;
	private int qtdVendida;
	private double totalPreco;

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public int getQtdVendida() {
		return qtdVendida;
	}
	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}
	public double getTotalPreco() {
		return totalPreco;
	}
	public void setTotalPreco() {
		this.totalPreco = livro.getPrecoUnit() * qtdVendida;
	}
	public void setTotalPreco(double totalPreco) {
		this.totalPreco = totalPreco;
	}

}