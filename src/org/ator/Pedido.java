package org.ator;

import java.sql.Date;

public class Pedido {

	/*
	 * Código -> idPedido int
	 * Data do Pedido -> dataPedido Date
	 */
	
	private Date dataPedido;
	private int idPedido;
	
	public Date getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
}
