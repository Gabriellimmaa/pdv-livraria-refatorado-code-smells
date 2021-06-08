package br.livraria.model;

import java.util.Date;
import java.util.Vector;

public class Pedido {

	private int id;
	private Funcionario funcionario;
	private Date dataVendida;
	private double totalPreco;

	public void setTotalPreco(double totalPreco) {
		this.totalPreco = totalPreco;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Date getDataVendida() {
		return dataVendida;
	}
	public void setDataVendida(Date dataVendida) {
		this.dataVendida = dataVendida;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getTotalPreco() {
		return totalPreco;
	}
	public void setTotalPreco(Vector<Item> itensPedidos) {
		
		double total = 0;
		for(int i = 0; i < itensPedidos.size(); i++) {
			total += itensPedidos.get(i).getTotalPreco();
		}
		
		this.totalPreco = total;
	}
}