package org.ator;

public class Funcionario {

	/*
	 * Código -> idFunc int
	 * CPF -> cpf String
	 * Nome -> nome String
	 * Endereço -> endereco String
	 * Cidade -> cidade String
	 * Estado -> estado String
	 * Telefone -> telefone String
	 * E-mail -> email String
	 */

	private int idFunc;
	private String cpf;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	
	public int getIdFunc() {
		return idFunc;
	}
	
	public void setIdFunc(int codFunc) {
		this.idFunc = codFunc;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
