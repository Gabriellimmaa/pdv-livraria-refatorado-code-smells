package org.ator;

import java.util.Date;

public class Venda {

	/*
	 * Código -> idVenda int
	 * Livro -> livro Livro	
	 * Quantidade -> quantidade int
	 * Valor Unitário -> valorUnit int
	 * Data da Venda -> dataVenda Date
	 * Funcionario -> funcionario Funcionario
	*/
	
	private int idVenda;
	private Livro livro;
	private int quantidade;
	private int valorUnit;
	private Date dataVenda;
	private Funcionario funcionario;
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getValorUnit() {
		return valorUnit;
	}
	
	public void setValorUnit(int valorUnit) {
		this.valorUnit = valorUnit;
	}
	
	public Date getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
