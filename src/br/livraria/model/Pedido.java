package br.livraria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class Pedido {
	
	private Integer idPedido;
	private int totalPedido;
	private List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();
	private ItemPedido itens;
	
	
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public int getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(int totalPedido) {
		this.totalPedido = totalPedido;
	}
	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}
	public void setItensPedidos(List<ItemPedido> pedidos) {
		this.itensPedidos.add(itens);
	}
	public ItemPedido getItens() {
		return itens;
	}
	public void setItens(ItemPedido itens) {
		this.itens = itens;
	}
	public Pedido() {
		super();
	}
	
	public Pedido(Integer idPedido, int totalPedido, Vector<ItemPedido> pedidos) {
		super();
		this.idPedido = idPedido;
		this.totalPedido = totalPedido;
		this.itensPedidos = pedidos;
	}
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", totalPedido=" + totalPedido + ", pedidos=" + itensPedidos + "]";
	}
	
	
	
	

}
