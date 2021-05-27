package org.atores;

public class Funcionario {

	//CPF, nome, endereço, cidade, estado, telefone, e-mail, e código do funcionário. 

	private int codFunc;
	
	private String cpf;
	private String nome;
	private String endereco;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	
	public int getCodFunc() {
		return codFunc;
	}
	
	public void setCodFunc(int codFunc) {
		this.codFunc = codFunc;
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
