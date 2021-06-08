package br.livraria.model;

public class ItemPedido {

	private Integer idItemPedido;
	private Livro idLivro;
	private Pedido idPedido;
	private int qtdVendida;
	private int total;


	public Integer getIdItemPedido() {
		return idItemPedido;
	}
	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}
	public Livro getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Livro idLivro) {
		this.idLivro = idLivro;
	}
	public Pedido getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Pedido idPedido) {
		this.idPedido = idPedido;
	}
	public int getQtdVendida() {
		return qtdVendida;
	}
	public void setQtdVendida(int qtdVendida) {
		this.qtdVendida = qtdVendida;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public ItemPedido(Integer idItemPedido, Livro idLivro, Pedido idPedido, int qtdVendida, int total) {
		super();
		this.idItemPedido = idItemPedido;
		this.idLivro = idLivro;
		this.idPedido = idPedido;
		this.qtdVendida = qtdVendida;
		this.total = total;
	}

	public ItemPedido() {
		super();
	}

	@Override
	public String toString() {
		return "ItemPedido [idItemPedido=" + idItemPedido + ", idLivro=" + idLivro + ", idPedido=" + idPedido
				+ ", qtdVendida=" + qtdVendida + ", total=" + total + "]";
	}





}