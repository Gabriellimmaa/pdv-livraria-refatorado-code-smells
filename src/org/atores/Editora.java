package org.atores;

public class Editora {

	//nome, CNPJ e endereço.
	
	private int codEditora;
	
	private String nome;
	private String cnpj;
	private String endereco;
	
	public int getCodEditora() {
		return codEditora;
	}
	
	public void setCodEditora(int codEditora) {
		this.codEditora = codEditora;
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
	
	public void setCnpj(String cNPJ) {
		cnpj = cNPJ;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
