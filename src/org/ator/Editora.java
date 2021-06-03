package org.ator;

public class Editora {
	
	/*
	 * Código -> idEditora int
	 * Nome -> nome String
	 * CNPJ -> cnpj String
	 * Endereco -> endereco String
	 */

	private int idEditora;
	private String nome;
	private String cnpj;
	private String endereco;
	
	public int getIdEditora() {
		return idEditora;
	}
	
	public void setIdEditora(int codEditora) {
		this.idEditora = codEditora;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
